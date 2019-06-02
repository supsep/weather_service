package weather_service.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import weather_service.WeatherApplicationProperties;
import weather_service.domain.WeatherReport;
import weather_service.domain.WeatherRequest;
import weather_service.exception.ValidationException;
import weather_service.service.WeatherApiService;


@Slf4j
@Controller
public class WeatherController {
    private final WeatherApiService weatherService;

    private final WeatherApplicationProperties properties;

    public WeatherController(WeatherApiService weatherApiService, WeatherApplicationProperties properties) {
        this.weatherService = weatherApiService;
        this.properties = properties;
    }

    /**
     * API Endpoint for weather report form search.
     * @param model
     * @return View for weather report form.
     */
    @GetMapping("/weatherReport")
    public String weatherReportForm(Model model) {
        log.debug("Request for weather report form.");
        final WeatherRequest weatherRequest = new WeatherRequest();
        model.addAttribute("weatherRequest", weatherRequest);
        return "weatherReport";
    }

    /**
     * API endpoint for requesting weather report for supplied city.
     * @param weatherRequest Request form filled by user
     * @return ModelAndView Object containing weather report and weather report view.
     * @throws ValidationException Thrown if city is empty or external API raises error.
     */
    @PostMapping("/weatherReport")
    public ModelAndView weatherReportSubmit(@ModelAttribute("weatherRequest") WeatherRequest weatherRequest)
            throws ValidationException {
        log.debug("Request for weather report: {}", weatherRequest);

        ModelAndView modelAndView = new ModelAndView("weatherReportResult");

        // Get Weather for city
        WeatherReport weatherReportForCity = weatherService
            .getWeatherReportForCity(weatherRequest.getCity());
        modelAndView.addObject("weatherReport", weatherReportForCity);

        log.debug("Response for weather report: {}", weatherReportForCity);
        return modelAndView;
    }

    /**
     * Total exception handler for controller.
     * @param ex Exception raised.
     * @return View for error page
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView("error");
        return model;
    }
}
