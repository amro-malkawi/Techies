

package com.amromalkawi.technology.springcore.configuration.profilesinspring;


import com.amromalkawi.technology.springcore.sample.ordersystem.data.repository.CustomerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConfigWithProfiles {

    @Profile("dev")
    @Bean
    public CustomerRepository getDevCustomer() {
        System.out.println("getDevCustomer");
        return new CustomerRepository();
    }

   @Profile("prod")
    @Bean
    public CustomerRepository getProdCustomer() {
        System.out.println("getProdCustomer");
        return new CustomerRepository();
    }

    public static void main(String...args){
        ApplicationContext context=new AnnotationConfigApplicationContext(ConfigWithProfiles.class);
       CustomerRepository customerRepository=context.getBean(CustomerRepository.class);  //getDevCustomer will print this if below

        //if u dont set spring.profiles.active=dev in environemnt variable then below exception will apear after runnign the above
       // No qualifying bean of type CustomerRepository available

        // if u remove environemnt variable then below will not work unless u remove  @Profile("prod") from line 23
        //CustomerRepository customerRepository2=(CustomerRepository)context.getBean("getProdCustomer");
        //the above line will work if u set spring.profiles.active=prod not dev.
    }

}
