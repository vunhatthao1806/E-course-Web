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
  "get-enrollment": (userId) => `/enrollments/user/${userId}`,
  addCompleted: "/addVideoComplete",
  "create-certificate": (courseId, userId) =>
    `/certification/${courseId}/user/${userId}`,
  "courses-by-teacher": (teacherId) => `/courses/teacher/${teacherId}`,
  teachers: "teachers",
  "assignment-by-course": (courseId) =>
    `/lecturer/assignments/courses/${courseId}`,
  "google-login": "/google",
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
