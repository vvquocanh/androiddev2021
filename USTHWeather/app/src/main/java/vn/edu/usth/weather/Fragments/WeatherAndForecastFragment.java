package vn.edu.usth.weather.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.weather.R;

public class WeatherAndForecastFragment extends Fragment {
    public WeatherAndForecastFragment() {
        // Required empty public constructor
    }

    public static WeatherAndForecastFragment newInstance() {
        Bundle args = new Bundle();
        WeatherAndForecastFragment fragment = new WeatherAndForecastFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);
    }
}