package com.amromalkawi.technology.springcore.configuration.multipleconfigfiles;

import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.CustomerRepository;
import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.InventoryItemRepository;
import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.SalesOrderRepository;
import com.amromalkawi.technology.springcore.sample.ordersystem.service.InventoryService;
import com.amromalkawi.technology.springcore.sample.ordersystem.service.OrderService;
import com.amromalkawi.technology.springcore.sample.ordersystem.service.impl.InventoryServiceImpl;
import com.amromalkawi.technology.springcore.sample.ordersystem.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;


//$##$
//moving below beans to DataConfig


//@##@ : define properties values

@Configuration
@Import(DataConfig.class)   //$##$
@PropertySource("classpath:/application.properties")   //@##@
public class AppConfig {

    @Value("${app.name}")     //@##@
    private String applicationName;  //@##@

    @Bean                        //@##@
    public String getAppName(){ //@##@
        return this.applicationName; //@##@
    } //@##@

    @Bean
    public OrderService orderService(InventoryService inventoryService, CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository){
        return new OrderServiceImpl(inventoryService, customerRepository, salesOrderRepository);
    }

    @Bean
    public InventoryService inventoryService(InventoryItemRepository inventoryItemRepository){
        return new InventoryServiceImpl(inventoryItemRepository);
    }

    @Autowired //$##$
    private InventoryItemRepository inventoryItemRepository; //$##$
    @Autowired //$##$
    private CustomerRepository customerRepository; //$##$
    @Autowired //$##$
    private SalesOrderRepository salesOrderRepository; //$##$

    //$##$
//    @Bean
//    public InventoryItemRepository inventoryItemRepository(){return new InventoryItemRepository();}
//
//    @Bean
//    public CustomerRepository customerRepository(){
//        return new CustomerRepository();
//    }
//
//    @Bean
//    public SalesOrderRepository salesOrderRepository(){
//        return new SalesOrderRepository();
//    }

    public static void main (String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //we can use below OrderService.class if there is only one @Bean configured that return type of OrderService
        OrderService orderService = context.getBean(OrderService.class);
        OrderService orderService2 = (OrderService) context.getBean("orderService");
        System.out.println(orderService==null?"NULL":"A OK");
        System.out.println(orderService2==null?"NULL":"A OK");


        String appName=(String) context.getBean("getAppName");  //@##@
        System.out.println("getAppName="+appName);                //@##@
    }
}

