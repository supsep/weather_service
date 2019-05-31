package weather_service.service;

import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import lombok.extern.slf4j.Slf4j;
import weather_service.WeatherApplicationProperties;
import weather_service.domain.WeatherRequest;
import weather_service.exception.ValidationException;

import java.net.URI;

@Slf4j
public class WeatherApiServiceImpl implements WeatherApiService {
    private RestTemplate restTemplate = new RestTemplate();
    private String apiEndpoint;
    private String apiKey;

    public WeatherApiServiceImpl(WeatherApplicationProperties weatherApplicationProperties) {
        this.apiKey = weatherApplicationProperties.getWeatherApiProperties().getApiKey();
        this.apiEndpoint = weatherApplicationProperties.getWeatherApiProperties().getEndpoint();
    }

    @Override
    public WeatherRequest getWeatherForCity(String city) throws ValidationException {
        if (log.isDebugEnabled()) {
            log.debug("City to search up: {}", city);
            log.debug("Accessing API URL: {}. API KEY: {}", apiEndpoint, apiKey);
        }

        validateRequest(city);
        URI url = new UriTemplate(this.apiEndpoint).expand(city, this.apiKey);


        return invokeApiRequest(url);
    }

    private WeatherRequest invokeApiRequest(URI url) {

    }
    

    private void validateRequest(String city) throws ValidationException {
        if (StringUtils.isEmpty(city)) {
            throw new ValidationException("City is empty");
        } else if (StringUtils.isEmpty(apiEndpoint)) {
            throw new ValidationException("API Endpoint URL is empty");
        } else if (StringUtils.isEmpty(apiKey)) {
            throw new ValidationException("API Endpoint key is empty");
        }
    }
}
