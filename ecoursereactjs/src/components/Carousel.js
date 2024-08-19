import Slider from "react-slick";
import React from "react";
import "../css/Carousel.css";
const Carousel = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 2000,
  };
  return (
    <>
      <div className="carousel-container">
        <Slider {...settings}>
          <div>
            <img
              src="https://res.cloudinary.com/duwy5cgyw/image/upload/v1723457748/ecourse1_xzyq5c.webp"
              alt="Slide 1"
            />
          </div>
          <div>
            <img
              src="https://res.cloudinary.com/duwy5cgyw/image/upload/v1723457748/ecourse2_wth3jj.webp"
              alt="Slide 2"
            />
          </div>
          <div>
            <img
              src="https://res.cloudinary.com/duwy5cgyw/image/upload/v1723458824/ecourse7_hknhte.jpg"
              alt="Slide 3"
            />
          </div>
          <div>
            <img
              src="https://res.cloudinary.com/duwy5cgyw/image/upload/v1723458824/ecourse5_s8qp5g.png"
              alt="Slide 4"
            />
          </div>
        </Slider>
      </div>
    </>
  );
};
export default Carousel;
