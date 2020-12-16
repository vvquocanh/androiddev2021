package vn.edu.usth.weather.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import vn.edu.usth.weather.Adapter.HomeFragmentPagerAdapter;
import vn.edu.usth.weather.Fragments.ForecastFragment;
import vn.edu.usth.weather.R;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        //ForecastFragment firstFragment = new ForecastFragment();
        //getSupportFragmentManager().beginTransaction().add(R.id.container, firstFragment).commit();

        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);
        Log.i(TAG, "Created");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "Started");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "Paused");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "Resumed");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "Stopped");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destroyed");
    }

}