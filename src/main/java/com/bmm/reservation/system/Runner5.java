package com.bmm.reservation.system;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class Runner5 {

    public static void run(String args[]){
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        ConfigurableApplicationContext registeredRootContext = builder.parent(RootConfig.class).web(WebApplicationType.NONE).child(WebConfig.class).web(WebApplicationType.SERVLET).run(args);
        System.out.println("Beans registered in application context  " + registeredRootContext + "  are ");
        Arrays.asList(registeredRootContext.getBeanDefinitionNames()).stream().forEach(System.out::println);


        Environment env = registeredRootContext.getBean(Environment.class);
        System.out.println(env.getProperty("appName"));
    }

    public static void main(String[] args) {
        ApplicationRunner app = Runner5::run;
        app.apply(args);
    }

}
