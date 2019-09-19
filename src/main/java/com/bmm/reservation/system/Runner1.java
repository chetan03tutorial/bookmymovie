package com.bmm.reservation.system;

import com.bmm.reservation.system.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.stream.Stream;

public class Runner1 {

    public static void run(String[] args) {
        AnnotationConfigApplicationContext rootContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Stream<String> beanNames = Arrays.asList(rootContext.getBeanDefinitionNames()).stream();
        beanNames.forEach(System.out :: println);
    }

    public static void main(String[] args) {
        ApplicationRunner app = Runner1::run;
        app.apply(args);
    }
}
