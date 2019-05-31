package weather_service.domain;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class WeatherReport {
    private String id = UUID.randomUUID().toString();
    private Date requestedDate;
    private Date today;
    private String city;
    private String weatherDescription;
    private Date sunrise;
    private Date sunset;
    private double celsius;
    private double fahrenheit;
}
