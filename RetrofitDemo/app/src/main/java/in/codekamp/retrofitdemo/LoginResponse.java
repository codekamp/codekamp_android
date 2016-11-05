package in.codekamp.retrofitdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cerebro on 05/11/16.
 */

public class LoginResponse {

    @SerializedName("token")
    @Expose
    private String loginToken;

    @SerializedName("user")
    @Expose
    private User user;

    public String getLoginToken() {
        return loginToken;
    }

    public User getUser() {
        return user;
    }
}
