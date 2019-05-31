package weather_service.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app")
public class WeatherApplicationProperties {
    private final WeatherApiProperties weatherApiProperties = new WeatherApiProperties();

    public WeatherApiProperties getWeatherApiProperties() {
        return weatherApiProperties;
    }

    /**
     * Class to hold API properties.
     */
    public class WeatherApiProperties {
        private String apiKey;
        private String endpoint;

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }
    }
}
