package com.kfirfer.userservice.controller;

import com.kfirfer.userservice.api.StoreApi;
import com.kfirfer.userservice.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class StoreApiController implements StoreApi {

    @Override
    public ResponseEntity<Void> deleteOrder(String orderId) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Integer>> getInventory() {
        return null;
    }

    @Override
    public ResponseEntity<Order> getOrderById(String orderId) {
        return null;
    }

    @Override
    public ResponseEntity<Order> placeOrder(@Valid @RequestBody Order body) {
        return null;
    }
}
