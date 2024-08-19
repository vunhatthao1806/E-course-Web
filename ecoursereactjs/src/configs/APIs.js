import axios from "axios";
import cookie from "react-cookies";
const BASE_URL = "http://localhost:8080/ECourseWeb/api";

export const endpoints = {
  categories: "/categories",
  courses: "/courses",
  search: "/courses/search",
};
export const authAPIs = () => {
  return axios.create({
    baseURL: BASE_URL,
    headers: {
      Authorization: cookie.load("token"),
    },
  });
};
export default axios.create({
  baseURL: BASE_URL,
});
