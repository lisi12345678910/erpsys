package com.zte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zte")
public class MainSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(MainSpringBoot.class,args);
    }
}
