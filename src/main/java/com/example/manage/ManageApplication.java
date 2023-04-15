package com.example.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManageApplication {

    private int age;

    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }

}
