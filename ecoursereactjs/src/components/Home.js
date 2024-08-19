import { useEffect, useState } from "react";
import Carousel from "./Carousel";
import { Button, Card, Spinner } from "react-bootstrap";
import APIs, { endpoints } from "../configs/APIs";
import "../css/Home.css";
import Slider from "react-slick";
import Arrow from "./Arrow";
const Home = () => {
  const [course, setCourse] = useState(null);
  const loadCourse = async () => {
    let res = await APIs.get(endpoints["courses"]);
    setCourse(res.data);
  };
  useEffect(() => {
    loadCourse();
  }, []);
  const cardSliderSettings = {
    dots: false,
    infinite: true,
    speed: 500,
    slidesToShow: 3, // Số lượng card hiện tại cùng lúc
    slidesToScroll: 1,
    autoplay: false,
    prevArrow: <Arrow type="prev" />, // Sử dụng mũi tên tùy chỉnh
    nextArrow: <Arrow type="next" />, // Sử dụng mũi tên tùy chỉnh
  };
  const getTagClass = (tagName) => {
    switch (tagName) {
      case "Beginner":
        return "tag-beginner";
      case "Intermediate":
        return "tag-intermediate";
      case "Master":
        return "tag-master";
      default:
        return "tag-default";
    }
  };
  if (course === null) return <Spinner animation="grow" variant="primary" />;

  return (
    <>
      <Carousel />
      <h2 style={{ fontWeight: "bold" }}>Được đề xuất cho bạn</h2>
      <Slider {...cardSliderSettings}>
        {course.map((c) => (
          <Card className="card" key={c.id}>
            <Card.Img variant="top" src={c.image} />
            <Card.Body>
              <Card.Title>{c.name}</Card.Title>
              <Card.Text>
                <div>
                  {c.teacher.user.firstName + " " + c.teacher.user.lastName}
                </div>
                <span style={{ textDecoration: "line-through", color: "red" }}>
                  {c.price.toLocaleString()} VNĐ
                </span>
                <br />
                <span style={{ color: "green", fontWeight: "bold" }}>
                  {(c.price * (1 - c.discount / 100)).toLocaleString()} VNĐ
                </span>
                <div className={`tag ${getTagClass(c.tag.name)}`}>
                  {c.tag.name}
                </div>
              </Card.Text>
              <Button variant="danger" className="btn">
                Mua ngay
              </Button>
            </Card.Body>
          </Card>
        ))}
      </Slider>
    </>
  );
};
export default Home;
