package com.springbok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@EntityScan(basePackages = {"com.springbok.entity", "com.springbok.Enquiryentity"})
public class CounsellerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CounsellerApplication.class, args);
    }
}


