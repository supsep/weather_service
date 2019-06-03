package weather_service.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TemperatureUtility {

  /**
   * Convert double representing kelvin temperature to Celsius.
   * @param tempInKelvin Temperature in Kelvin.
   * @return double Temperature in Celsius.
   */
  public static double kelvinToCelsius(double tempInKelvin) {
    double tempInCelsius = tempInKelvin - 273.15F;
    return roundToTwoPlaces(tempInCelsius);
  }
  /**
   * Convert double representing kelvin temperature to Fahrenheit.
   * @param tempInKelvin Temperature in Kelvin.
   * @return double Temperature in Fahrenheit.
   */
  public static double kelvinToFahrenheit(double tempInKelvin) {
    double tempInFahrenheit = tempInKelvin * 1.8F - 459.67F;
    return roundToTwoPlaces(tempInFahrenheit);
  }

  /**
   * Round double value to two decimal places.
   * @param value double
   * @return double rounded to two decimal places.
   */
  public static double roundToTwoPlaces(double value) {
    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(2, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }
}
