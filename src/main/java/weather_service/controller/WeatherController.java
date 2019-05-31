package weather_service.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import weather_service.domain.WeatherRequest;

import java.util.Date;

@Slf4j
@Controller
public class WeatherController {


    @GetMapping("/weatherReport")
    public String weatherReportForm(Model model) {
        log.debug(" deb");
        final WeatherRequest weatherRequest = new WeatherRequest();
        model.addAttribute("weatherRequest", weatherRequest);
        return "weatherRequest";
    }

    @PostMapping("/weatherRequest")
    public String weatherReportSubmit(@ModelAttribute WeatherRequest weatherRequest) {
        log.debug(" deb");
        weatherRequest.setRequestedDate(new Date());
        // Set by city service

        // Set by weather service



        return "weatherReportResult";
    }
}
