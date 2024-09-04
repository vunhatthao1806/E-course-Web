/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.repository.impl;

import com.ecourse.pojo.Assignment;
import com.ecourse.repository.AssignmentRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class AssignmentRepositoryImpl implements AssignmentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void addOrUpdate(Assignment c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() != null) {
            s.update(c);
        } else {
            s.save(c); //chen

        }
    }

    @Override
    public List<Assignment> getAssignmentByLessonId(Long lessonId) {
        Session s = this.factory.getObject().getCurrentSession();
        String assignQuery = "FROM Assignment p WHERE p.lessonId.id = :lessonId";
        return s.createQuery(assignQuery)
                .setParameter("lessonId", lessonId)
                .list();
    }

    @Override
    public Assignment getAssignmentById(Long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Assignment.class, id);
    }

    @Override
    public void deleteAssignment(Long id) {
        Session s = this.factory.getObject().getCurrentSession();
        Assignment c = this.getAssignmentById(id);
        s.delete(c);
    }

    @Override
    public List<Assignment> getAssignments() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Assignment");
        return q.getResultList();
    }

    @Override
    public List<Assignment> getAssignmentByCourseId(Long courseId) {
        Session s = this.factory.getObject().getCurrentSession();
        String assignQuery = "FROM Assignment p WHERE p.courseId.id = :courseId";
        return s.createQuery(assignQuery)
                .setParameter("courseId", courseId)
                .list();
    }

}
