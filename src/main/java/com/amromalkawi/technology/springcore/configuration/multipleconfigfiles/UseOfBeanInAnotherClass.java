package com.amromalkawi.technology.springcore.configuration.multipleconfigfiles;

import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


//simply add @Component to any class to let spring scan it for any
// instance variable with  @Autowire annotation to inject it with object from the bean factory config
//ofcourse first u have to define the construction of object UseOfBeanInAnotherClass in any class with @Configuration
//annotation ...we defined it in DataConfig.class like below
//@Bean
//public UseOfBeanInAnotherClass useOfBeanInAnotherClass(){return new UseOfBeanInAnotherClass();}


@Component
@PropertySource("classpath:/application.properties")   //@##@
public class UseOfBeanInAnotherClass {

    @Autowired //$##$
    private InventoryItemRepository inventoryItemRepository; //$##$

    @Value("${app.name}")     //@##@
    private String applicationName;  //@##@

    public String checkIfInventoryItemRepositoryIntanceIsNull(){
        return inventoryItemRepository==null?"NULL":"A OK";
    }

    public String getAppName(){ //@##@
        return this.applicationName; //@##@
    } //@##@
}
