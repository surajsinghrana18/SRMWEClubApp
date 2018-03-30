package in.weclub.srmweclubapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;


public class LoginFragment extends Fragment {

    private EditText mono, pass;
    private Button login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_login, container, false);
        mono = (EditText) v.findViewById(R.id.moNo);
        pass = (EditText) v.findViewById(R.id.pass3);
        login = (Button)v.findViewById(R.id.button);
        TextView signup = (TextView)v.findViewById(R.id.signUp);
       /* signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = new Signup1();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.loginFragment, f);
                ft.commit();
            }
        });*/

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/SRMWEClub/data.dat");
                String s[] = LoginActivity.Load(f);
                if(s[2].equals(mono.getText().toString())&&s[1].equals(pass.getText().toString())) {
                    Intent it = new Intent(getActivity(), Profile.class);
                    startActivity(it);
                    Toast.makeText(getActivity(), "Logging In", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
