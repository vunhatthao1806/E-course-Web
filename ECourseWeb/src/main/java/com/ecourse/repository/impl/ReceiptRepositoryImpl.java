/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.repository.impl;

import com.ecourse.pojo.Cart;
import com.ecourse.pojo.Receipt;
import com.ecourse.pojo.ReceiptDetail;
import com.ecourse.repository.CourseRepository;
import com.ecourse.repository.ReceiptRepository;
import com.ecourse.repository.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ReceiptRepositoryImpl implements ReceiptRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CourseRepository courseRepo;

    @Override
    public void addReceipt(List<Cart> carts) {
        if (carts != null) {
            Session s = this.factory.getObject().getCurrentSession();
            Receipt receipt = new Receipt();
            receipt.setUserId(this.userRepo.getUserByUsername(
                    SecurityContextHolder.getContext().getAuthentication().getName()));
            receipt.setCreatedDate(new Date());

            float totalPrice = (float) carts.stream()
                    .mapToDouble(c -> (c.getPrice() * c.getQuantity() * (1 - c.getDiscount() / 100)))
                    .sum();
            receipt.setTotal(totalPrice);

            s.save(receipt);

            for (Cart c : carts) {
                ReceiptDetail d = new ReceiptDetail();

                d.setPrice(c.getPrice());
                d.setQuantity(c.getQuantity());
                d.setCourseId(courseRepo.getCourseById(c.getId()));
                d.setReceiptId(receipt);
                s.save(d);
            }
        }
    }

    @Override
    public List<Receipt> findByUserId(Long userId) {
        Session session = this.factory.getObject().getCurrentSession();
        String hql = "FROM Receipt WHERE user.id = :userId";
        return session.createQuery(hql, Receipt.class)
                .setParameter("userId", userId)
                .getResultList();

    }

}
