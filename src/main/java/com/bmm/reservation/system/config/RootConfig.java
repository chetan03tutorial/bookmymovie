package com.bmm.reservation.system.config;

import com.bmm.reservation.system.onstartup.conf.DbInitializer;
import com.bmm.reservation.system.service.ReservationService;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

    @Bean
    public ReservationService reservationService(){
        return new ReservationService();
    }



}
