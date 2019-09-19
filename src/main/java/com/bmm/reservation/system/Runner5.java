package com.bmm.reservation.system;

import com.bmm.reservation.system.config.AppConfig;
import com.bmm.reservation.system.config.RootConfig;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

public class Runner5 {

    public static void run(String args[]){
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        ConfigurableApplicationContext registeredRootContext = builder.parent(RootConfig.class).web(WebApplicationType.NONE).child(AppConfig.class).web(WebApplicationType.SERVLET).run(args);
        System.out.println("Beans registered in application context  " + registeredRootContext + "  are ");
        Arrays.asList(registeredRootContext.getBeanDefinitionNames()).stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        ApplicationRunner app = Runner5::run;
        app.apply(args);
    }

}
