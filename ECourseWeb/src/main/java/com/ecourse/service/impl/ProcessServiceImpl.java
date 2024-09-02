/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.ecourse.pojo.CourseProcess;
import com.ecourse.repository.ProcessRepository;
import com.ecourse.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ProcessServiceImpl implements ProcessService{

    @Autowired
    private ProcessRepository processRepo;

    @Override
    public float calculateCourseProgress(Long userId, Long courseId) {
        return this.processRepo.calculateCourseProgress(userId, courseId);
    }

    @Override
    public CourseProcess getProcess(Long userId, Long courseId) {
        return this.processRepo.getProcess(userId, courseId);
    }
}
