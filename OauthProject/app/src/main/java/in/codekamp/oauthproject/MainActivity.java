package in.codekamp.oauthproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.util.Lists;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void connectTwitter(View view) {

        TwitterLoader loader = new TwitterLoader();
        loader.execute();
    }

    public class TwitterLoader extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            ClientParametersAuthentication keys = new ClientParametersAuthentication(TwitterConstants.CONSUMER_KEY,
                    TwitterConstants.CONSUMER_SECRET);

            OAuth oauth = OAuth.newInstance(
                    getApplicationContext(),
                    getSupportFragmentManager(),
                    keys,
                    TwitterConstants.AUTHORIZATION_VERIFIER_SERVER_URL,
                    TwitterConstants.TOKEN_SERVER_URL,
                    TwitterConstants.REDIRECT_URL,
                    Lists.<String> newArrayList(),
                    TwitterConstants.TEMPORARY_TOKEN_REQUEST_URL);

            try {
                Credential credentials = oauth.authorize10a("All in one!").getResult();
                Log.d("codekamp", credentials.getAccessToken());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
