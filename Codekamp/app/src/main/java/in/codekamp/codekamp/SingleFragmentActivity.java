package in.codekamp.codekamp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by cerebro on 02/04/16.
 */
abstract public class SingleFragmentActivity extends CodeKampActivity {

    private final String SINGLE_FRAGMENT_TAG = "SINGLE_FRAGMENT";
    
    abstract Fragment getSingleFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);

        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.fragment_continer, getSingleFragment(), SINGLE_FRAGMENT_TAG);
    }
}
