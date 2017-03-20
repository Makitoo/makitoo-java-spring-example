package com.makitoo.java.spring;

import com.makitoo.Makitoo;
import com.makitoo.internal.Config;
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
        Makitoo makitoo =     com.makitoo.MakitooJava.init(
                "http://localhost:4567/rest",
                "kiabidemo-2c90eb42-fc0a-4dc6-997d-b9c72e0bb7ca",   // Application ID
                "u574mft59jgocn3cu98qv08fi5",                     // Application token
                "0.0.1"                                           // Current version of your application
        );

        Config config = (Config) makitoo.getConfig();
        config.recursiveContextSize.set(3);

        SpringApplication.run(MyApplication.class);
    }

}
