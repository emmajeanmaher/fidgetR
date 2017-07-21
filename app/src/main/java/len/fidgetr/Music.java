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
import android.graphics.Color;
import android.media.MediaPlayer;

public class Music extends AppCompatActivity {

    ImageButton birdSoundButton;
    ImageButton fireSoundButton;
    ImageButton forestSoundButton;
    ImageButton oceanSoundButton;
    ImageButton pianoSoundButton;
    ImageButton rainSoundButton;
    ImageButton windSoundButton;

    boolean birdToggle = false;
    boolean fireToggle = false;
    boolean forestToggle = false;
    boolean oceanToggle = false;
    boolean pianoToggle = false;
    boolean rainToggle = false;
    boolean windToggle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        final MediaPlayer birdButtonClick = MediaPlayer.create(this, R.raw.bird);
        final MediaPlayer fireButtonClick = MediaPlayer.create(this, R.raw.fire);
        final MediaPlayer forestButtonClick = MediaPlayer.create(this, R.raw.forest);
        final MediaPlayer oceanButtonClick = MediaPlayer.create(this, R.raw.ocean);
        final MediaPlayer pianoButtonClick = MediaPlayer.create(this, R.raw.piano);
        final MediaPlayer rainButtonClick = MediaPlayer.create(this, R.raw.rain);
        final MediaPlayer windButtonClick = MediaPlayer.create(this, R.raw.wind);

//        birdSoundButton = (ImageButton) findViewById(R.id.bird);
//        birdSoundButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v){
//                if(!birdToggle)
//                {
//                    birdToggle = true;
//                    birdButtonClick.setLooping(true);
//                    birdButtonClick.start();
//                    birdSoundButton.setColorFilter(Color.parseColor("#e6005c")); //white
//                }
//                else
//                {
//                    birdToggle = false;
//                    birdButtonClick.pause();
//                    birdSoundButton.setColorFilter(Color.parseColor("#000000")); //black
//                }
//            }
//        });

        fireSoundButton = (ImageButton) findViewById(R.id.fire);
        fireSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(!fireToggle)
                {
                    fireToggle = true;
                    fireButtonClick.setLooping(true);
                    fireButtonClick.start();
                    fireSoundButton.setColorFilter(Color.parseColor("#006600")); //white
                }
                else
                {
                    fireToggle = false;
                    fireButtonClick.pause();
                    fireSoundButton.setColorFilter(Color.parseColor("#000000")); //black
                }
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
                    forestSoundButton.setColorFilter(Color.parseColor("#006600")); //white
                }
                else
                {
                    forestToggle = false;
                    forestButtonClick.pause();
                    forestSoundButton.setColorFilter(Color.parseColor("#000000")); //black
                }
            }
        });

        oceanSoundButton = (ImageButton) findViewById(R.id.ocean);
        oceanSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(!oceanToggle)
                {
                    oceanToggle = true;
                    oceanButtonClick.setLooping(true);
                    oceanButtonClick.start();
                    oceanSoundButton.setColorFilter(Color.parseColor("#009999")); //white
                }
                else
                {
                    oceanToggle = false;
                    oceanButtonClick.pause();
                    oceanSoundButton.setColorFilter(Color.parseColor("#000000")); //black
                }
            }
        });

        pianoSoundButton = (ImageButton) findViewById(R.id.piano);
        pianoSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(!pianoToggle)
                {
                    pianoToggle = true;
                    pianoButtonClick.setLooping(true);
                    pianoButtonClick.start();
                    pianoSoundButton.setColorFilter(Color.parseColor("#ffffff")); //white
                }
                else
                {
                    pianoToggle = false;
                    pianoButtonClick.pause();
                    pianoSoundButton.setColorFilter(Color.parseColor("#000000")); //black
                }
            }
        });

        rainSoundButton = (ImageButton) findViewById(R.id.rain);
        rainSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(!rainToggle)
                {
                    rainToggle = true;
                    rainButtonClick.setLooping(true);
                    rainButtonClick.start();
                    rainSoundButton.setColorFilter(Color.parseColor("#002b80")); //white
                }
                else
                {
                    rainToggle = false;
                    rainButtonClick.pause();
                    rainSoundButton.setColorFilter(Color.parseColor("#000000")); //black
                }
            }
        });

        windSoundButton = (ImageButton) findViewById(R.id.wind);
        windSoundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(!windToggle)
                {
                    windToggle = true;
                    windButtonClick.setLooping(true);
                    windButtonClick.start();
                    windSoundButton.setColorFilter(Color.parseColor("#e6e600")); //white
                }
                else
                {
                    windToggle = false;
                    windButtonClick.pause();
                    windSoundButton.setColorFilter(Color.parseColor("#000000")); //black
                }
            }
        });
    }

}