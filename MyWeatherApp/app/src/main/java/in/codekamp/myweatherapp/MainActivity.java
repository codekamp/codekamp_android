package in.codekamp.myweatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        WeatherLoader loader = new WeatherLoader();
//        loader.execute(new WeatherRequest( 28.6700, 77.4200, 2));
//



        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        String apiKey = preferences.getString("API_KEY", null);

        if(apiKey != null) {
            MailchimpListLoader loader = new MailchimpListLoader();
            loader.execute(apiKey);
        } else {
            //show another activity which has form
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("API_KEY", "73deb460b9368706ef8e28f7ec098200-us12");
        editor.commit();

    }
}