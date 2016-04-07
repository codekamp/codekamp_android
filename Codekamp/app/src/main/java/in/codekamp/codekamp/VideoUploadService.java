package in.codekamp.codekamp;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by cerebro on 03/04/16.
 */
public class VideoUploadService extends IntentService {


    private static final String SERVICE_THREAD = "video_upload_service_thread";
    private static final String VIDEO_URI = "video_uri";

    public VideoUploadService() {
        super(SERVICE_THREAD);
    }

    public static Intent newIntent(Context context, String videoUri) {
        Intent intent = new Intent(context, VideoUploadService.class);
        intent.putExtra(VIDEO_URI, videoUri);

        return intent;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String videoUri = intent.getStringExtra(VIDEO_URI);

        for (int i = 0; i < 100; i++) {
            Log.d("codekamp", i + "% uploaded: " + videoUri);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }


}
