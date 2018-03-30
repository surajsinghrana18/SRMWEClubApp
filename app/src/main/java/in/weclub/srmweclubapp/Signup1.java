package in.weclub.srmweclubapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Signup1 extends Fragment {

    private EditText fName, lName, email, mobNo;
    private Button next;
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signup1, container, false);
        next = (Button)v.findViewById(R.id.nextSignUp);
        fName = (EditText)v.findViewById(R.id.fName);
        lName = (EditText)v.findViewById(R.id.lName);
        email = (EditText)v.findViewById(R.id.email);
        mobNo = (EditText)v.findViewById(R.id.moNum);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((fName.getText().toString().equals(""))||(lName.getText().toString().equals(""))||
                        (email.getText().toString().equals(""))||(mobNo.getText().toString().equals("")))
                    Toast.makeText(getActivity(), "Fill all entries", Toast.LENGTH_SHORT).show();
                else {
                    Fragment f = new Signup2();
                    Signup2.info[0] = mobNo.getText().toString();
                    Signup2.info[1] = fName.getText().toString();
                    Signup2.info[2] = lName.getText().toString();
                    Signup2.info[3] = email.getText().toString();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.loginFragment, f);
                    ft.commit();
                }
            }
        });
        return v;
        }

}
