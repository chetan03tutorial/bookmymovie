package com.bmm.reservation.system;

import com.bmm.reservation.system.annotations.IgnoreDuringScan;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


import java.io.IOException;

@Configuration
@ComponentScan(basePackages = {"com.bmm.reservation.system"}, excludeFilters = {@ComponentScan.Filter(IgnoreDuringScan.class)})
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
