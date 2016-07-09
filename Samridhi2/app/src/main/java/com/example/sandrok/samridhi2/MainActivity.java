package com.example.sandrok.samridhi2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, EnterDetailsActivity.class);

    }

    public void mainstream(View view) {
        intent.putExtra("Bridge", 0);
        startActivity(intent);
    }

    public void bridgeschool(View view) {
        intent.putExtra("Bridge", 1);
        startActivity(intent);
    }
}
