package in.weclub.srmweclubapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Partners extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partners);

        TextView t1 = (TextView)findViewById(R.id.tv1);
        TextView t2 = (TextView)findViewById(R.id.tv2);
        TextView t3 = (TextView)findViewById(R.id.tv3);
        TextView t4 = (TextView)findViewById(R.id.tv4);
        TextView t5 = (TextView)findViewById(R.id.tv5);
        TextView t6 = (TextView)findViewById(R.id.tv6);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Partners.this, FindPartner.class);
                startActivity(it);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Partners.this, FindPartner.class);
                startActivity(it);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Partners.this, FindPartner.class);
                startActivity(it);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Partners.this, FindPartner.class);
                startActivity(it);
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Partners.this, FindPartner.class);
                startActivity(it);
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Partners.this, FindPartner.class);
                startActivity(it);
            }
        });
    }
}
