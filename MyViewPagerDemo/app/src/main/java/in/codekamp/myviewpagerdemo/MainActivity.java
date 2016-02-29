package in.codekamp.myviewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);

        WeatherPagerAdapter adapter = new WeatherPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);



    }

    public void onClick(View view) {
        pager.setCurrentItem(3);
    }

    private class WeatherPagerAdapter extends FragmentPagerAdapter {

        public WeatherPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentA();
                case 1:
                    return new FragmentB();
                case 2:
                    return new FragmentC();
                case 3:
                    return new MyFavoriteFragment();
                default:
                    return new FragmentB();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Top free";
                case 1:
                    return "Top paid";
                case 2:
                    return "Recently trending";
                case 3:
                    return "Delhi";
                default:
                    return "Mumbai";
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
