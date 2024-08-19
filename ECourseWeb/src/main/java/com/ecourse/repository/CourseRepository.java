/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.repository;


import com.ecourse.pojo.Course;
import com.ecourse.pojo.Teacher;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Admin
 */
public interface CourseRepository {

    List<Course> getCourses(Map<String, String> params);

    List<Course> getCourses();

    void addOrUpdate(Course c);

    void addTeacher(Teacher c);

    Course getCourseById(int id);

    void deleteCourse(int id);
}
