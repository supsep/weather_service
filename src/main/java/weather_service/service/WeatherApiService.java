package weather_service.service;

import weather_service.domain.WeatherReport;

import java.util.List;

public interface WeatherApiService {

    /**
     *
     * @param city
     * @return
     */
    List<WeatherReport> getWeather(String city);
}
