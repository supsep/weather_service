package weather_service;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.Getter;

@ConfigurationProperties("app")
public class WeatherApplicationProperties {
    @Getter
    private final WeatherApiProperties weatherApiProperties = new WeatherApiProperties();

    /**
     * Class to hold API properties.
     */
    @Data
    public class WeatherApiProperties {
        private String apiKey;
        private String endpoint;
    }
}
