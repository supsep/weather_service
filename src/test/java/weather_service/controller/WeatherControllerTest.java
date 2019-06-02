package weather_service.controller;

import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import weather_service.WeatherApplicationProperties;
import weather_service.WeatherTestUtils;
import weather_service.domain.WeatherReport;
import weather_service.domain.WeatherRequest;
import weather_service.exception.ValidationException;
import weather_service.service.WeatherApiService;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {
  private WeatherReport weatherReport;
  private WeatherRequest weatherRequest;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private WeatherApiService serviceMock;

  @MockBean
  private WeatherApplicationProperties weatherApplicationProperties;

  @Before
  public void setup() throws Exception {
    weatherReport = WeatherTestUtils.createWeatherReport();
    weatherRequest = WeatherTestUtils.createWeatherRequest();
    when(serviceMock.getWeatherReportForCity(weatherRequest.getCity())).thenReturn(weatherReport);
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetWeatherRequestForm() throws Exception {
    this.mockMvc.perform(get("/weatherReport"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(model().attribute("weatherRequest", hasProperty("city", nullValue())));
  }


  @Test
  public void testPostWeatherRequestForm() throws Exception {
    this.mockMvc.perform(post("/weatherReport")
        .flashAttr("weatherRequest", weatherRequest))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(model().attribute("weatherReport", weatherReport));
  }

  @Test
  public void testPostWeatherRequestForException() throws Exception {
    // Raise exception
    when(serviceMock.getWeatherReportForCity(weatherRequest.getCity()))
        .thenThrow(new ValidationException("Error"));


    this.mockMvc.perform(post("/weatherReport")
        .flashAttr("weatherRequest", weatherRequest))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(view().name("error"));
  }
}