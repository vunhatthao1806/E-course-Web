/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.controllers;

import com.ecourse.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiCourseProcessController {

    @Autowired
    private ProcessService  processSer;

    @GetMapping("/course/{courseId}/user/{userId}")
    public float getCourseProgress(
            @PathVariable Long userId,
            @PathVariable Long courseId) {
        return processSer.calculateCourseProgress(userId, courseId);
    }
}
