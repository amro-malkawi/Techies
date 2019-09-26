package com.amromalkawi.technology.springcore.configuration;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirstConfig {

    @Bean
    public String greeting(){
        return "hello config";
    }

    public static void main(String...args){
        ApplicationContext context=new AnnotationConfigApplicationContext(FirstConfig.class);
        String text = (String) context.getBean("greeting");
        System.out.println("text: "+text);
    }
}
