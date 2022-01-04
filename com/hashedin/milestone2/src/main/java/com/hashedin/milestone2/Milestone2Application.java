package com.hashedin.milestone2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
public class Milestone2Application {

    public static void main(String[] args) {

        SpringApplication.run(Milestone2Application.class, args);
    }

}
