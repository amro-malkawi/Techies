package com.amromalkawi.technology.springcore.sample.ordersystem.service;

import com.amromalkawi.technology.springcore.sample.ordersystem.domain.Customer;
import com.amromalkawi.technology.springcore.sample.ordersystem.domain.Order;

import java.util.Map;

public interface OrderService {
    Order createOrder(Customer customer, Map<String, Long> items);
    Order createOrder(String customerId, Map<String, Long> items);
    Order getOrder(String orderId);
}
