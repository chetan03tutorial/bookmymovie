package com.bmm.reservation.system;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner3 {
    public static void run(String[] args){
        SpringApplication runner  = new SpringApplication();
        runner.setApplicationContextClass(AnnotationConfigApplicationContext.class);
        runner.run(WebConfig.class);
    }


    public static void main(String[] args) {
        ApplicationRunner app = Runner3::run;
        app.apply(args);
    }
}
