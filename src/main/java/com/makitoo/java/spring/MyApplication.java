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
        Makitoo makitoo = com.makitoo.MakitooJava.init(
                "http://localhost:4567/rest",
                "kiabidemo-d09657bc-44eb-49da-b9a9-8f119557b2c6",   // Application ID
                "71rakfdpv33oflg0op7immc85j",                     // Application token
                "0.0.1"                                           // Current version of your application
        );

        Config config = (Config) makitoo.getConfig();
        config.recursiveContextSize.set(3);

        SpringApplication.run(MyApplication.class);
    }

}
