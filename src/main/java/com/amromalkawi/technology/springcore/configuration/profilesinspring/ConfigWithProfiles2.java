package com.amromalkawi.technology.springcore.configuration.profilesinspring;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application-${spring.profiles.active}.properties")
public class ConfigWithProfiles2 {

    @Value("${app.name}")       // pay attention here if u use @Value("Amro")  then it will get the value "Amro"
    private String appName;

    public String getAppName() {
        return appName;
    }

    @Value("#{new Boolean(environment['spring.profiles.active']=='dev')}")   //eexample of spring expression language
    private boolean isDev;

    public boolean isDev() {
        return isDev;
    }

    @Bean
    public ConfigWithProfiles2 getConfigProfiles2(){
        return new ConfigWithProfiles2();
    }




    public static void main(String...args){
        ApplicationContext context=new AnnotationConfigApplicationContext(ConfigWithProfiles2.class);
        ConfigWithProfiles2 conf =  (ConfigWithProfiles2)context.getBean("getConfigProfiles2");
        System.out.println("conf app name: "+conf.getAppName());
        System.out.println("conf isDev: "+conf.isDev());
    }







}


