package in.codekamp.myweatherapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cerebro on 21/02/16.
 */
public class WeatherResponse {
    public double maxTemp;
    public double minTemp;
    public double humidity;

    public WeatherResponse(JSONObject jsonObject) {

        try {
            minTemp = jsonObject.getJSONObject("temp").getDouble("min");
            maxTemp = jsonObject.getJSONObject("temp").getDouble("max");
            humidity = jsonObject.getDouble("humidity");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
