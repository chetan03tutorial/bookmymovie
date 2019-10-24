package com.bmm.reservation.system;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


import java.io.IOException;

@Configuration
@ComponentScan("com.bmm.reservation.system")
@EnableAutoConfiguration
public class RootConfig {
    @Bean
    public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
            throws IOException {
        String env = System.getProperty("env");
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/**.properties"));
        return ppc;
    }
}
