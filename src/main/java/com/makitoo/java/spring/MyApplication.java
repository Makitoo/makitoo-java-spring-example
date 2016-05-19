package com.makitoo.java.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by mclement on 5/17/2016.
 */
@ComponentScan
@EnableAutoConfiguration
public class MyApplication {

    public static void main(String[] args) {
        com.makitoo.MakitooJava.init(
                "https://dashboard.makitoo.com/rest",
                "APPLICATION_ID",   // Application ID
                "TOKEN",            // Application TOKEN
                "0.0.1");
        SpringApplication.run(MyApplication.class);
    }

}
