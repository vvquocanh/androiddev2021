package vn.edu.usth.weather.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
                AsyncTask<URL, Integer, Bitmap> task = new AsyncTask<URL, Integer, Bitmap>() {
                    @Override
                    protected Bitmap doInBackground(URL... url) {
                        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                        Response.Listener<Bitmap> listener = new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {
                                ImageView iv = (ImageView) findViewById(R.id.weather_image);
                                iv.setImageBitmap(response);
                            }
                        };

                        ImageRequest imageRequest = new ImageRequest(
                               "https://usth.edu.vn/uploads/logo_moi-eng.png",
                                listener, 0, 0, ImageView.ScaleType.CENTER,
                                Bitmap.Config.ARGB_8888,null);

                        queue.add(imageRequest);

                       /* Bitmap bitmap = null;
                        try {
                            URL usthURL = new URL("https://usth.edu.vn/uploads/logo_moi-eng.png");
                            HttpURLConnection connection = (HttpURLConnection) usthURL.openConnection();
                            connection.setRequestMethod("GET");
                            connection.setDoInput(true);
                            connection.connect();

                            int response = connection.getResponseCode();
                            Log.i("USTHWeather","The response is: " + response);
                            InputStream inputStream = connection.getInputStream();

                            bitmap = BitmapFactory.decodeStream(inputStream);
                            connection.disconnect();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return bitmap;*/
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        ImageView logo = (ImageView) findViewById(R.id.weather_image);
                        logo.setImageBitmap(bitmap);
                    }

                };
                task.execute();
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