package in.codekamp.myweatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherLoader loader = new WeatherLoader();
        loader.execute(new WeatherRequest( 28.6700, 77.4200, 2));
    }
}