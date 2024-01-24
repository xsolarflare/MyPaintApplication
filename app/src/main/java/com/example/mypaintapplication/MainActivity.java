package com.example.mypaintapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.mypaintapplication.databinding.ActivityMainBinding;
import com.example.mypaintapplication.view.MyView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.myDraw.setPaint(Color.BLUE);
            }
        });

        binding.btnF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.myDraw.setPaint(Color.RED);
            }
        });

        binding.btnF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.myDraw.setPaint(Color.GREEN);
            }
        });

    }

}