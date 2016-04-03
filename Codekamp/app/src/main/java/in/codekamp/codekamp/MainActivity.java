package in.codekamp.codekamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends CodeKampActivity {

    private static final int CONTACT_DETAIL_REQEUST = 1;
    private static final int CONTACT_CREATE_REQEUST = 2;

    private EditText mVideoUrlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoUrlEditText = (EditText)findViewById(R.id.video_url);
    }

    public void onClick(View view) {

        Intent intent = VideoUploadService.newIntent(this, mVideoUrlEditText.getText().toString());

        startService(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
