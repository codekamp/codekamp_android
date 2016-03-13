package in.codekamp.myapplication;

import android.os.AsyncTask;

import java.util.List;

/**
 * Created by cerebro on 16/02/16.
 */
public class MyBackgroundWorker extends AsyncTask<String, String, List> {


    @Override
    protected List doInBackground(String... params) {

        //code to download student info

        //code to convert downloaded data (XML, JSON) to student objects
        return null;
    }

    @Override
    protected void onPostExecute(List list) {
        super.onPostExecute(list);
    }
}