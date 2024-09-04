/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.ecourse.pojo.ReceiptDetail;
import com.ecourse.repository.ReceiptDetailRepository;

import com.ecourse.service.ReceiptDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ReceiptDetailServiceImpl implements ReceiptDetailService{
    @Autowired
    private ReceiptDetailRepository receiptDetailRepo;
    
    @Override
    public List<ReceiptDetail> findByReceiptId(Long receiptId) {
        return this.receiptDetailRepo.findByReceiptId(receiptId);
    }
    
}
