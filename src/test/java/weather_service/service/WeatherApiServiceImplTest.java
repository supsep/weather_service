package weather_service.service;


import static org.junit.Assert.assertNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import weather_service.WeatherApplicationProperties;
import weather_service.WeatherTestUtils;
import weather_service.domain.WeatherReport;
import weather_service.exception.ValidationException;

public class WeatherApiServiceImplTest {
  private static final String KEY = "key123";
  private static final String CITY = "London";
  private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
  private static final String QUERY_PARAM = "weather?q={city}&APPID={key}";
  private static final String URL = BASE_URL + "weather?q="+CITY+"&APPID="+KEY;

  private WeatherApiService weatherService;
  private MockRestServiceServer server;
  private RestTemplate restTemplate;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setup() {
    restTemplate = new RestTemplate();
    initializeWeatherService(KEY,BASE_URL + QUERY_PARAM);
    this.server = MockRestServiceServer.createServer(restTemplate);
  }

  @After
  public void tearDown() {
    restTemplate = null;
    this.weatherService = null;
    this.server = null;
  }

  @Test
  public void testGetWeatherReport() throws Exception{
    ClassPathResource classPathResource = new ClassPathResource("london.json", getClass());
    this.server.expect(requestTo(URL))
        .andRespond(withSuccess(classPathResource, MediaType.APPLICATION_JSON));

    WeatherReport weatherReportFromJson = this.weatherService.getWeatherReportForCity(CITY);
    Assert.assertEquals(WeatherTestUtils.createWeatherReport(), weatherReportFromJson);

    this.server.verify();
  }

  @Test
  public void testGetWeatherReportForCityForEmptyCity() throws ValidationException {
    thrown.expect(ValidationException.class);
    thrown.expectMessage("City is empty");
    WeatherReport weatherReport = this.weatherService.getWeatherReportForCity("");

    assertNull(weatherReport);
  }

  @Test
  public void testGetWeatherReportForCityForNullCity() throws ValidationException {

    thrown.expect(ValidationException.class);
    thrown.expectMessage("City is empty");
    WeatherReport weatherReport = this.weatherService.getWeatherReportForCity(null);

    assertNull(weatherReport);
  }

  @Test
  public void testGetWeatherReportForCityForEmptyAPIUrl() throws ValidationException {
    initializeWeatherService(KEY, "");

    thrown.expect(ValidationException.class);
    thrown.expectMessage("API Endpoint URL is empty");
    WeatherReport weatherReport = this.weatherService.getWeatherReportForCity(CITY);

    assertNull(weatherReport);
  }

  @Test
  public void testGetWeatherReportForCityForNullAPIUrl() throws ValidationException {
    initializeWeatherService(KEY, null);

    thrown.expect(ValidationException.class);
    thrown.expectMessage("API Endpoint URL is empty");
    WeatherReport weatherReport = this.weatherService.getWeatherReportForCity(CITY);

    assertNull(weatherReport);
  }

  @Test
  public void testGetWeatherReportForCityForEmptyAPIKey() throws ValidationException {
    String url = BASE_URL + QUERY_PARAM;
    initializeWeatherService("", url);

    thrown.expect(ValidationException.class);
    thrown.expectMessage("API Endpoint key is empty");
    WeatherReport weatherReport = this.weatherService.getWeatherReportForCity(CITY);

    assertNull(weatherReport);
  }

  @Test
  public void testGetWeatherReportForCityForNullAPIKey() throws ValidationException {
    String url = BASE_URL + QUERY_PARAM;
    initializeWeatherService(null, url);

    thrown.expect(ValidationException.class);
    thrown.expectMessage("API Endpoint key is empty");

    WeatherReport weatherReport = this.weatherService.getWeatherReportForCity(CITY);

    assertNull(weatherReport);
  }


  private void initializeWeatherService(String Key, String url) {
    WeatherApplicationProperties properties = new WeatherApplicationProperties();
    properties.setKey(Key);
    properties.setEndpoint(url);
    this.weatherService = new WeatherApiServiceImpl(restTemplate, properties);
  }
}
