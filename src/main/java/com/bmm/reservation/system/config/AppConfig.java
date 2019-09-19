package com.bmm.reservation.system.config;

import com.bmm.reservation.system.onstartup.conf.DbInitializer;
import com.bmm.reservation.system.service.ReservationService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.bmm.reservation.system")
public class AppConfig {

    @Bean
    public ServletWebServerFactory jettyWebServerFactory(){
        JettyServletWebServerFactory jetty = new JettyServletWebServerFactory();
        jetty.addInitializers(new DbInitializer());
        jetty.setContextPath("/bookmymovie");
        jetty.setPort(9080);
        return jetty;
    }
}
