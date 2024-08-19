/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecourse.repository.impl;


import com.ecourse.pojo.Course;
import com.ecourse.pojo.Teacher;
import com.ecourse.repository.CourseRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
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
public class CourseRepositoryImpl implements CourseRepository {

    private static final int PAGE_SIZE = 10;
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Course> getCourses(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Course> c = b.createQuery(Course.class);
        Root root = c.from(Course.class);
        c.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = (Predicate) b.like(root.get("name"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }

            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()) {
                Predicate p2 = (Predicate) b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice));
                predicates.add(p2);
            }

            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()) {
                Predicate p3 = (Predicate) b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice));
                predicates.add(p3);
            }

            String cateId = params.get("cateId");
            if (cateId != null && !cateId.isEmpty()) {
                Predicate p4 = (Predicate) b.equal(root.get("categoryId"), Integer.parseInt(cateId));
                predicates.add(p4);
            }

            c.where((javax.persistence.criteria.Predicate[]) predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(c);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int start = (p - 1) * PAGE_SIZE;

                query.setFirstResult(start);
                query.setMaxResults(PAGE_SIZE);
            }
        }

        return query.getResultList();
    }

    @Override
    public List<Course> getCourses() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Course");
        return q.getResultList();
    }

    @Override
    public void addOrUpdate(Course c) {
        Session s = this.factory.getObject().getCurrentSession();
//        Date d = c.getCreatedDate();
        
        if (c.getId() != null) {
            s.update(c);
            c.setUpdatedDate(new Date());
        } else {
            s.save(c); //chen
            c.setCreatedDate(new Date());
        }
        c.setIsActive(true);
//        c.setCreatedDate(d);
    }

    @Override
    public void addTeacher(Teacher c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() != null) {
            s.update(c);
        }
    }

    @Override
    public Course getCourseById(int id) {
         Session s = this.factory.getObject().getCurrentSession();
        return s.get(Course.class, id);
    }

    //Kiểm tra trước khi xóa
    @Override
    public void deleteCourse(int id) {
         Session s = this.factory.getObject().getCurrentSession();
        Course c = this.getCourseById(id);
        s.delete(c);
    }

}
