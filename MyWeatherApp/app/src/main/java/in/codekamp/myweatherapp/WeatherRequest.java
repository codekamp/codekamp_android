package in.codekamp.myweatherapp;

/**
 * Created by cerebro on 21/02/16.
 */
public class WeatherRequest {

    public double latitude;
    public double longitude;
    public int days;

    public WeatherRequest(double latitude, double longitude, int days) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.days = days;
    }
}
