package len.fidgetr;

        import android.app.Activity;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.Canvas;
        import android.graphics.Matrix;
        import android.provider.MediaStore;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import java.io.File;
        import java.util.Random;
/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Kaleidoscope extends AppCompatActivity {
    Button button;
    Button Kal;
    ImageView ImageView;
    Bitmap photo;
    static final int CamReq = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaleidoscope);
        button = (Button) findViewById(R.id.Capture);
        Kal = (Button) findViewById(R.id.Kaleidoscope);
        ImageView = (ImageView) findViewById(R.id.TextureView);
        Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        photo = Bitmap.createBitmap(100, 100, conf);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();//not currently used to save photos, regular photo sent to your photos
                //camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent,CamReq);
            }



        });
        Kal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap croped = KalT(photo);//KalT change the size of the photo bitmap.
                Bitmap scaled = Kaleidoscopefinal(croped);//sends the bitmap created by croped and creates the Kaleidoscope.
                Random random = new Random();
                int randy= random.nextInt(3);
                for(int count=0; count < randy; count++) {//
                    scaled = Kaleidoscopefinal(scaled);
                }
                scaled = Kaleidoscopefinal(scaled);
                ImageView.setImageBitmap(scaled);
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
        //ImageView.setSurfaceTexture(SurfaceTexture.createFromPath(pathway));
        if (requestCode == CamReq && resultCode == Activity.RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            ImageView.setImageBitmap(photo);//save image capture from camera and puts it in

        }

    }
    protected Bitmap Kalf(int pos1,int pos,Bitmap lil) {
         Bitmap bmap = lil.copy(lil.getConfig(), true);
        Matrix m = new Matrix();
        m.preScale(pos, pos1);
        Bitmap invert = Bitmap.createBitmap(bmap, 0, 0, bmap.getWidth(), bmap.getHeight(), m, false);

      return invert;
    }
    protected Bitmap Kalc (Bitmap one,Bitmap two, int rotate) {
        Bitmap ot =null;
        int hei, wid = 0;
        if (rotate == 1) {
        wid = one.getHeight() + two.getHeight();
            hei = one.getWidth();
        }
        else{
            wid = one.getWidth() + two.getWidth();
            hei = one.getHeight();
        }
        ot = Bitmap.createBitmap(wid, hei, Bitmap.Config.ARGB_8888);
        Canvas otc = new Canvas(ot);
        if(rotate == 1) {
            otc.drawBitmap(two, 0f, 0f, null);
            otc.drawBitmap(one, 0f, one.getHeight(), null);
            otc.rotate(90);
        }
        else{
            otc.drawBitmap(one, 0f, 0f, null);
            otc.drawBitmap(two, one.getWidth(), 0f, null);
        }

        return ot;
    }
    protected Bitmap KalT (Bitmap bmapc) {
        Bitmap cropping = Bitmap.createBitmap(
                bmapc,
                0,
                bmapc.getHeight()/2 - bmapc.getWidth()/2,
                bmapc.getWidth(),
                bmapc.getWidth()
        );
        Bitmap scaled = Bitmap.createScaledBitmap(cropping, 150, 150, true);
        return scaled;
    }
    protected Bitmap Kaleidoscopefinal (Bitmap finalle){
        Bitmap bmaptemp = Kalf(1,-1,finalle);
        Bitmap bmapc = Kalc(finalle, bmaptemp,0);
        Bitmap bmaptemp1 = Kalf(-1,-1,bmapc);
        Bitmap bmapc1 = Kalc(bmapc,bmaptemp1,1);
        Bitmap scaled = Bitmap.createScaledBitmap(bmapc1, 150, 150, true);
        return scaled;
    }
}