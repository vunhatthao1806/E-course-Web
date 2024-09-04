/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.ecourse.pojo.Userassignmentdone;
import com.ecourse.repository.UserAssignmentDoneRepository;
import com.ecourse.service.UserAssignmentDoneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class UserAssignmentDoneServiceImpl implements UserAssignmentDoneService {

    @Autowired
    private UserAssignmentDoneRepository userAssRepo;

    @Override
    public List<Userassignmentdone> getAllByUserAndAssignmentId(Long userId, Long assignmentId) {
        return this.userAssRepo.getAllByUserAndAssignmentId(userId, assignmentId);
    }

    @Override
    public Long countCompletedAssignments(Long assignmentId) {
        return this.userAssRepo.countCompletedAssignments(assignmentId);
    }
}
