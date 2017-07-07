package len.fidgetr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class SpinActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private View main;
    private ImageView spinner;
    private int lastAngle = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin2);
        setTitle("Spinner");
        main = findViewById(R.id.Mainspinner);
        spinner = (ImageView) findViewById(R.id.spinner);

        main.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                spin();
            }
        });
    }
    private void spin(){
        int angle = RANDOM.nextInt(3600 - 360) + 360;
        float pivotX = spinner.getWidth()/2;
        float pivotY = spinner.getHeight()/2;

        final Animation rotateAnimation = new RotateAnimation(lastAngle == -1 ? 0 : lastAngle, angle, pivotX, pivotY );
        lastAngle = angle;
        rotateAnimation.setDuration(2500);
        rotateAnimation.setFillAfter(true);

        spinner.startAnimation(rotateAnimation);
    }
}
