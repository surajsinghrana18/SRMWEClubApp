package in.weclub.srmweclubapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity1 extends AppCompatActivity {

    private EditText email, pass;
    private Button login;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser u = firebaseAuth.getCurrentUser();
        if(u!= null) {
            firebaseAuth.signOut();
        }
        login();
    }
    public void login() {
        email = (EditText) findViewById(R.id.moNo);
        pass = (EditText) findViewById(R.id.pass3);
        login = (Button) findViewById(R.id.button);
        TextView signup = (TextView) findViewById(R.id.signUp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* android.support.v4.app.Fragment f = new Signup1();
                FragmentManager fm = getFragmentManager();
                android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.loginFragment, f);
                ft.commit();*/
                Intent ot = new Intent(LoginActivity1.this, SignUpScroll.class);
                startActivity(ot);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity1.this, "Please wait...", "Processing...", true);
                (firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString()))
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();

                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity1.this, "Registration successful", Toast.LENGTH_LONG).show();
                                    //DataPosition.set_Email(email.getText().toString());
                                    Intent i = new Intent(LoginActivity1.this, Profile.class);
                                    startActivity(i);
                                } else {
                                    Log.e("ERROR", task.getException().toString());
                                    Toast.makeText(LoginActivity1.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }

    @Override
    protected void onDestroy() {
        firebaseAuth.signOut();
        super.onDestroy();
    }
}
