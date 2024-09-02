/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecourse.repository;

import com.ecourse.pojo.CourseProcess;

/**
 *
 * @author Admin
 */
public interface ProcessRepository {
    float calculateCourseProgress(Long userId, Long courseId);
    CourseProcess getProcess(Long userId, Long courseId);
}
