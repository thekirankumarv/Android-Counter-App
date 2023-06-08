package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewObj;
    Button startBtn, stopBtn;
    Handler handler = new Handler();
    int i = 0;
    private final Runnable myThread = new Runnable() {
        @Override
        public void run() {
            textViewObj.setText(" " +i);
            handler.postDelayed(this,1000);
            i++;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewObj = findViewById(R.id.textView);
        startBtn = findViewById(R.id.button);
        stopBtn = findViewById(R.id.button1);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(myThread,0);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(myThread);
            }
        });
    }
}