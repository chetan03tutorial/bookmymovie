package com.bmm.reservation.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableJpaRepositories(
        basePackages = {"com.bmm.reservation.system.dao.**"},
        entityManagerFactoryRef = "catalogEntityManager",
        transactionManagerRef = "catalogTransactionManager"
)
@PropertySource({"classpath:database.properties"})
public class DbConfig {

    @Autowired
    private Environment environment;
    private static final JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

    @Autowired
    public DbConfig(Environment environment) {
        this.environment = environment;
    }


    @Bean
    public PlatformTransactionManager catalogTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(catalogEntityManager().getObject());
        return jpaTransactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean catalogEntityManager() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(datasource());
        // To set up the multiple packages to scan
        entityManagerFactoryBean.setPackagesToScan(new String[]{"com.bmm.reservation.system.model.movie"}); //new String[] {environment.getProperty("db.jpa.entity.packageToScan")}
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setJpaProperties(jpaProperties());
        return entityManagerFactoryBean;
    }


    @Bean
    public DataSource datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.db.driver.classname"));
        dataSource.setUrl(environment.getProperty("spring.db.schema"));
        dataSource.setUsername(environment.getProperty("spring.db.username"));
        dataSource.setPassword(environment.getProperty("spring.db.password"));
        return dataSource;
    }

    /**
     * This is a configuration class for configuring the datasource, JPA Vendor specific properties and Transaction Manager
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        return jpaVendorAdapter;
    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("spring.hbn.hbm2ddl.auto"));
        properties.setProperty("hibernate.dialect", environment.getProperty("spring.hbn.dialect"));
        return properties;
    }

}
