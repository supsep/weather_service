package weather_service.service;

import org.springframework.web.client.RestTemplate;

import weather_service.domain.WeatherReport;

import java.util.List;


public class WeatherApiServiceImpl implements WeatherApiService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<WeatherReport> getWeather(String city) {
        return null;
    }
}
