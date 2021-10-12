package com.example.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyScheduleConfig {

    private static final Logger logger = LoggerFactory.getLogger(MyScheduleConfig.class);

    @Scheduled(cron = "0 0/1 * * * ?")
    public void job() {
        logger.info("this is my first job");
    }

}
