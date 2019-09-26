package com.amromalkawi.technology.springcore.beanscope;

import com.amromalkawi.technology.springcore.configuration.FirstConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanScopeConfig {

    @Bean
    public DataObject getDataObjectSinglton(){
        return new DataObject();
    }


    @Bean
    @Scope("prototype")
    public DataObject getDataObjectPrototype(){
        return new DataObject();
    }


    public static void main(String...args){
        ApplicationContext context=new AnnotationConfigApplicationContext(BeanScopeConfig.class);
        DataObject dataObjectSinglton1 = (DataObject) context.getBean("getDataObjectSinglton");
        DataObject dataObjectSinglton2 = (DataObject) context.getBean("getDataObjectSinglton");
         System.out.println("-------------------- ");
        DataObject dataObjectPrototype1 = (DataObject) context.getBean("getDataObjectPrototype");
        DataObject dataObjectPrototype2 = (DataObject) context.getBean("getDataObjectPrototype");
       // System.out.println("text: "+text);
    }
}
