package com.amromalkawi.technology.springcore.configuration.multipleconfigfiles;

import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.CustomerRepository;
import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.InventoryItemRepository;
import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.SalesOrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {


    @Bean
    public UseOfBeanInAnotherClass useOfBeanInAnotherClass(){return new UseOfBeanInAnotherClass();}


    @Bean
    public InventoryItemRepository inventoryItemRepository(){return new InventoryItemRepository();}

    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepository();
    }

    @Bean
    public SalesOrderRepository salesOrderRepository(){
        return new SalesOrderRepository();
    }

}

