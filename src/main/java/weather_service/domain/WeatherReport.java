package weather_service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
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

    @JsonSetter("dt")
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("weather")
    public void setWeather(Map<String, Object> weather) {
        getWeather().setStatus((String) weather.get("main"));
        getWeather().setStatusDescription((String) weather.get("description"));
        getWeather().setIcon((String) weather.get("icon"));
    }

    @JsonSetter("visibility")
    public void setVisibility(long visibility) {
        getWeather().setVisibility(visibility);
    }


    @JsonProperty("main")
    public void setMain(Map<String, Object> main) {
        getWeather().setTemp((double) main.get("temp"));
        getWeather().setMinTemp((double) main.get("temp_min"));
        getWeather().setMaxTemp((double) main.get("temp_max"));
        getWeather().setPressure((long) main.get("pressure"));
        getWeather().setHumidity((int) main.get("humidity"));
    }

    @JsonProperty("sys")
    public void setSys(Map<String, Object> sys) {
        getLocation().setCountry((String) sys.get("country"));
        getWeather().setSunrise((int)sys.get("sunrise"));
        getWeather().setSunrise((int)sys.get("sunset"));
    }
}
