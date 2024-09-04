/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecourse.service;

import com.ecourse.pojo.Assignment;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface AssignmentService {

    List<Assignment> getAssignments();

    void addOrUpdate(Assignment c);

    List<Assignment> getAssignmentByCourseId(Long courseId);

    List<Assignment> getAssignmentByLessonId(Long lessonId);

    Assignment getAssignmentById(Long id);

    void deleteAssignment(Long id);
}
