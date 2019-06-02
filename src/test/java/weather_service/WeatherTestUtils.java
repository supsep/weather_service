package weather_service;

import java.util.Date;
import lombok.experimental.UtilityClass;
import weather_service.domain.Location;
import weather_service.domain.Weather;
import weather_service.domain.WeatherReport;
import weather_service.domain.WeatherRequest;

@UtilityClass
public class WeatherTestUtils {

  public WeatherRequest createWeatherRequest() {
    WeatherRequest request = new WeatherRequest();
    request.setCity("London");
    return request;
  }

  public WeatherReport createWeatherReport() {
    WeatherReport weatherReport = new WeatherReport();
    weatherReport.setTimestamp(new Date().getTime());
    weatherReport.setLocation(createLocation());
    weatherReport.setWeather(createWeather());
    return weatherReport;
  }

  private Location createLocation() {
    Location location = new Location();
    location.setName("London");
    location.setLat(51.51);
    location.setLon(-0.13);
    location.setCountry("GB");
    location.setId("5091");
    return location;
  }

  private Weather createWeather() {
    Weather weather = new Weather();
    weather.setStatus("Drizzle");
    weather.setStatusDescription("light intensity drizzle");
    weather.setIcon("09d");
    weather.setTemp(280.32F);
    weather.setPressure(1012);
    weather.setHumidity(81);
    weather.setMinTemp(279.15F);
    weather.setMaxTemp(281.15F);
    weather.setVisibility(10000);
    weather.setWindSpeed(4.1);
    weather.setWindDegrees(80);
    return weather;
  }
}