package com.bmm.reservation.system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootApplicationDrivenApplicationRunner {

    public static void main(String[] args) {
        ApplicationContext rootContext = SpringApplication.run(SpringBootApplicationDrivenApplicationRunner.class,args);
        List<String> beanNames = Arrays.asList(rootContext.getBeanDefinitionNames());
        for(String beanName : beanNames){
            System.out.println("Bean name is " + rootContext.getBean(beanName));
        }
    }
}
