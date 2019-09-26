package com.amromalkawi.technology.springcore.sample.ordersystem.service.impl;

import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.CustomerRepository;
import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.SalesOrderRepository;
import com.amromalkawi.technology.springcore.sample.ordersystem.domain.Customer;
import com.amromalkawi.technology.springcore.sample.ordersystem.domain.Order;
import com.amromalkawi.technology.springcore.sample.ordersystem.service.InventoryService;
import com.amromalkawi.technology.springcore.sample.ordersystem.service.OrderService;

import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private final InventoryService inventoryService;
    private final CustomerRepository customerRepository;
    private final SalesOrderRepository salesOrderRepository;

    public OrderServiceImpl(InventoryService inventoryService, CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository) {
        this.inventoryService = inventoryService;
        this.customerRepository = customerRepository;
        this.salesOrderRepository = salesOrderRepository;
    }

    public Order createOrder(Customer customer, Map<String, Long> items) {
        return null;
    }

    public Order createOrder(String customerId, Map<String, Long> items) {
        return null;
    }

    public Order getOrder(String orderId) {
        return null;
    }
}
