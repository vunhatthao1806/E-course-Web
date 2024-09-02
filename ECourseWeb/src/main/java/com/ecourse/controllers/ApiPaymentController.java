/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.controllers;

import com.ecourse.components.MomoService;
import com.ecourse.pojo.Cart;
import com.ecourse.service.ReceiptService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiPaymentController {

    @Autowired
    private MomoService momoService;
    @Autowired
    private ReceiptService receiptService;  

    @PostMapping("/create-payment")
    public String createPayment(@RequestBody Map<String, String> params ) throws Exception {
        String orderId = params.get("orderId");
        String amount = params.get("amount");
        String returnUrl = params.get("returnUrl");
        
        if (orderId == null || amount == null || returnUrl == null) {
            throw new IllegalArgumentException("Missing required parameters");
        }

        float amountValue;
        try {
            amountValue = Float.parseFloat(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid amount format", e);
        }

        return this.momoService.createPaymentRequest(orderId, amountValue, returnUrl);
    }
    
    @PostMapping("/update-payment")
    @ResponseStatus(HttpStatus.OK)
    public void pay(@RequestBody List<Cart> carts){
        this.receiptService.addReceipt(carts);
    }
     // API để nhận phản hồi từ Momo
//    @PostMapping("/momo-callback")
//    public ResponseEntity<String> handleMomoCallback(@RequestBody Map<String, String> params) {
//        String orderId = params.get("orderId");
//        String resultCode = params.get("resultCode");
//        String message = params.get("message");
//
//        // Kiểm tra nếu thanh toán thành công (resultCode = 0)
//        boolean paymentSuccess = "0".equals(resultCode);
//
//        // Cập nhật lại Receipt dựa trên orderId và trạng thái thanh toán
//        boolean updateResult = receiptService.updateReceipt(orderId, paymentSuccess);
//
//        if (updateResult) {
//            return ResponseEntity.ok("Receipt updated successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("Receipt not found or payment failed. Message: " + message);
//        }
//    }

}
