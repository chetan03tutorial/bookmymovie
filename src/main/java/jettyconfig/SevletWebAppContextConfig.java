package jettyconfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude ={ DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.bmm.reservation.system.beans"})
public class SevletWebAppContextConfig {



}
