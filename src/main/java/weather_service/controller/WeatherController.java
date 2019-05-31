package weather_service.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import weather_service.domain.WeatherReport;

import java.util.Date;

@Controller
public class WeatherController {


    @GetMapping("/weatherReport")
    public String weatherReportForm(Model model) {
        final WeatherReport weatherReport = new WeatherReport();
        model.addAttribute("weatherReport", weatherReport);
        return "weatherReport";
    }

    @PostMapping("/weatherReport")
    public String weatherReportSubmit(@ModelAttribute WeatherReport weatherReport) {
        weatherReport.setRequestedDate(new Date());
        // Set by city service

        // Set by weather service
        weatherReport.setToday(new Date());
        weatherReport.setFahrenheit(69.9);
        weatherReport.setCelsius(69.9);
        weatherReport.setSunrise(new Date());
        weatherReport.setSunset(new Date());
        weatherReport.setWeatherDescription("Cloudy with a chance of cats");


        return "weatherReportResult";
    }
}
