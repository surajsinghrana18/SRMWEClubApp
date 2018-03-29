package in.weclub.srmweclubapp;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Register extends AppCompatActivity {

    private EditText name,pass,conpass;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText)findViewById(R.id.name2);
        pass = (EditText)findViewById(R.id.pass2);
        conpass = (EditText)findViewById(R.id.conPass);
        conpass.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if((keyEvent.getAction() == KeyEvent.ACTION_DOWN)&&(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                {
                    create();
                    return true;
                }
                return false;
            }
        });
        b = (Button)findViewById(R.id.conReg);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create();
            }
        });
    }

    private void create()
    {
        if(pass.getText().toString().equals(conpass.getText().toString())) {
            File a = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/SRMWEClub");
            a.mkdir();
            File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/SRMWEClub/data.dat");
            String s[] = new String[2];
            s[0] = name.getText().toString();
            s[1] = pass.getText().toString();
            Save(f,s);
            Toast.makeText(Register.this, "Registering...", Toast.LENGTH_LONG).show();
            Intent it = new Intent(Register.this, LoginActivity.class);
            startActivity(it);
            Toast.makeText(Register.this, "Logging In", Toast.LENGTH_SHORT).show();
        }

    }
    public static void Save(File file, String[] data)
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try
        {
            try
            {
                for (int i = 0; i<data.length; i++)
                {
                    fos.write(data[i].getBytes());
                    if (i < data.length-1)
                    {
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }



}
