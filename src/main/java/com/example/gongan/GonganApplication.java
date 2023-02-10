package com.example.gongan;

import com.example.gongan.util.lastTwoDay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.HashMap;



@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class GonganApplication {

    public static void main(String[] args) {
        SpringApplication.run(GonganApplication.class, args);
    }

}
