/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.repository.impl;

import com.ecourse.pojo.Certification;
import com.ecourse.pojo.Course;
import com.ecourse.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecourse.repository.CertificationRepository;
import com.ecourse.repository.CourseRepository;
import com.ecourse.repository.UserRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author Admin
 */
@Transactional
@Repository
public class CertificationRepositoryImpl implements CertificationRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public String createCertificate(Long userId, Long courseId) {
        Session s = this.factory.getObject().getCurrentSession();
        User user = userRepo.getUserById(userId);
        Course course = courseRepo.getCourseById(userId);
        Certification certificate = new Certification();
        certificate.setUserId(user);
        certificate.setCourseId(course);
        certificate.setIssuanceDate(new Date());
        certificate.setName("Chứng nhận hoàn thành khóa học" + " " + course.getName());
        s.save(certificate);
        return createCertificatePDF(user, course, certificate.getId());
    }

    @Override
    public String createCertificatePDF(User user, Course course, Long certificateId) {

        Document document = new Document();
        String directoryPath = "D:/Source code Netbean/apache-tomcat-9.0.91/webapps/ROOT/certificates/";
        String pdfPath = directoryPath + certificateId + "_" + user.getId() + "_" + course.getId() + ".pdf";
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            boolean dirCreated = directory.mkdirs();
            if (!dirCreated) {
                Logger.getLogger(CertificationRepositoryImpl.class.getName()).log(Level.SEVERE, "Failed to create directory: " + directoryPath);
                return null;
            }
        }
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();
            document.add(new Paragraph("Chứng chỉ hoàn thành khóa học" + " " + course.getName()));
            document.add(new Paragraph("Người học: " + user.getFirstName() + " " + user.getLastName()));
            document.add(new Paragraph("Khóa học: " + course.getName()));
            document.add(new Paragraph("Ngày cấp: " + LocalDate.now()));
            document.close();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(CertificationRepositoryImpl.class.getName()).log(Level.SEVERE, "Error creating PDF: " + ex.getMessage(), ex);
            return null;
        }

        return "/certificates/" + certificateId + "_" + user.getId() + "_" + course.getId() + ".pdf";
    }
}
