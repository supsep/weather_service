package weather_service;

import java.util.Date;
import java.util.UUID;

public class WeatherReport {
    private String id = UUID.randomUUID().toString();
    private Date requestedDate;
    private Date today;
    private String city;
    private String weatherDescription;
    private double temperatureCelsius;
    private double temperatureFahrenheit;
    private Date sunrise;
    private Date sunset;

    public WeatherReport() {
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public double getTemperatureCelcius() {
        return temperatureCelsius;
    }

    public void setTemperatureCelcius(double temperatureFahrenheit) {
        this.temperatureCelsius = temperatureFahrenheit;
    }

    public double getTemperatureFarenheit() {
        return temperatureFahrenheit;
    }

    public void setTemperatureFarenheit(double temperatureFahrenheit) {
        this.temperatureFahrenheit = temperatureFahrenheit;
    }

    public Date getSunrise() {
        return sunrise;
    }

    public void setSunrise(Date sunrise) {
        this.sunrise = sunrise;
    }

    public Date getSunset() {
        return sunset;
    }

    public void setSunset(Date sunset) {
        this.sunset = sunset;
    }
}
