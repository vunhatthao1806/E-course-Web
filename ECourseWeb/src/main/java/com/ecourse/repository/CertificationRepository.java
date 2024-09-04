/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecourse.repository;

import com.ecourse.pojo.Course;
import com.ecourse.pojo.User;

/**
 *
 * @author Admin
 */
public interface CertificationRepository {
    String createCertificate(Long userId, Long courseId);
    String createCertificatePDF(User user, Course course, Long certificateId );
}
