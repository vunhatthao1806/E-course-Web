/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.repository.impl;

import com.ecourse.pojo.User;
import com.ecourse.repository.UserRepository;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);

        // Sử dụng getResultList để tránh ném ngoại lệ khi không có kết quả
        List<User> results = q.getResultList();

        // Kiểm tra nếu danh sách trống
        if (!results.isEmpty()) {
            return results.get(0); // Trả về user đầu tiên nếu tìm thấy
        }
        return null; // Trả về null nếu không có kết quả
    }

    @Override
    public boolean authUser(String username, String password) {
        User u = this.getUserByUsername(username);
        if (u == null) {
            return false;
        }
        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public User addUser(User u) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(u);

        return u;
    }

    @Override
    public User getUserById(Long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(User.class, id);
    }

    @Override
    public void addUserGG(String username, String email, String firstName, String lastName) {
        Session s = this.factory.getObject().getCurrentSession();
        // Kiểm tra xem người dùng đã tồn tại dựa trên email
        User existingUser = getUserByUsername(username);
        if (existingUser == null) {
            // Tạo người dùng mới nếu không tồn tại
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setEmail(email);
            newUser.setRole("ROLE_STUDENT");
            newUser.setCreatedDate(new Date());
            newUser.setIsActive(true);
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setPassword("000000");
            s.save(newUser);
        } else {
            System.out.println("User already exists with email: " + email);
        }
    }

}
