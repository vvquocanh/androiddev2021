package vn.edu.usth.weather.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
                final Handler handler = new Handler(Looper.getMainLooper()) {
                    public void handleMessage(Message msg) {
                        String content = msg.getData().getString("server_respond");
                        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
                    }
                };

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Bundle bundle = new Bundle();
                        bundle.putString("server_respond", "json file");

                        Message msg = new Message();
                        msg.setData(bundle);
                        handler.sendMessage(msg);
                    }
                });

                t.start();
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