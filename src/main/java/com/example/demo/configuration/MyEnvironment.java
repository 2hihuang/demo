package com.example.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MyEnvironment implements EnvironmentAware {

    private static final Logger logger = LoggerFactory.getLogger(MyEnvironment.class);

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Override
    public void setEnvironment(Environment environment) {
        logger.info("spring el表达式：" + jdbcUrl);
        logger.info("LOGNAME: " + environment.getProperty("LOGNAME"));
        logger.info("spring.datasource.url: " + environment.getProperty("spring.datasource.url"));
    }
}
