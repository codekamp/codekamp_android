package in.codekamp.retrofitdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cerebro on 05/11/16.
 */

public class User {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email_verified")
    @Expose
    private boolean isEmailVerified;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }
}
