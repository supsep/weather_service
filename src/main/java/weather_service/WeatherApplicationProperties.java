package weather_service;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "application.api")
public class WeatherApplicationProperties {
    // API Key for Endpoint
    private String key;

    // API Endpoint URL
    private String endpoint;
}
