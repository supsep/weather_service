package weather_service.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import weather_service.WeatherApplicationProperties;
import weather_service.domain.WeatherReport;
import weather_service.domain.WeatherRequest;
import weather_service.exception.ValidationException;
import weather_service.service.WeatherApiService;

import java.util.Date;

@Slf4j
@Controller
public class WeatherController {
    private final WeatherApiService weatherService;

    private final WeatherApplicationProperties properties;

    public WeatherController(WeatherApiService weatherApiService, WeatherApplicationProperties properties) {
        this.weatherService = weatherApiService;
        this.properties = properties;
    }

    @GetMapping("/weatherReport")
    public String weatherReportForm(Model model) {
        log.debug(" deb");
        final WeatherRequest weatherRequest = new WeatherRequest();
        model.addAttribute("weatherRequest", weatherRequest);
        return "weatherReport";
    }

    @PostMapping("/weatherReport")
    public ModelAndView weatherReportSubmit(@ModelAttribute WeatherRequest weatherRequest)
            throws ValidationException {
        log.debug(" deb");
        weatherRequest.setRequestedDate(new Date());
        ModelAndView modelAndView = new ModelAndView("weatherReportResult");
        WeatherReport weatherReportForCity = weatherService
            .getWeatherReportForCity(weatherRequest.getCity());
        modelAndView.addObject("weatherReport", weatherReportForCity);
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {

        ModelAndView model = new ModelAndView("error");
        return model;

    }
}
