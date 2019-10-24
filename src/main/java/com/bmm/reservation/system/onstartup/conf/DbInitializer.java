package com.bmm.reservation.system.onstartup.conf;

import com.bmm.reservation.system.WebConfig;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Optional;

public class DbInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigApplicationContext rootContext = new AnnotationConfigApplicationContext(WebConfig.class);
        ConfigurableApplicationContext registeredRootContext = (ConfigurableApplicationContext)servletContext.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
        Optional<ConfigurableApplicationContext> optional = Optional.of(registeredRootContext);
        if (optional.isPresent()){
            System.out.println("Root Context is already there");
        }
        //servletContext.setAttribute("org.springframework.web.context.WebApplicationContext.ROOT",rootContext);

        servletContext.setInitParameter("unnecessary-argument", "unnecessary-discussion");
    }
}
