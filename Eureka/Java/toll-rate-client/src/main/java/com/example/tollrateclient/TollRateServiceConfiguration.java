package com.example.tollrateclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

@Configuration
public class TollRateServiceConfiguration {

    @Autowired
    private ConfigurableEnvironment environment;

    @Bean
    @Lazy(false)
    public  TollRateServicePropertySource tollRateServicePropertySource(){
        TollRateServicePropertySource source = new TollRateServicePropertySource(TollRateServicePropertySource.NAME);
        MutablePropertySources sources = environment.getPropertySources();
        sources.addFirst(source);
        return source;
    }
}
