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
import Lesson from "./components/Lesson";

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
  const isTeacher = user?.role === "ROLE_TEACHER";

  return (
    <BrowserRouter>
      <MyUserContext.Provider value={user}>
        <MyDispatchContext.Provider value={dispatch}>
          <MyCartContext.Provider value={[cartCounter, cartDispatch]}>
            {isTeacher ? (
              <>
                {/* <TeacherHeader />
                            <Routes>
                                <Route path='/' element={<HomeTeacher />} />
                                <Route path='/lecturer/assignments/courses/:courseId' element={<Assignments />} />
                                <Route path='/lecturer/assignment/:assignmentId' element={<AssignmentUpdate />} />
                                <Route path='/questions/assignment/:assignmentId' element={<Questions />} />
                                <Route path='/choices' element={<UpdateChoices />} />
                                <Route path='/questions/assignments/:assignmentId' element={<AddQuestion />} />
                                <Route path="/user" element={<UserInfor />}/>
                                <Route path='/essays/question/:questionId' element={<CheckEssays  />} />
                            </Routes> */}
              </>
            ) : (
              <>
                <Header />
                <Container>
                  <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/courses/:id" element={<CourseDetail />} />

                    {/* <Route path="/teachers" element={<Teacher />} />
                                <Route path="/teachers/:id" element={<TeacherDetail />} /> */}

                    <Route path="/login" element={<Login />} />
                    {/* <Route path="/register" element={<Register />}/> */}

                    {/* <Route path="/user" element={<UserInfor />}/> */}
                    <Route path="/cart" element={<Cart />} />
                    {/* <Route path="/my-receipts" element={<MyCourses />}/>
                                <Route path="/receipt/:id" element={<UserCourseDetail />}/> */}
                    <Route path="/lessons/:courseId" element={<Lesson />} />
                    {/* <Route path='/questions/assignment/:assignmentId' element={<Quiz />} />
                                <Route path='/score' element={<AfterQuiz />} />
                                <Route path='/essays/assignment/:assignmentId' element={<Essay />} /> */}
                  </Routes>
                </Container>
                <Footer />
              </>
            )}
          </MyCartContext.Provider>
        </MyDispatchContext.Provider>
      </MyUserContext.Provider>
    </BrowserRouter>
  );
};

export default App;
