package len.fidgetr;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton kaleidoscopeActivityButton;
    ImageButton spinnerActivityButton;
    ImageButton musicActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//    private void createButton(ImageButton button,String imageId, String navigation){
//        button = (ImageButton) findViewById(R.id.imageId);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v){
//                Intent intentLoadNewActivity = new Intent(MainActivity.this, navigation.class);
//                startActivity(intentLoadNewActivity);
//            }
//
//        });
//    }

        kaleidoscopeActivityButton = (ImageButton) findViewById(R.id.image_kaleidoscope);
        kaleidoscopeActivityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Kaleidoscope.class);
                startActivity(intentLoadNewActivity);
            }

        });

        spinnerActivityButton = (ImageButton) findViewById(R.id.image_spinner);
        spinnerActivityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intentLoadNewActivity = new Intent(MainActivity.this, SpinActivity.class);
                startActivity(intentLoadNewActivity);
            }

        });

        musicActivityButton = (ImageButton) findViewById(R.id.image_music);
        musicActivityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Music.class);
                startActivity(intentLoadNewActivity);
            }

        });
    }

    public void openSpin(View view) {
        Intent startNewActivity = new Intent(this, SpinActivity.class);
        startActivity(startNewActivity);
    }

    public void openMusic(View view) {
        Intent startNewActivity = new Intent(this, Music.class);
        startActivity(startNewActivity);
    }

    public void openKaleidoscope(View view) {
        Intent startNewActivity = new Intent(this, Kaleidoscope.class);
        startActivity(startNewActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void musicPage(View view)
    {
        Intent musicPage = new Intent(MainActivity.this, Music.class);
        startActivity(musicPage);
    }
}
