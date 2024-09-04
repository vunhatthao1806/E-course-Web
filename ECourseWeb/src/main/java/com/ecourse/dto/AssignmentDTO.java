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
public class AssignmentDTO {

    private String name;
    private Date createdDate;
    private Date dueDate;
    private TagDTO tag;
    private LessonDTO lesson;
    private CourseDTO course;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the tag
     */
    public TagDTO getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(TagDTO tag) {
        this.tag = tag;
    }

    /**
     * @return the lesson
     */
    public LessonDTO getLesson() {
        return lesson;
    }

    /**
     * @param lesson the lesson to set
     */
    public void setLesson(LessonDTO lesson) {
        this.lesson = lesson;
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
