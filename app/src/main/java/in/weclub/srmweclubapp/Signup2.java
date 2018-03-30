package in.weclub.srmweclubapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


public class Signup2 extends Fragment {

    private EditText pass, conpass;
    public static String[] info;
    private Button prev, reg, upldImg;
    private boolean uploaded;
    private Bitmap tPhoto;
    private String path = Environment.getExternalStorageDirectory().getAbsolutePath();

    public Signup2()
    {
        info = new String[4];
        uploaded = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signup2, container, false);
        pass = (EditText) v.findViewById(R.id.pass);
        conpass = (EditText) v.findViewById(R.id.conpass);
        prev = (Button) v.findViewById(R.id.prevSignUp);
        reg = (Button) v.findViewById(R.id.reg);
        upldImg = (Button) v.findViewById(R.id.upldImg);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = new Signup1();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.loginFragment, f);
                ft.commit();
            }
        });
        upldImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 1);
                saveImg(tPhoto);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pass.getText().toString().equals(conpass.getText().toString()) && uploaded) {
                    String str[] = new String[6];
                    char[] c = new char[10];
                    info[1].getChars(0, 2, c, 0);
                    info[2].getChars(0, 2, c, 3);
                    StringBuilder b = new StringBuilder(new String(c));
                    int i = Calendar.getInstance().get(Calendar.YEAR);
                    b.append(i);
                    str[0] = b.toString().toUpperCase();
                    str[1] = pass.getText().toString();
                    //UniqueID (First name (3 char), Last Name(3 char), currentYear)
                    //Ex: APATRI2018 (APAn TRIkha 2018)
                    for (int x = info.length-1; i > 0; i--)
                        str[x + 2] = info[x];
                    File f = new File(path + "/SRMWEClub/data.dat");
                    Save(f,str);
                    Intent it = new Intent(getContext(), Profile.class);
                    startActivity(it);
                } else if(!uploaded)
                    Toast.makeText(getActivity(), "Image not uploaded.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getActivity(), "Passwords are different", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    public static void saveImg(Bitmap bmp)
    {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + "/SRMWEClub/Profile.png");
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void Save(File file, String[] data) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                for (int i = 0; i < data.length; i++) {
                    fos.write(data[i].getBytes());
                    if (i < data.length - 1) {
                        fos.write("\n".getBytes());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContext().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) getView().findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            tPhoto = BitmapFactory.decodeFile(picturePath);
            uploaded = true;
        }
    }
}
