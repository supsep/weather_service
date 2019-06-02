package weather_service.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TemperatureUtility {

  /**
   * Convert float representing kelvin temperature to Celsius.
   * @param tempInKelvin Temperature in Kelvin.
   * @return float Temperature in Celsius.
   */
  public static float kelvinToCelsius(float tempInKelvin) {
    float tempInCelsius = tempInKelvin - 273.15F;
    return roundToTwoPlaces(tempInCelsius);
  }
  /**
   * Convert float representing kelvin temperature to Fahrenheit.
   * @param tempInKelvin Temperature in Kelvin.
   * @return float Temperature in Fahrenheit.
   */
  public static float kelvinToFahrenheit(float tempInKelvin) {
    float tempInFahrenheit = tempInKelvin * 1.8F - 459.67F;
    return roundToTwoPlaces(tempInFahrenheit);
  }

  /**
   * Round float value to two decimal places.
   * @param value float
   * @return float rounded to two decimal places.
   */
  public static float roundToTwoPlaces(float value) {
    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(2, RoundingMode.HALF_UP);
    return bd.floatValue();
  }
}
