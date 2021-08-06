package com.tuling.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TulingmallAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TulingmallAuthApplication.class, args);
    }

}
