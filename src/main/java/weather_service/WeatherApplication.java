package weather_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import weather_service.domain.WeatherApplicationProperties;

@SpringBootApplication
@EnableConfigurationProperties(WeatherApplicationProperties.class)
public class WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }

}
