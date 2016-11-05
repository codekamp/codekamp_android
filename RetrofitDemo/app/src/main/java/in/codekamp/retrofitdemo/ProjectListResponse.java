package in.codekamp.retrofitdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cerebro on 05/11/16.
 */

public class ProjectListResponse {
    @SerializedName("data")
    @Expose
    private List<Project> projects;
}
