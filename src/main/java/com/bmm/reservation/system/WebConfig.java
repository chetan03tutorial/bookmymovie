package com.bmm.reservation.system;

import com.bmm.reservation.system.onstartup.conf.DbInitializer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public ServletWebServerFactory jettyWebServerFactory(){
        JettyServletWebServerFactory jetty = new JettyServletWebServerFactory();
        jetty.addInitializers(new DbInitializer());
        jetty.setContextPath("/bookmymovie");
        jetty.setPort(9080);
        return jetty;
    }
}
