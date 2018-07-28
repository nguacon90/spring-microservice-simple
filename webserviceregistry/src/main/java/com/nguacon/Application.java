package com.nguacon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Optional;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = {"com.nguacon"})
@PropertySources({ @PropertySource(value = "classpath:application.yml"),
        @PropertySource(value = "file:config/application.yml", ignoreResourceNotFound = true) })
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Optional<String> version = Optional.ofNullable(Application.class.getPackage().getImplementationVersion());
        SpringApplication.run(Application.class, args);
        LOGGER.info(String.format("Webservice registry %s started.", version.orElse("")));
    }
}
