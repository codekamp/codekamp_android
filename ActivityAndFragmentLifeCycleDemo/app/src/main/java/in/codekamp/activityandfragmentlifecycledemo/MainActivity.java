package in.codekamp.activityandfragmentlifecycledemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IncreseDecrease.IncreaseDecraseListner {

    TextView selectedValue;

    private static final String INCREASE_DESCREASE_FRAGMENT = "increase_decrease_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedValue = (TextView)findViewById(R.id.selected_value);

        FragmentManager manager = getSupportFragmentManager();
        if (manager.findFragmentByTag(INCREASE_DESCREASE_FRAGMENT) == null) {
            IncreseDecrease fragment1 = IncreseDecrease.newInstance(40);

            FragmentTransaction transaction = manager.beginTransaction();

            transaction.add(R.id.top_panel, fragment1, INCREASE_DESCREASE_FRAGMENT);
            transaction.commit();
        }

    }


    @Override
    public void selectedValue(int value, String tag) {
        selectedValue.setText(Integer.toString(value));
    }
}
