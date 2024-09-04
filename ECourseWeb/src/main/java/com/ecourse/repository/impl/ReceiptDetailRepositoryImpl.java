/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.repository.impl;

import com.ecourse.pojo.ReceiptDetail;
import com.ecourse.repository.ReceiptDetailRepository;
import java.util.List;
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
public class ReceiptDetailRepositoryImpl implements ReceiptDetailRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ReceiptDetail> findByReceiptId(Long receiptId) {
        Session session = this.factory.getObject().getCurrentSession();
        String hql = "FROM ReceiptDetail WHERE receipt.id = :receiptId";
        return session.createQuery(hql, ReceiptDetail.class)
                .setParameter("receiptId", receiptId)
                .getResultList();
    }

}
