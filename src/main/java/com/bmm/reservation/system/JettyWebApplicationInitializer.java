package com.bmm.reservation.system;

import com.bmm.reservation.system.onstartup.conf.DbInitializer;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import java.util.Optional;

@Configuration
public class JettyWebApplicationInitializer {

    @Bean
    public ServletWebServerFactory jettyWebServerFactory(){
        JettyServletWebServerFactory jetty = new JettyServletWebServerFactory();
        jetty.addInitializers(new WebAppConfig());
        jetty.setContextPath("/bookmymovie");
        jetty.setPort(9080);
        return jetty;
    }


    private class WebAppConfig implements ServletContextInitializer{

        @Override
        public void onStartup(ServletContext servletContext) throws ServletException {
            ConfigurableApplicationContext registeredRootContext = (ConfigurableApplicationContext)servletContext.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
            Optional<ConfigurableApplicationContext> optional = Optional.of(registeredRootContext);
            if (optional.isPresent()){
                System.out.println("Root Context is already there and it has been refreshed");
                for(String beanName : registeredRootContext.getBeanDefinitionNames()){
                    System.out.println("Initialized bean name is " + beanName);
                }
            }
            // Chance to register our servlet, filters, listener, context etc
            // Let us try to register contextLoaderListerner with a rootContext
            System.out.println("Servlet Context Object is " + servletContext.toString());
            //servletContext.setAttribute("org.springframework.web.context.WebApplicationContext.ROOT", null);
            AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
            rootContext.register(RootConfig.class);
            //ContextLoaderListener listener = new ContextLoaderListener(rootContext);
            MyServletContextListener listener = new MyServletContextListener(rootContext);
            servletContext.addListener(listener);

            registeredRootContext = (ConfigurableApplicationContext)servletContext.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
            optional = Optional.of(registeredRootContext);
            if (optional.isPresent()){
                System.out.println("Root Context has been redefined and it has been refreshed");
                for(String beanName : registeredRootContext.getBeanDefinitionNames()){
                    System.out.println("Initialized bean name is " + beanName);
                }
            }
        }
    }

    private class MyServletContextListener implements ServletContextListener{

        private ConfigurableWebApplicationContext webApplicationContext;

        MyServletContextListener(ConfigurableWebApplicationContext webApplicationContext){
            this.webApplicationContext = webApplicationContext;
        }

        @Override
        public void contextInitialized(ServletContextEvent event) {
            System.out.println("Initializing the ServletContext again " + event.getServletContext().toString());
            webApplicationContext.setServletContext(event.getServletContext());
            webApplicationContext.refresh();
            event.getServletContext().setAttribute("org.springframework.web.context.WebApplicationContext.ROOT",webApplicationContext);

        }
    }
}
