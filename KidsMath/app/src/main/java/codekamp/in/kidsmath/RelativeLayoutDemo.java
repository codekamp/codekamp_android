package codekamp.in.kidsmath;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class RelativeLayoutDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout_demo);

        Intent i = getIntent();
        Log.d("codekamp", i.getStringExtra("my_data_key"));

        int rollNumber = i.getIntExtra("roll_number", 0);
        Log.d("codekamp", Integer.toString(rollNumber));
    }

    public void myFavoriteFunction(View view) {

        Intent i = new Intent();
        i.putExtra("college_name", "Stanford");
        setResult(Activity.RESULT_OK, i);
        this.finish();
    }
}
