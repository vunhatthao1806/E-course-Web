/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecourse.repository;

import com.ecourse.pojo.Userassignmentdone;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UserAssignmentDoneRepository {

    List<Userassignmentdone> getAllByUserAndAssignmentId(Long userId, Long assignmentId);

    Long countCompletedAssignments(Long assignmentId);
}
