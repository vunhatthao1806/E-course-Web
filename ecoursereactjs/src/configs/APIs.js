import axios from "axios";
import cookie from "react-cookies";
const BASE_URL = "http://localhost:8080/ECourseWeb/api";

export const endpoints = {
  categories: "/categories",
  courses: "/courses",
  course: (courseId) => `courses/${courseId}`,
  search: "/courses/search",
  login: "/login",
  "current-user": "/current-user",
  pay: "/pay",
  "create-payment": "/create-payment",
  "update-payment": "/update-payment",
  lessons: (coursesId) => `lessons/${coursesId}`,
  videos: "/videos",
  progress: (courseId, userId) => `/course/${courseId}/user/${userId}`,
  videosCompleted: (userId) => `/videosCompleted/${userId}`,
  "user-assignments": (courseId) => `/assignments/courses/${courseId}`,
  userDone: (assignmentId, userId) =>
    `/userdone/assignment/${assignmentId}/user/${userId}`,
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
