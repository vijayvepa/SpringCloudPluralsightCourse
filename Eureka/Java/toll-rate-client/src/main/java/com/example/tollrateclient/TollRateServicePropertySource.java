package com.example.tollrateclient;

import org.springframework.core.env.PropertySource;

public class TollRateServicePropertySource extends PropertySource<String>{
    public static final String NAME = "toll-rate-service.name";

    public TollRateServicePropertySource(String name) {
        super(name);
    }

    @Override
    public Object getProperty(String name) {
        if(!name.startsWith(NAME))
            return null;

        return TollRateServiceInfo.NAME;
    }
}
