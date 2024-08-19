/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.repository;

import com.ecourse.pojo.Teacher;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface TeacherRepository {
    List<Teacher> getTeachers();
    List<Teacher> getTeachers(Map<String, String> params);
    void addOrUpdate(Teacher c);
    Teacher getTeacherById(Long id);
    void deleteTeacher(Long id);
}
