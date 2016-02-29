package in.codekamp.myweatherapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cerebro on 27/02/16.
 */
public class MailchimpListLoader extends AsyncTask<String, Void, MailchimpList[]> {

    private static final String API_URL = "https://us12.api.mailchimp.com/2.0/lists/list";

    @Override
    protected MailchimpList[] doInBackground(String... params) {



        String apiKey = params[0];

        try {
            String urlString = API_URL + "?apikey=" + apiKey;
            URL url = new URL(urlString);

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

            JSONObject response = new JSONObject(totalResponse);

            JSONArray lists = response.getJSONArray("data");

            MailchimpList[] mailchimpLists = new MailchimpList[lists.length()];
            for(int i = 0; i < lists.length(); i++) {
                JSONObject list = (JSONObject)lists.get(i);

                mailchimpLists[i] = new MailchimpList(list);
            }

            return mailchimpLists;

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("codekamp", e.getMessage());
        }

        return new MailchimpList[0];
    }

    @Override
    protected void onPostExecute(MailchimpList[] mailchimpLists) {
        System.out.println(mailchimpLists[0].name);
        System.out.println(mailchimpLists[1].name);
    }
}
