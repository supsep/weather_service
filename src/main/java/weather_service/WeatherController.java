package weather_service;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {


    @GetMapping("/weatherReport")
    public String weatherReportForm(Model model) {
        model.addAttribute("weatherReport", new WeatherReport());
        return "weatherReport";
    }

    @PostMapping("/weatherReport")
    public String weatherReportSubmit(@ModelAttribute WeatherReport weatherReport) {
        return "result";
    }

}