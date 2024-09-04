/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.ecourse.pojo.Course;
import com.ecourse.pojo.User;
import com.ecourse.repository.CertificationRepository;
import com.ecourse.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CertificationServiceImpl implements CertificationService{
    @Autowired
    private CertificationRepository certificationRepo;
    @Override
    public String createCertificate(Long userId, Long courseId) {
         return this.certificationRepo.createCertificate(userId, courseId);
    }

    @Override
    public String createCertificatePDF(User user, Course course, Long certificateId) {
        return this.certificationRepo.createCertificatePDF(user, course, certificateId);
    }
    
}
