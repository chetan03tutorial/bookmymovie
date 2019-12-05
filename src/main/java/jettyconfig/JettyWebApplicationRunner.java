package jettyconfig;

import jettyconfig.JettyWebApplicationInitializer;
import org.springframework.boot.SpringApplication;

public class JettyWebApplicationRunner {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        application.run(JettyWebApplicationInitializer.class);
    }
}
