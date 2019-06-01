package weather_service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReport implements Serializable {
    private Location location;
    private Weather weather;
    private long timestamp;

    public WeatherReport() {
        this.location = new Location();
        this.weather = new Weather();
    }

    @JsonProperty("timestamp")
    public long getTimestamp() {
        return this.timestamp;
    }

    @JsonSetter("name")
    public void setCity(String name) {
        getLocation().setName(name);
    }

    @JsonSetter("coord")
    public void setCoord(Map<String, Double> coord) {
        getLocation().setLon(coord.get("lon"));
        getLocation().setLat(coord.get("lat"));
    }

    @JsonSetter("id")
    public void setCityId(String id) {
        getLocation().setId(id);
    }

    @JsonSetter("dt")
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonSetter("weather")
    public void setWeather(List<Object> weather) {
        HashMap<String, String> weatherMap = (HashMap<String, String>) weather.get(0);
        getWeather().setStatus(weatherMap.get("main"));
        getWeather().setStatusDescription(weatherMap.get("description"));
        getWeather().setIcon(weatherMap.get("icon"));
    }

    @JsonSetter("visibility")
    public void setVisibility(long visibility) {
        getWeather().setVisibility(visibility);
    }

    @JsonSetter("main")
    public void setMain(Map<String, Object> main) {
        getWeather().setTemp((double) main.get("temp"));
        getWeather().setMinTemp((double) main.get("temp_min"));
        getWeather().setMaxTemp((double) main.get("temp_max"));
        getWeather().setPressure((int) main.get("pressure"));
        getWeather().setHumidity((int) main.get("humidity"));
    }

    @JsonSetter("_wind")
    public void setWind(Map<String, Object> wind) {
        getWeather().setWindSpeed((double) wind.get("speed"));
        getWeather().setWindDegrees((int) wind.get("deg"));
    }

    @JsonSetter("sys")
    public void setSys(Map<String, Object> sys) {
        getLocation().setCountry((String) sys.get("country"));
        getWeather().setSunrise((int)sys.get("sunrise"));
        getWeather().setSunset((int)sys.get("sunset"));
    }
}
