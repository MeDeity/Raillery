package com.deity.raillery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.deity.raillery.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeFragment.newInstance();
    }
}
