/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.ecourse.pojo.Cart;
import com.ecourse.pojo.Receipt;
import com.ecourse.repository.ReceiptRepository;
import com.ecourse.service.ReceiptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{
    @Autowired
private ReceiptRepository receiptRepo;
    @Override
    public void addReceipt(List<Cart> carts) {
        this.receiptRepo.addReceipt(carts);
    }

    @Override
    public List<Receipt> findByUserId(Long userId) {
        return this.receiptRepo.findByUserId(userId);
    }
    
}
