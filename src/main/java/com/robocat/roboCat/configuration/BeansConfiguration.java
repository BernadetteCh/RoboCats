package com.robocat.roboCat.configuration;

import com.robocat.roboCat.service.CatStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class BeansConfiguration {
    @Bean
    CatStorage catStorage() {
        return new CatStorage(new ArrayList<>());
    }
}
