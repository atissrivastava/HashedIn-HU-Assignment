package com.hashedin.milestone2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Milestone2Application {

    public static void main(String[] args) {

        SpringApplication.run(Milestone2Application.class, args);
    }

}
