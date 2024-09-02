import {
  Badge,
  Button,
  Container,
  Form,
  FormControl,
  Image,
  InputGroup,
  Nav,
  Navbar,
} from "react-bootstrap";
import "../css/Header.css";
import APIs, { endpoints } from "../configs/APIs";
import { useContext, useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCartShopping, faHeart } from "@fortawesome/free-solid-svg-icons";
import { MyCartContext, MyDispatchContext, MyUserContext } from "../App";

const Header = () => {
  const user = useContext(MyUserContext);
  const dispatch = useContext(MyDispatchContext);
  const [categories, setCategories] = useState([]);
  const [kw, setKw] = useState("");
  const nav = useNavigate();
  const [cartCounter] = useContext(MyCartContext);
  const loadCate = async () => {
    let res = await APIs.get(endpoints["categories"]);
    setCategories(res.data);
  };
  useEffect(() => {
    loadCate();
  }, []);
  const submit = (e) => {
    e.preventDefault();
    nav(`/search?q=${kw}`);
  };
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary backgroudColor">
        <Container fluid>
          {/* <Navbar.Brand href="#" className="me-auto" >ECouse Academy</Navbar.Brand> */}
          <Link to="/" className="nav-link font-size-header">
            ECouse Academy
          </Link>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Form className="d-flex mx-auto" onSubmit={submit}>
              <Form.Control
                type="search"
                placeholder="Search"
                className="me-2 input-search-header"
                aria-label="Search"
                value={kw}
                onChange={(e) => setKw(e.target.value)}
                style={{ width: "500px" }}
              />
              <Button
                variant="outline-success "
                className="button-color font-size-header"
                type="submit"
              >
                Search
              </Button>
            </Form>
            <Nav
              className="ms-auto my-2 my-lg-0"
              style={{ maxHeight: "100px" }}
              navbarScroll
            >
              <Link to="/cart" className="nav-link margin">
                <FontAwesomeIcon
                  icon={faCartShopping}
                  size="2x"
                  color="#8EA7E9"
                />
                <Badge style={{ marginLeft: "5px" }} className="bg bg-danger">
                  {cartCounter}
                </Badge>
              </Link>
              <Link to="/" className="nav-link margin">
                <FontAwesomeIcon icon={faHeart} size="2x" color="#8EA7E9" />
              </Link>
              {user === null ? (
                <>
                  <Link
                    to="/login"
                    className="nav-link margin font-size-header"
                  >
                    Login
                  </Link>
                </>
              ) : (
                <>
                  <Link to="/user" className="nav-link margin font-size-header">
                    <Image
                      src={user.avatar}
                      rounded
                      style={{ width: "30px" }}
                    />{" "}
                    {user.username}
                  </Link>
                  <Link to="/login">
                    <Button onClick={() => dispatch({ type: "logout" })}>
                      Logout
                    </Button>
                  </Link>
                </>
              )}
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <Navbar className="backgroudColor margin" fill variant="tabs">
        <Container>
          {categories.map((c) => {
            const url = `/search/?cateId=${c.id}`;
            return (
              <Link key={c.id} to={url} className="nav-link font-size-header">
                {" "}
                {c.name}{" "}
              </Link>
            );
          })}
        </Container>
      </Navbar>
    </>
  );
};
export default Header;
