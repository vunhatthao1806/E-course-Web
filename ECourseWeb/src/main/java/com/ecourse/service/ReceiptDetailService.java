/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecourse.service;

import com.ecourse.pojo.ReceiptDetail;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ReceiptDetailService {
    List<ReceiptDetail> findByReceiptId(Long receiptId);
}
