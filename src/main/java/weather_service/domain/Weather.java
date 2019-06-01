package weather_service.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Weather implements Serializable {
    // Weather status
    private String status;

    // Weather status description
    private String statusDescription;

    // Weather icon code. Lookup on http://openweathermap.org/img/w/<icon>
    private String icon;

    // Temperature in Kelvin
    private double temp;

    // Minimum temperature at the moment. This is deviation from current temp that is possible for large cities
    // and megalopolises geographically expanded
    private double minTemp;

    // Minimum temperature at the moment. This is deviation from current temp that is possible for large cities
    // and megalopolises geographically expanded
    private double maxTemp;

    // Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
    private int pressure;

    // Humidity, %
    private int humidity;

    // Wind speed. Unit Default: meter/sec
    private double windSpeed;

    // Wind direction, degrees
    private int windDegrees;

    // Sunset time, unix, UTC
    private long sunset;

    // Sunrise time, unix, UTC
    private long sunrise;

    // Visibility in meters
    private long visibility;

    // TODO: Add cloud, rain and snow details
}
