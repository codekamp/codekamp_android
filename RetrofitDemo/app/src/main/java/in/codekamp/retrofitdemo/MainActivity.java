package in.codekamp.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.invidz.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VaetasApiInterface apiInterface = retrofit.create(VaetasApiInterface.class);

        Call<LoginResponse> abcd = apiInterface.login("101.prashant@gmail.com", "pripra");

        abcd.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                loginResponse.getLoginToken();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

        String logingToken = "login token from shared prefs";
        apiInterface.getProjectList("bearer " + logingToken);


//        auth/login
//        projects

    }
}