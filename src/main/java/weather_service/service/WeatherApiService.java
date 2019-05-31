package weather_service.service;

import weather_service.domain.WeatherRequest;
import weather_service.exception.ValidationException;

public interface WeatherApiService {

    /**
     *
     * @param city
     * @return
     */
    WeatherRequest getWeatherForCity(String city) throws ValidationException;
}
