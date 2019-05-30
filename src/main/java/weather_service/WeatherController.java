package weather_service;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        weatherReport.setTemperatureCelcius(69.9);
        return "weatherReportResult";
    }

}
