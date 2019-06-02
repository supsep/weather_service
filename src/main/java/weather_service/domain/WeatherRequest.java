package weather_service.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class WeatherRequest {
    private String id = UUID.randomUUID().toString();
    private String city;
}
