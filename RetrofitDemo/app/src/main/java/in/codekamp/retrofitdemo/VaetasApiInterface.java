package in.codekamp.retrofitdemo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by cerebro on 05/11/16.
 */

public interface VaetasApiInterface {

    @GET("auth/login")
    public Call<LoginResponse> login(@Query("email") String emailAddress, @Query("password") String password);

//    // projects/25/type/marketing
//    @GET("projects/{prashant}/type/{type}")
//    public Call<Void> getProjectDetail(@Path("type") String projectType, @Path("prashant") int abcd);
//
//    // projects?my_project_id=25&project_type=marketing
//    @GET("projects")
//    public Call<Void> getProjectDetail(@Query("my_project_id") int abcd, @Query("project_type") String type);
//
//    @POST("users/register")
//    public Call<Void> signUp(@Field("name") String fullName, String email);

    // projects/25
    @GET("projects/{project_id}")
    public Call<Project> getProjectDetail(@Header("Authorization") String authHeader, @Path("project_id") int projectId);

    @GET("projects")
    public Call<ProjectListResponse> getProjectList(@Header("Authorization") String authHeader);


}
