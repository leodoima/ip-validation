package com.ipvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class IpValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpValidationApplication.class, args);
    }

}
