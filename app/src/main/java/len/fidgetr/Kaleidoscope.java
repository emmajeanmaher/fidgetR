package len.fidgetr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Kaleidoscope extends AppCompatActivity {
    Button button;
    ImageView imageView;
    static final int CamReq = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaleidoscope);
        button = (Button) findViewById(R.id.Button);
        imageView = (ImageView) findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent,CamReq);
            }

        });
    }
        private File getFile() {
            File folder = new File("sdcard/camera_app");
            if(!folder.exists())
            {
                folder.mkdir();
            }
            File image_file = new File(folder, "capture.jpg");
                    return image_file;
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String pathway = "sdcard/camera_app/capture.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(pathway));
    }
}