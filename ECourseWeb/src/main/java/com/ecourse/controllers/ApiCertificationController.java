/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.controllers;

import com.ecourse.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiCertificationController {

    @Autowired
    private CertificationService certificationSer;

    @PostMapping("/certification/{courseId}/user/{userId}")
    public ResponseEntity<String> addCertification(@PathVariable("courseId") Long courseId,
            @PathVariable("userId") Long userId) {
        String pdfUrl = this.certificationSer.createCertificate(userId, courseId);
        return ResponseEntity.ok(pdfUrl);
    }
}
