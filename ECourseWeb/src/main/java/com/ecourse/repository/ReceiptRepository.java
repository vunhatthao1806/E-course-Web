/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecourse.repository;

import com.ecourse.pojo.Cart;
import com.ecourse.pojo.Receipt;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ReceiptRepository {
    void addReceipt(List<Cart> carts);
    List<Receipt> findByUserId(Long userId);
}
