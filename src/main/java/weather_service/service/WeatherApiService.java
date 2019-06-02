package weather_service.service;

import weather_service.domain.WeatherReport;
import weather_service.exception.ValidationException;

public interface WeatherApiService {

    /**
     * Acquire a detailed weather report for a provided city at the current time.
     * @param city String city to search weather for
     * @return DetailedWeather report for city.
     * @throws ValidationException Thrown if city is empty or external API raises error.
     */
    WeatherReport getWeatherReportForCity(String city) throws ValidationException;
}
