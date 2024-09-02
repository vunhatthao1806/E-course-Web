import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import { Container } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-icons/font/bootstrap-icons.css";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Home from "./components/Home";
import CourseSearch from "./components/CourseSearch";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";
import Login from "./components/Login";
import MyCartReducer from "./reducers/MyCartReducer";
import Cart from "./components/Cart";
import CourseDetail from "./components/CourseDetail";

export const MyUserContext = createContext();
export const MyDispatchContext = createContext();
export const MyCartContext = createContext();
const count = () => {
  let cart = cookie.load("cart") || null;
  if (cart !== null) {
    let totalQuantity = 0;
    for (let c of Object.values(cart)) totalQuantity += c.quantity;

    return totalQuantity;
  }
  return 0;
};
const App = () => {
  const [user, dispatch] = useReducer(
    MyUserReducer,
    cookie.load("user") || null
  );
  const [cartCounter, cartDispatch] = useReducer(MyCartReducer, count());

  return (
    <BrowserRouter>
      <MyUserContext.Provider value={user}>
        <MyDispatchContext.Provider value={dispatch}>
          <MyCartContext.Provider value={[cartCounter, cartDispatch]}>
            <Header />
            <Container>
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/search" element={<CourseSearch />} />
                <Route path="/login" element={<Login />} />
                <Route path="/cart" element={<Cart />} />
                <Route path="/courses/:id" element={<CourseDetail />} />
              </Routes>
            </Container>
            <Footer />
          </MyCartContext.Provider>
        </MyDispatchContext.Provider>
      </MyUserContext.Provider>
    </BrowserRouter>
  );
};

export default App;
