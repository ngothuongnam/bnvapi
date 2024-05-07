package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${url}")
    private String url;

    @Value("${driver}")
    private String driver;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    @Bean
    public DatabaseConnector getConnector(){
        return new DatabaseConnector(url, driver, user, password);
    }
}
