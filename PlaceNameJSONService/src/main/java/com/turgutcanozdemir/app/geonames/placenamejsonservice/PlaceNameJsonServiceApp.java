package com.turgutcanozdemir.app.geonames.placenamejsonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.turgutcanozdemir")
@EntityScan(basePackages = "com.turgutcanozdemir")
@ComponentScan(basePackages = "com.turgutcanozdemir")
public class PlaceNameJsonServiceApp {

    public static void main(String[] args)
    {
        SpringApplication.run(PlaceNameJsonServiceApp.class, args);
    }

}
