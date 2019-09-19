package com.bmm.reservation.system;

import com.bmm.reservation.system.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.servlet.ServletContext;
import java.util.Arrays;

public class Runner2 {

    public static void run(String[] args){
        // Manually creating an application context from AppConfig.
        ConfigurableApplicationContext rootContext = SpringApplication.run(AppConfig.class, args);
        ServletContext servletContext = rootContext.getBean(ServletContext.class);
        System.out.println("values in servlet context is " + servletContext.getInitParameter("unnecessary-argument"));

        ConfigurableApplicationContext registeredRootContext = (ConfigurableApplicationContext)servletContext.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
        System.out.println("Beans registered in application context  " + registeredRootContext + "  are ");
        Arrays.asList(registeredRootContext.getBeanDefinitionNames()).stream().forEach(System.out::println);

        if(registeredRootContext.equals(rootContext)){
            System.out.println("Application Context is registered as a attribute in servlet context");
        }
    }

    public static void main(String[] args) {
        ApplicationRunner app = Runner2::run;
        app.apply(args);
    }
}
