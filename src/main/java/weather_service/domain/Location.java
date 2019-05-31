package weather_service.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Locale;

@Data
public class Location implements Serializable {
    // City geo location, longitude
    private double lon;

    // City geo location, latitude
    private double lat;

    // Name of City
    private String name;

    // City IDs which can be found in http://bulk.openweathermap.org/sample/
    private String id;

    // ISO-3166 code for country
    private String country;
    private Locale local;
}
