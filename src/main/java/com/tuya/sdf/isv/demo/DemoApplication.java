package com.tuya.sdf.isv.demo;

import com.tuya.connector.spring.annotations.ConnectorScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"com.tuya.sdf.isv", "com.tuya.sdf.starter", "com.tuya.highway"})
@ConnectorScan(basePackages = {"com.tuya.sdf.isv.**.connector"})
@ImportResource(locations = {"classpath:spring-config.xml"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
