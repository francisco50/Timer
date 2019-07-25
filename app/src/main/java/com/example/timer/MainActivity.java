package com.example.timer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    public void onJustRun(View view)
    {
        Intent intent = new Intent(this, RunDetailsActivity.class);
        startActivity(intent);
    }

    public void onFiveK(View view)
    {
        Intent intent = new Intent(this, RunDetailsActivity.class);
        startActivity(intent);
    }

    public void onTenK(View view)
    {
        Intent intent = new Intent(this, RunDetailsActivity.class);
        startActivity(intent);
    }
            
}
