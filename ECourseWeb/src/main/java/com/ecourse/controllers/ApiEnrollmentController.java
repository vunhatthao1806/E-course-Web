/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.controllers;

import com.ecourse.pojo.Enrollment;
import com.ecourse.service.EnrollmentService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiEnrollmentController {

    @Autowired
    private EnrollmentService enrollService;

    @GetMapping("/enrollments")
    public ResponseEntity<?> listEnrollments(
            @RequestParam Long userId,
            @RequestParam Long courseId
    ) {

        try {
            List<Enrollment> listEnroll = enrollService.getAllEnrollments(userId, courseId);
            return ResponseEntity.ok(listEnroll);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/enrollments/count/{courseId}")
    public ResponseEntity<?> countCourse(
            @PathVariable("courseId") Long courseId) {
        Long count = enrollService.countByCourseId(courseId);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/enrollments/user/{userId}")
    public ResponseEntity<?> getCourses(
            @PathVariable("userId") Long userId) {
        return ResponseEntity.ok(this.enrollService.getEnrollmentByUserId(userId));
    }

}
