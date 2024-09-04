import { useContext, useState } from "react";
import cookie from "react-cookies";
import { MyCartContext, MyUserContext } from "../App";
import { authAPIs, endpoints } from "../configs/APIs";
import { Alert, Button, Col, Row, Table } from "react-bootstrap";
import "../css/Cart.css";
import { v4 as uuidv4 } from "uuid";
const Cart = () => {
  const [cart, setCart] = useState(cookie.load("cart") || null);
  const [, dispatch] = useContext(MyCartContext);
  const user = useContext(MyUserContext);
  const totalPrice = cart
    ? Object.values(cart).reduce(
        (sum, c) => sum + c.price * (1 - c.discount / 100) * c.quantity,
        0
      )
    : 0;
  const createpayment = async () => {
    try {
      let newOrderId = uuidv4();
      let res = await authAPIs().post(endpoints["create-payment"], {
        orderId: newOrderId,
        amount: totalPrice,
        returnUrl: "http://localhost:3000/cart",
      });
      console.log(res.data);
      const { payUrl } = res.data;
      if (payUrl) {
        window.location.href = payUrl;
        let res2 = await authAPIs().post(
          endpoints["update-payment"],
          Object.values(cart)
        );
        if (res2.status === 200) {
          setCart([]);
          cookie.remove("cart");
          dispatch({ type: "paid" });
        }
      } else {
        console.error("payUrl không tồn tại");
      }
    } catch {
      console.error("Tạo thanh toán thất bại!!!");
    }
  };
  return (
    <>
      <div className="container">
        {cart === null ? (
          <Alert variant="danger">Không có sản phẩm nào trong giỏ</Alert>
        ) : (
          <>
            <h1 className="font-size-cart">GIỎ HÀNG</h1>
            <Row>
              <Col>
                <h1>Số lượng khóa học trong cart</h1>
                <Table striped bordered hover size="sm">
                  <thead>
                    <tr>
                      <th>Id</th>
                      <th>Tên khóa học</th>
                      <th>Giá</th>
                      <th>Giảm giá</th>
                      <th>Số lượng</th>
                    </tr>
                  </thead>
                  <tbody>
                    {Object.values(cart).map((c) => (
                      <tr>
                        <td>1</td>
                        <td>{c.name}</td>
                        <td>{c.price.toLocaleString()}</td>
                        <td>{c.discount}%</td>
                        <td>{c.quantity}</td>
                      </tr>
                    ))}
                  </tbody>
                </Table>
              </Col>
              <Col>
                <h1>Tổng tiền: {totalPrice.toLocaleString()} VND</h1>
                {user !== null && (
                  <Button onClick={createpayment} className="btn btn-info">
                    Thanh toán
                  </Button>
                )}
              </Col>
            </Row>
          </>
        )}
      </div>
    </>
  );
};
export default Cart;
