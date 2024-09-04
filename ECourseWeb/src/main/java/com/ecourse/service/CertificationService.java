/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecourse.service;

import com.ecourse.pojo.Course;
import com.ecourse.pojo.User;

/**
 *
 * @author Admin
 */
public interface CertificationService {

    String createCertificate(Long userId, Long courseId);

    String createCertificatePDF(User user, Course course, Long certificateId);
}
