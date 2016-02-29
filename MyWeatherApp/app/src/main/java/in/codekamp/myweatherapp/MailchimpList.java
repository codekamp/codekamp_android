package in.codekamp.myweatherapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cerebro on 27/02/16.
 */
public class MailchimpList {
    public String id;
    public String name;

    public MailchimpList(JSONObject object) {

        try {
            this.id = object.getString("id");
            this.name = object.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
