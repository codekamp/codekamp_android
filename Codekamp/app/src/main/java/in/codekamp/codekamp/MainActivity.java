package in.codekamp.codekamp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends CodeKampActivity implements ServiceConnection {

    private AnotherVideoUploadService mUploadService;

    private static final int CONTACT_DETAIL_REQEUST = 1;
    private static final int CONTACT_CREATE_REQEUST = 2;
    private int i = 0;

    private EditText mVideoUrlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoUrlEditText = (EditText)findViewById(R.id.video_url);
    }

    public void onClick(View view) {

        Intent intent1 = SecondActivity.newIntent(this.getApplicationContext(), "hello");
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_HISTORY);

        TaskStackBuilder builder = TaskStackBuilder.create(this);

        builder.addParentStack(SecondActivity.class);
        builder.addNextIntent(intent1);

        PendingIntent intentForNotification = builder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);

        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setContentTitle("Video uploading");
        notificationBuilder.setContentText("This is description of notification");
        notificationBuilder.setContentIntent(intentForNotification);
//        notificationBuilder.setProgress(0, 0, true);

        NotificationCompat.BigTextStyle expandableStyle = new NotificationCompat.BigTextStyle();
        expandableStyle.bigText("This is the detail which will be hidded normally. You can add more txt here");

        notificationBuilder.setStyle(expandableStyle);

        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setPriority(Notification.PRIORITY_HIGH);


        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent intentForAction = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_ONE_SHOT);

        notificationBuilder.addAction(R.mipmap.ic_launcher, "Start Main", intentForAction);
        


        Notification notification = notificationBuilder.build();

//        notification.flags = Notification.FLAG_ONGOING_EVENT;
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);

//        for (int i =0; i < 100; i++) {
//            notificationBuilder.setProgress(100, i, false);
//            notification = notificationBuilder.build();
//            notification.flags = Notification.FLAG_ONGOING_EVENT;
//            notificationManager.notify(1, notification);
//
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        notificationBuilder.setProgress(0, 0, false);
//        notificationBuilder.setContentTitle("Video uploaded!");
//        notification = notificationBuilder.build();
//        notificationManager.notify(1, notification);

        // SingleTask
        // 1. can't open in two task stacks.
        // 2. has to be root activity of task stack.
        // 3. only one instance of activity is running at a time


        // SingleInstance
        // 1. can't open in two task stacks.
        // 2. has to be root activity of task stack.
        // 3. only one instance of activity is running at a time
        // 4. will be only activity in it's task stack.
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
