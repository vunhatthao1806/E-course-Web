import { useContext, useState } from "react";
import { MyDispatchContext, MyUserContext } from "../App";
import APIs, { authAPIs, endpoints } from "../configs/APIs";
import cookie from "react-cookies";
import { Navigate } from "react-router";
import { Button, Col, Form, Image, Row } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Link } from "react-router-dom";
import loginImage from "../image/login.png";
import "../css/Login.css";
import { faFacebook, faGoogle } from "@fortawesome/free-brands-svg-icons";
import { GoogleLogin, GoogleOAuthProvider } from "@react-oauth/google";

const Login = () => {
  const user = useContext(MyUserContext);
  const dispatch = useContext(MyDispatchContext);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const loadLogin = async (e) => {
    e.preventDefault();

    let res = await APIs.post(endpoints["login"], {
      username: username,
      password: password,
    });
    cookie.save("token", res.data);

    let user = await authAPIs().get(endpoints["current-user"]);
    cookie.save("user", user.data);

    dispatch({
      type: "login",
      payload: user.data,
    });
  };

  const handleGoogleLogin = async (response) => {
    const googleToken = response.credential;
    console.log(googleToken);

    // Gửi googleToken lên server để xác thực và nhận JWT
    let res = await APIs.post(endpoints["google-login"], {
      token: googleToken,
    });

    cookie.save("token", res.data);

    let user = await authAPIs().get(endpoints["current-user"]);
    cookie.save("user", user.data);

    dispatch({
      type: "login",
      payload: user.data,
    });
  };

  if (user != null) {
    return <Navigate to="/" />;
  }

  return (
    <>
      <div className="container">
        <Row>
          <Col>
            <Image className="image margin" src={loginImage} />
          </Col>
          <Col>
            <p className="text-sign-in margin">Sign in</p>
            <p style={{ textAlign: "center" }}>
              Welcome back! You've been missed!
            </p>
            <div className="d-flex button-sign-gg-fb">
              {/* Google Sign In */}
              <GoogleOAuthProvider clientId="183350919740-0pseqk6qohlp1ikdb84k9brqascucg29.apps.googleusercontent.com">
                <GoogleLogin
                  onSuccess={handleGoogleLogin}
                  onError={() => {
                    console.log("Login Failed");
                  }}
                />
              </GoogleOAuthProvider>
              <Button>
                <FontAwesomeIcon
                  style={{ marginRight: "10px" }}
                  icon={faFacebook}
                />
                Sign in with FaceBook
              </Button>
            </div>
            <Form onSubmit={loadLogin} method="post">
              <Form.Group className="mb-3" controlId="controliInputUsername">
                <Form.Label>Username: </Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Enter username"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                />
              </Form.Group>
              <Form.Group className="mb-3" controlId="controliInputPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
              </Form.Group>
              <Link
                to="/"
                className="nav-link"
                style={{ textAlign: "right", color: "red" }}
              >
                Forget password?
              </Link>
              <Button type="submit" className="button-login button-sign-gg-fb">
                Sign in
              </Button>

              <div
                className="d-flex"
                style={{ justifyContent: "center", margin: "5px" }}
              >
                <p style={{ margin: "3px" }}>Don't have an account yet? </p>
                <Link
                  to="/register"
                  className="nav-link"
                  style={{ color: "blue", fontWeight: "bold", margin: "3px" }}
                >
                  Sign up
                </Link>
              </div>
            </Form>
          </Col>
        </Row>
      </div>
    </>
  );
};

export default Login;
