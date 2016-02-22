package in.codekamp.myweatherapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by cerebro on 21/02/16.
 */
public class WeatherLoader extends AsyncTask<WeatherRequest, Void, WeatherResponse[]> {

    private final String API_URL = "http://api.openweathermap.org/data/2.5/forecast/daily";
    private final String APP_ID = "44db6a862fba0b067b1930da0d769e98";

    @Override
    protected WeatherResponse[] doInBackground(WeatherRequest... params) {

        WeatherRequest request = params[0];

        try {
            String urlString = API_URL + "?lat=" + request.latitude +"&lon=" + request.longitude +"&cnt=" + request.days + "&mode=json&appid="+APP_ID;
            URL url = new URL(urlString);
            Log.d("codekamp", urlString);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            InputStream stream = connection.getInputStream();

            BufferedReader r = new BufferedReader(new InputStreamReader(stream));
            String totalResponse = "";
            String line;
            while ((line = r.readLine()) != null) {
                totalResponse += line;
            }

            Log.d("codekamp", totalResponse);


            JSONObject jsonObject = new JSONObject(totalResponse);

            JSONArray weatherArray = jsonObject.getJSONArray("list");

            WeatherResponse[] responseArray = new WeatherResponse[weatherArray.length()];

            for(int i = 0; i < weatherArray.length(); i++) {
                WeatherResponse response = new WeatherResponse((JSONObject)weatherArray.get(i));

                responseArray[i] = response;
            }

            return responseArray;

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("codekamp", e.getMessage());
        }

        return new WeatherResponse[0];
    }

    @Override
    protected void onPostExecute(WeatherResponse[] weatherResponses) {

        Log.d("codekamp", "Day 1. temp: " + weatherResponses[0].minTemp + ", " + weatherResponses[0].maxTemp);
    }

    public interface WeatherResponseHandler {

    }
}
