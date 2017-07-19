package len.fidgetr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.media.MediaPlayer;

public class Music extends AppCompatActivity {

    ImageButton birdSoundButton;
    ImageButton forestSoundButton;
    ImageButton oceanSoundButton;
    ImageButton pianoSoundButton;
    ImageButton rainSoundButton;
    ImageButton windSoundButton;

    boolean forestToggle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        final MediaPlayer birdButtonClick = MediaPlayer.create(this, R.raw.bird);
        final MediaPlayer forestButtonClick = MediaPlayer.create(this, R.raw.forest);
        final MediaPlayer oceanButtonClick = MediaPlayer.create(this, R.raw.ocean);
        final MediaPlayer pianoButtonClick = MediaPlayer.create(this, R.raw.piano);
        final MediaPlayer rainButtonClick = MediaPlayer.create(this, R.raw.rain);
        final MediaPlayer windButtonClick = MediaPlayer.create(this, R.raw.wind);




        birdSoundButton = (ImageButton) findViewById(R.id.bird);
        birdSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                birdButtonClick.start();
            }
        });

        forestSoundButton = (ImageButton) findViewById(R.id.forest);
        forestSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(!forestToggle)
                {
                    forestToggle = true;
                    forestButtonClick.setLooping(true);
                    forestButtonClick.start();
                }
                else
                {
                    forestToggle = false;
                    forestButtonClick.stop();
                }
            }
        });

        oceanSoundButton = (ImageButton) findViewById(R.id.ocean);
        oceanSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                oceanButtonClick.start();
            }
        });

        pianoSoundButton = (ImageButton) findViewById(R.id.piano);
        pianoSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                pianoButtonClick.start();
            }
        });

        rainSoundButton = (ImageButton) findViewById(R.id.rain);
        rainSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                rainButtonClick.start();
            }
        });

        windSoundButton = (ImageButton) findViewById(R.id.wind);
        windSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                windButtonClick.start();
            }
        });
    }

}