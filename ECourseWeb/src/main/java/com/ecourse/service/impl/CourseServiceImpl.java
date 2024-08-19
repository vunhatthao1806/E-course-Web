/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ecourse.pojo.Course;
import com.ecourse.pojo.Teacher;



import com.ecourse.repository.CourseRepository;
import com.ecourse.service.CourseService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Course> getCourses(Map<String, String> params) {
        return this.courseRepo.getCourses(params);
    }

    @Override
    public List<Course> getCourses() {
        return this.courseRepo.getCourses();
    }

    @Override
    public void addOrUpdate(Course c) {
        if (!c.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(c.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                c.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(CourseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.courseRepo.addOrUpdate(c);
    }

    @Override
    public void addTeacher(Teacher c) {
         this.courseRepo.addTeacher(c);
    }

    @Override
    public Course getCourseById(int id) {
        return this.courseRepo.getCourseById(id);
    }

    @Override
    public void deleteCourse(int id) {
       this.courseRepo.deleteCourse(id);
    }
   
}
