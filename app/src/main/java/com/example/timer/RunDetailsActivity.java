package com.example.timer;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;


public class RunDetailsActivity extends Activity

{
    private boolean running;
    private boolean wasrunning;
    private int seconds = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_details);
        if(savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasrunning = savedInstanceState.getBoolean("wasrunning");
        }
        runTimer();

    }
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasrunning", wasrunning);
    }

    protected void onPause()
    {
        super.onPause();
        wasrunning = running;
        running = false;
    }

    protected void onResume()
    {
        super.onResume();
        if(wasrunning)
        {
            running = true;
        }
    }


    public void onGoButton(View view)
    {
        running = true;

    }
    public void onStopButton(View view)
    {
        running = false;

    }

    public void runTimer()
    {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable()
        {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time =String.format(Locale.getDefault(),"%d:%02d:%02d:",hours,minutes,secs);
                timeView.setText(time);
                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }



}