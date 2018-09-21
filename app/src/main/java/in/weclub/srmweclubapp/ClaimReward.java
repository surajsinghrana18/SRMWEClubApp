package in.weclub.srmweclubapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class ClaimReward extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_claim_reward);

            ImageView qrCode = (ImageView)findViewById(R.id.imageView8);
            String id = getIntent().getStringExtra("UID");
            setTitle(getIntent().getStringExtra("Title"));
            MultiFormatWriter mfw = new MultiFormatWriter();
            try
            {
                BitMatrix bm = mfw.encode(id , BarcodeFormat.QR_CODE, 250, 250);
                BarcodeEncoder be = new BarcodeEncoder();
                Bitmap i = be.createBitmap(bm);
                qrCode.setImageBitmap(i);
            }
            catch (WriterException e)
            {
                e.printStackTrace();
            }
        }
}
