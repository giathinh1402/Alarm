package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextView plainText;
    TextView textView;

    public void select(View view){
        plainText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        //function for run time
        try{
            int time = Integer.parseInt(plainText.getText().toString());

            final int second = (time * 1000) + 100;

            new CountDownTimer(second,1000){
            @Override
            public void onTick(long untilFinished) {
                textView.setText("" +String.valueOf(untilFinished/1000));
            }

            @Override
            public void onFinish() {
                textView.setText("Alarm");
            }
            }.start();
        }catch (NumberFormatException e){
            Toast.makeText(this,"Enter Number Interger",Toast.LENGTH_LONG).show();
        }


    }
    public void stop(View view){
        mediaPlayer.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
