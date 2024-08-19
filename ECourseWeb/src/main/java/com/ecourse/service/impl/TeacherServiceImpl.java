/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.ecourse.pojo.Teacher;
import com.ecourse.repository.TeacherRepository;
import com.ecourse.service.TeacherService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public class TeacherServiceImpl implements TeacherService{
     @Autowired
    private TeacherRepository teacherRepo;

    @Override
    public List<Teacher> getTeachers() {
        return this.teacherRepo.getTeachers();
    }

    @Override
    public List<Teacher> getTeachers(Map<String, String> params) {
        return this.teacherRepo.getTeachers(params);
    }

    @Override
    public void addOrUpdate(Teacher c) {
        this.teacherRepo.addOrUpdate(c);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return this.teacherRepo.getTeacherById(id);
    }

    @Override
    public void deleteTeacher(Long id) {
        this.teacherRepo.deleteTeacher(id);
    }
}
