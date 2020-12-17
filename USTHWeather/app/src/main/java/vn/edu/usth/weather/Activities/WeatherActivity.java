package vn.edu.usth.weather.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

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

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh: {
                recreate();
                return true;
            }
            case R.id.start_prefActivity: {
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            }
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }
}