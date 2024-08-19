///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.ecourse.repository.impl;
//
//import com.ecourse.pojo.Cart;
//import com.ecourse.pojo.Receipt;
//import com.ecourse.repository.ReceiptRepository;
//import java.util.List;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.stereotype.Repository;
//
///**
// *
// * @author Admin
// */
//@Repository
//public class ReceiptRepositoryImpl implements ReceiptRepository {
//
//    @Autowired
//    private LocalSessionFactoryBean factory;
//
//    @Override
//    public void addReceipt(List<Cart> carts) {
//        if (carts != null) {
//            Session s = this.factory.getObject().getCurrentSession();
//            Receipt order = new Receipt();
//            order.setUserId(useRepo.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
//            order.setCreatedDate(new Date());
//            s.save(order);
//
//            for (Cart c : carts) {
//                OrderDetail d = new OrderDetail();
//                d.setUnitPrice(c.getUnitPrice());
//                d.setQuantity(c.getQuantity());
//                d.setProductId(productRepo.getProductById(c.getId()));
//                d.setOrderId(order);
//
//                s.save(d);
//            }
//        }
//    }
//
//    }
//
//}
