import { useEffect, useState } from "react";
import { Link, useLocation, useSearchParams } from "react-router-dom";
import APIs, { endpoints } from "../configs/APIs";
import { Button, Card, Col, Row, Table } from "react-bootstrap";
import "../css/CourseSearch.css";
const CourseSearch = () => {
  const location = useLocation();
  const [results, setResults] = useState([]);
  const [count, setCount] = useState(0);
  const [categoryName, setCategoryName] = useState("");
  useEffect(() => {
    // Lấy giá trị của query parameter 'q' hoặc 'cateId' từ URL
    const params = new URLSearchParams(location.search);
    const query = params.get("q");
    const cateId = params.get("cateId");

    // Gửi request đến server với từ khóa 'query'
    const search = async () => {
      try {
        let url = `${endpoints["search"]}`;
        if (query) {
          url += `?q=${query}`;
        } else if (cateId) {
          url += `?cateId=${cateId}`;
        }
        let res = await APIs.get(url);
        setResults(res.data);
        setCount(res.data.length);
        if (cateId && res.data.length > 0) {
          setCategoryName(res.data[0].category.name);
        }
      } catch (err) {
        console.error("Không tìm thấy kết quả", err);
      }
    };
    search();
  }, [location.search]); // Mỗi khi URL thay đổi, useEffect sẽ chạy lại
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
  const params = new URLSearchParams(location.search);
  const query = params.get("q");
  const cateId = params.get("cateId");
  return (
    <>
      <div className="count">
        {query
          ? `${count} kết quả cho "${query}"`
          : cateId
          ? `Khóa học ${categoryName}`
          : "Không có kết quả"}
      </div>
      {results.map((r) => (
        <Card key={r.id} className="mb-3 shadow-sm" style={{ width: 1100 }}>
          <Row className="g-0">
            <Col md={4}>
              <Card.Img
                variant="left"
                src={r.image}
                alt={r.name}
                className="img-fluid"
                style={{ height: "100%", objectFit: "cover" }}
              />
            </Col>
            <Col md={8}>
              <Card.Body>
                <Card.Title>{r.name}</Card.Title>
                <Card.Text>
                  <div>
                    {r.teacher.user.firstName + " " + r.teacher.user.lastName}
                  </div>
                  <span
                    style={{ textDecoration: "line-through", color: "red" }}
                  >
                    {r.price.toLocaleString()} VNĐ
                  </span>
                  <br />

                  <span style={{ color: "green", fontWeight: "bold" }}>
                    {(r.price * (1 - r.discount / 100)).toLocaleString()} VNĐ
                  </span>
                  <div className={`tag ${getTagClass(r.tag.name)}`}>
                    {r.tag.name}
                  </div>
                </Card.Text>
                <Card.Text>
                  <strong>Price: </strong>
                  {(r.price * (1 - r.discount / 100)).toLocaleString()} VNĐ
                  <Button variant="danger" className="btn">
                    Thêm vào giỏ hàng
                  </Button>
                </Card.Text>
              </Card.Body>
            </Col>
          </Row>
        </Card>
      ))}
    </>
  );
};
export default CourseSearch;
