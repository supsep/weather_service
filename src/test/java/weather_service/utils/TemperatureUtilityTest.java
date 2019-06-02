package weather_service.utils;

import org.junit.Assert;
import org.junit.Test;

public class TemperatureUtilityTest {
  private static final float DELTA = .0001f;
  
  @Test
  public void testKelvinToCelsius() {
    Assert.assertEquals(100, TemperatureUtility.kelvinToCelsius(373.15F), DELTA);
    Assert.assertEquals(110, TemperatureUtility.kelvinToCelsius(383.15F), DELTA);
    Assert.assertEquals(-33.15, TemperatureUtility.kelvinToCelsius(240F), DELTA);
    Assert.assertEquals(-283.15, TemperatureUtility.kelvinToCelsius(-10F), DELTA);
    Assert.assertEquals(-273.15, TemperatureUtility.kelvinToCelsius(0F), DELTA);
  }

  @Test
  public void testKelvinToFahrenheit() {
    Assert.assertEquals(212, TemperatureUtility.kelvinToFahrenheit(373.15F), DELTA);
    Assert.assertEquals(230, TemperatureUtility.kelvinToFahrenheit(383.15F), DELTA);
    Assert.assertEquals(-27.67, TemperatureUtility.kelvinToFahrenheit(240F), DELTA);
    Assert.assertEquals(-477.67, TemperatureUtility.kelvinToFahrenheit(-10F), DELTA);
    Assert.assertEquals(-459.67, TemperatureUtility.kelvinToFahrenheit(0F), DELTA);
  }

  @Test
  public void testRoundToDecimalPlaces() {
    Assert.assertEquals(0, TemperatureUtility.roundToTwoPlaces(0F), DELTA);
    Assert.assertEquals(373.15, TemperatureUtility.roundToTwoPlaces(373.15F), DELTA);
    Assert.assertEquals(383.12, TemperatureUtility.roundToTwoPlaces(383.123135F), DELTA);
    Assert.assertEquals(383.79, TemperatureUtility.roundToTwoPlaces(383.79279123135F), DELTA);
  }
}