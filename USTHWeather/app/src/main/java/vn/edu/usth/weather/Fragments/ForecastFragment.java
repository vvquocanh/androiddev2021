package vn.edu.usth.weather.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import vn.edu.usth.weather.R;
public class ForecastFragment extends Fragment {
    public ForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor("#20FF0000"));

        TextView textView = new TextView(getContext());
        textView.setText("Thursday");

        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.cloud);

        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(textView);
        layout.addView(imageView);*/
        return inflater.inflate(R.layout.fragment_forecast, container, false);
    }
}