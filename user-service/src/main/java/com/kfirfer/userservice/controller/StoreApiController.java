package com.kfirfer.userservice.controller;

import com.kfirfer.userservice.api.StoreApi;
import com.kfirfer.userservice.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Map;

@RestController
public class StoreApiController implements StoreApi {


    @Override
    public ResponseEntity<Void> deleteOrder(Integer orderId) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Integer>> getInventory() {
        return null;
    }

    @Override
    public ResponseEntity<Order> getOrderById(@Min(1L) @Max(5L) Long orderId) {
        return null;
    }

    @Override
    public ResponseEntity<Order> placeOrder(@Valid Order order) {
        return null;
    }
}
