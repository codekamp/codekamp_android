package in.codekamp.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, GestureDetector.OnGestureListener {

    View redBox;
    TextView textView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBox = findViewById(R.id.red_box);
        textView = (TextView)findViewById(R.id.text_view);

        redBox.setOnTouchListener(this);
        detector = new GestureDetector(this, this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
//        Toast toast1 = Toast.makeText(this, "Down detected", Toast.LENGTH_SHORT);
//        toast1.show();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
//        Toast toast1 = Toast.makeText(this, "Show detected", Toast.LENGTH_SHORT);
//        toast1.show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
//        Toast toast1 = Toast.makeText(this, "single tap detected", Toast.LENGTH_SHORT);
//        toast1.show();
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        Toast toast1 = Toast.makeText(this, "Scroll detected", Toast.LENGTH_SHORT);
//        toast1.show();
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast toast1 = Toast.makeText(this, "long press detected", Toast.LENGTH_SHORT);
        toast1.show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Toast toast1 = Toast.makeText(this, "Fling detected", Toast.LENGTH_SHORT);
        toast1.show();
        return true;
    }
}
