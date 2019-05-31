package weather_service.domain;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class WeatherRequest {
    private String id = UUID.randomUUID().toString();
    private Date requestedDate;
    private String city;
}
