/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.ecourse.pojo.Assignment;
import com.ecourse.repository.AssignmentRepository;
import com.ecourse.service.AssignmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepo;

    @Override
    public void addOrUpdate(Assignment c) {
        this.assignmentRepo.addOrUpdate(c);
    }

    @Override
    public List<Assignment> getAssignmentByLessonId(Long lessonId) {
        return this.assignmentRepo.getAssignmentByLessonId(lessonId);
    }

    @Override
    public Assignment getAssignmentById(Long id) {
        return this.assignmentRepo.getAssignmentById(id);
    }

    @Override
    public void deleteAssignment(Long id) {
        this.assignmentRepo.deleteAssignment(id);
    }

    @Override
    public List<Assignment> getAssignments() {
        return this.assignmentRepo.getAssignments();
    }

    @Override
    public List<Assignment> getAssignmentByCourseId(Long courseId) {
        return this.assignmentRepo.getAssignmentByCourseId(courseId);
    }

}
