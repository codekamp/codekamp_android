package in.codekamp.fragmentdemocodekamp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements TopNavBar.TopNavBarListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        BlankFragment fragment = BlankFragment.newInstance("", "");

        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.root_view_group, fragment, "the_tag");
        transaction.commit();
    }

    @Override
    public void tabSelected(int index) {
        Log.d("codekamp", "tab selected: " + index);
    }
}
