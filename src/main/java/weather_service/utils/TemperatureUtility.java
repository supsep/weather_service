package weather_service.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TemperatureUtility {
  public static double kelvinToCelsius(double tempInKelvin) {
    return tempInKelvin - 273.15F;
  }

  public static double kelvinToFahrenheit(double tempInKelvin) {
    return (((tempInKelvin - 273) * 9.0/5) + 32);
  }

  public static double roundToTwoPlaces(double value) {
    return (double) Math.round(value * 100) / 100;
  }
}
