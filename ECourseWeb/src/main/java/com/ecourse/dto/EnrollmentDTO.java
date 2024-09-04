/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class EnrollmentDTO {
    private Date enrollmentDate;
    private CourseDTO course;

    /**
     * @return the enrollmentDate
     */
    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    /**
     * @param enrollmentDate the enrollmentDate to set
     */
    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    /**
     * @return the course
     */
    public CourseDTO getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(CourseDTO course) {
        this.course = course;
    }
}
