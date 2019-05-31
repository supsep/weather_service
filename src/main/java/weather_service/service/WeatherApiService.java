package weather_service.service;

import weather_service.domain.WeatherReport;
import weather_service.domain.WeatherRequest;
import weather_service.exception.ValidationException;

public interface WeatherApiService {

    /**
     *
     * @param city
     * @return
     */
    WeatherReport getWeatherForCity(String city) throws ValidationException;
}
