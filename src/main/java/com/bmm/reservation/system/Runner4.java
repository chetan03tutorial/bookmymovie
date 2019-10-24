package com.bmm.reservation.system;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.stream.Stream;

public class Runner4 {

    public static void run(String args[]) {
        AnnotationConfigApplicationContext rootContext = new AnnotationConfigApplicationContext(WebConfig.class);
        JettyServletWebServerFactory webServerFactory = (JettyServletWebServerFactory) rootContext.getBean(ServletWebServerFactory.class);
        Stream<String> beanNames = Arrays.asList(rootContext.getBeanDefinitionNames()).stream();
        beanNames.forEach(System.out :: println);
    }

    public static void main(String[] args) {
        ApplicationRunner app = Runner4::run;
        app.apply(args);
    }
}
