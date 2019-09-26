package com.amromalkawi.technology.springcore.configuration.multipleconfigfiles;

import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.InventoryItemRepository;
import com.amromalkawi.technology.springcore.sample.ordersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;


public class MainMultipleConfig {



    public static void main (String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);



        UseOfBeanInAnotherClass useOfBeanInAnotherClass=context.getBean(UseOfBeanInAnotherClass.class);
        System.out.println(useOfBeanInAnotherClass.checkIfInventoryItemRepositoryIntanceIsNull()); //will return ok
        System.out.println(useOfBeanInAnotherClass.getAppName()); //will app name from property file unless u defined global variable

        UseOfBeanInAnotherClass useOfBeanInAnotherClass2=new UseOfBeanInAnotherClass();
        System.out.println(useOfBeanInAnotherClass2.checkIfInventoryItemRepositoryIntanceIsNull());  //will return null
    }
}
