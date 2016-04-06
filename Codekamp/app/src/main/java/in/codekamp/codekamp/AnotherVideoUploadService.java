package in.codekamp.codekamp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 06/04/16.
 */
public class AnotherVideoUploadService extends Service implements Runnable {

    private Thread thread = null;
    List<String> uriToBeUploaded = null;

    private static final String VIDEO_URI = "video_uri";

    public static Intent newIntent(Context context, String videoUri) {
        Intent intent = new Intent(context, VideoUploadService.class);
        intent.putExtra(VIDEO_URI, videoUri);

        return intent;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        if(uriToBeUploaded == null) {
            uriToBeUploaded = new ArrayList<String>();
        }

        uriToBeUploaded.add(intent.getStringExtra(VIDEO_URI));

        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void run() {
        while (!uriToBeUploaded.isEmpty()) {
            String uri = uriToBeUploaded.remove(0);

            //code for uploading
        }

        stopSelf();
    }

    public int getProgress() {
        return 10;
    }

    public class ServiceBinder extends Binder {
        public AnotherVideoUploadService getService() {
            return AnotherVideoUploadService.this;
        }
    }
}
