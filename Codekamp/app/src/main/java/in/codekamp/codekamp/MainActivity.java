package in.codekamp.codekamp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends CodeKampActivity implements ServiceConnection {

    private AnotherVideoUploadService mUploadService;

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

        Intent intent = AnotherVideoUploadService.newIntent(this, mVideoUrlEditText.getText().toString());

        bindService(intent, this, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        AnotherVideoUploadService.ServiceBinder binder = (AnotherVideoUploadService.ServiceBinder)service;
        this.mUploadService = binder.getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        this.mUploadService = null;
    }
}
