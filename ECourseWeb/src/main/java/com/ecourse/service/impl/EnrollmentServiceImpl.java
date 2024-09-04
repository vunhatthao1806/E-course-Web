/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.ecourse.pojo.Course;
import com.ecourse.pojo.Enrollment;
import com.ecourse.repository.EnrollmentRepository;
import com.ecourse.service.EnrollmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollRepo;

    @Override
    public List<Enrollment> getAllEnrollments(Long userId, Long courseId) {
        return this.enrollRepo.getAllEnrollments(userId, courseId);
    }

    @Override
    public List<Enrollment> getEnrollmentByUserId(Long id) {
        return this.enrollRepo.getEnrollmentByUserId(id);
    }

    @Override
    public Long countByCourseId(Long courseId) {
        return this.enrollRepo.countByCourseId(courseId);
    }

    
}
