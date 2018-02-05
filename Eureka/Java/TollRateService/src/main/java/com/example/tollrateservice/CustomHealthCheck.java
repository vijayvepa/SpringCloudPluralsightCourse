package com.example.tollrateservice;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {
    int errorCode = 0;

    @Override
    public Health health() {
        System.out.println("health check performed, error code  = " + errorCode);

        if(errorCode > 4 && errorCode < 8){
            errorCode++;
            return Health.down().withDetail("Error Code", errorCode).build();

        }

        errorCode++;

        return Health.up().build();
    }
}
