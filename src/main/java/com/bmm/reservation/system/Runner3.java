package com.bmm.reservation.system;

import com.bmm.reservation.system.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner3 {
    public static void run(String[] args){
        SpringApplication runner  = new SpringApplication();
        runner.setApplicationContextClass(AnnotationConfigApplicationContext.class);
        runner.run(AppConfig.class);
    }


    public static void main(String[] args) {
        ApplicationRunner app = Runner3::run;
        app.apply(args);
    }
}
