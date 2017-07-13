package len.fidgetr;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SpinActivity extends AppCompatActivity implements SensorEventListener{

    //variables for spin
    public static final Random RANDOM = new Random();
    private View main;
    private ImageView spinner;
    private int lastAngle = -1;

    //variables for accelerometer
    Sensor accelerometer;
    SensorManager sm;
    TextView acceleration;

    //variable for background color change
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin2);

        //change title
        setTitle("Spinner");

        //background color
        main=this.getWindow().getDecorView();
        main.setBackgroundResource(R.color.green);

        //setting up spinning
        main = findViewById(R.id.Mainspinner);
        spinner = (ImageView) findViewById(R.id.spinner);

        main.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                spin();
            }
        });

        //setting up accelerometer
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);

        acceleration=(TextView)findViewById(R.id.acceleration);
    }

    private void spin(){
        //change background color
        int color = mColorWheel.getColor();
        main.setBackgroundColor(color);

        //spins picture
        int angle = RANDOM.nextInt(3600 - 360) + 360;
        float pivotX = spinner.getWidth()/2;
        float pivotY = spinner.getHeight()/2;

        final Animation rotateAnimation = new RotateAnimation(lastAngle == -1 ? 0 : lastAngle, angle, pivotX, pivotY );
        lastAngle = angle;
        rotateAnimation.setDuration(2500);
        rotateAnimation.setFillAfter(true);

        spinner.startAnimation(rotateAnimation);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //set up so we can implement SensorEventListener
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        acceleration.setText("X: " +event.values[0]+
                "\nY: "+event.values[1]+
                "\nZ: "+event.values[2]);
    }
}
