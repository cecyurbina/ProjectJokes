package com.example.surbi.androidlibraryjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityJoke extends AppCompatActivity {
    public static final String KEY_JOKE = "KEY_JOKE";
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        message = intent.getStringExtra(KEY_JOKE);

        TextView textView = findViewById(R.id.tv_joke);
        textView.setText(message);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_JOKE, message);
        super.onSaveInstanceState(outState);
    }
}
