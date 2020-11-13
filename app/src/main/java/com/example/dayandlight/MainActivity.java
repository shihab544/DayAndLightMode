package com.example.dayandlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class MainActivity extends AppCompatActivity {
    ImageView sun,DayLand,NightLand;
    View daySky,nightSky;
    DayNightSwitch dayNightSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sun = findViewById(R.id.sun);
        DayLand = findViewById(R.id.day_landscape);
        NightLand = findViewById(R.id.night_landscape);
        daySky = findViewById(R.id.day_bg);
        nightSky = findViewById(R.id.night_bg);
        dayNightSwitch = findViewById(R.id.day_night_switch);

        sun.setTranslationY(-110);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if(is_night){
                    sun.animate().translationY(110).setDuration(1000);
                    DayLand.animate().alpha(0).setDuration(1300);
                    daySky.animate().alpha(0).setDuration(1300);

                }
                else
                {
                    sun.animate().translationY(-110).setDuration(1000);
                    DayLand.animate().alpha(1).setDuration(1300);
                    daySky.animate().alpha(1).setDuration(1300);
                }
            }
        });
    }
}