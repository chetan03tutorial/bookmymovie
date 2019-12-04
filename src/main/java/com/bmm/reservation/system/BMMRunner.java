package com.bmm.reservation.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;


public class BMMRunner extends BaseRunner {

    public void run(String[] args) {
        /*AnnotationConfigApplicationContext rootContext = new AnnotationConfigApplicationContext(RootConfig.class,
                WebConfig.class, DbConfig.class);*/
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        //SpringApplication app = new SpringApplication(RootConfig.class, WebConfig.class, DbConfig.class);
        //ConfigurableApplicationContext rootContext = app.run(args);
        ConfigurableApplicationContext rootContext = builder.parent(RootConfig.class).web(WebApplicationType.NONE).child(WebConfig.class).web(WebApplicationType.SERVLET).run(args);

        //SpringApplication springApplication = new SpringApplication();
        //ConfigurableApplicationContext rootContext = springApplication.run(JettyWebApplicationInitializer.class);
        //ServletContext servletContext = rootContext.getBean(ServletContext.class);
        //rootContext = (ConfigurableApplicationContext)servletContext.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
        print(rootContext.getBeanDefinitionNames());
        //print(rootContext.getParent().getBeanDefinitionNames());
    }

    public static void main(String[] args) {
        /*ApplicationRunner app = Runner1::run;
        app.apply(args);*/
        BaseRunner app = new BMMRunner();
        app.run(args);
    }
}
