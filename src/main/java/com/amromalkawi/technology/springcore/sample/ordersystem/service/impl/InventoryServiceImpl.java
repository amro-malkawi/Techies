package com.amromalkawi.technology.springcore.sample.ordersystem.service.impl;

import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.InventoryItemRepository;
import com.amromalkawi.technology.springcore.sample.ordersystem.domain.Product;
import com.amromalkawi.technology.springcore.sample.ordersystem.service.InventoryService;

import java.util.Map;

public class InventoryServiceImpl implements InventoryService {
    private final InventoryItemRepository inventoryItemRepository;

    public InventoryServiceImpl(InventoryItemRepository inventoryItemRepository){
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public Map<Product, Long> getTotalInventoryOnHand() {
        return null;
    }

    public long getQuantityOnHand(String itemId) {
        return 0;
    }

    public void adjustInventory(String itemId, long quantity) {

    }
}
