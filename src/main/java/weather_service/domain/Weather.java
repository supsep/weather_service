package weather_service.domain;

import static weather_service.utils.TemperatureUtility.kelvinToCelsius;
import static weather_service.utils.TemperatureUtility.kelvinToFahrenheit;

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
    private double tempCelsius;
    private double tempFahrenheit;

    // Minimum temperature at the moment. This is deviation from current temp that is possible for
    // large cities and megalopolises geographically expanded
    private double minTempCelsius;
    private double minTempFahrenheit;

    // Minimum temperature at the moment. This is deviation from current temp that is possible for
    // large cities and megalopolises geographically expanded
    private double maxTempCelsius;
    private double maxTempFahrenheit;

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

    public void setTemp(double tempInKelvin){
        setTempCelsius(kelvinToCelsius(tempInKelvin));
        setTempFahrenheit(kelvinToFahrenheit(tempInKelvin));
    }

    public void setMinTemp(double tempInKelvin){
        setMinTempCelsius(kelvinToCelsius(tempInKelvin));
        setMinTempFahrenheit(kelvinToFahrenheit(tempInKelvin));
    }

    public void setMaxTemp(double tempInKelvin){
        setMaxTempCelsius(kelvinToCelsius(tempInKelvin));
        setMaxTempFahrenheit(kelvinToFahrenheit(tempInKelvin));
    }

    // TODO: Add cloud, rain and snow details
}
