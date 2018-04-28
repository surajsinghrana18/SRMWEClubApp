package in.weclub.srmweclubapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventDescription extends AppCompatActivity {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Event");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String s = getIntent().getExtras().getString("Event ID");
                DataSnapshot ds = dataSnapshot.child(s);
                String name = ds.child("Event Name").getValue(String.class);
                String spk = ds.child("Speaker").getValue(String.class);
                String date = ds.child("Date").getValue(String.class);
                String time = ds.child("Time").getValue(String.class);
                String venue = ds.child("Venue").getValue(String.class);

                TextView n = findViewById(R.id.eventName1);
                TextView det = findViewById(R.id.eventDet);
                //TextView des = findViewById(R.id.eventDesc);

                final String i = ds.getKey();

                n.setText(name);
                det.setText(String.format("Speaker: %s\nDate: %s\nTime: %s\nVenue: %s",spk,date,time,venue));

                b = (Button)findViewById(R.id.button2);
                b.setOnClickListener(new View.OnClickListener() {
                    final String f = i;
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder adb = new AlertDialog.Builder(EventDescription.this
                        ,R.style.AlertDialogTheme);
                        adb.setMessage(Html.fromHtml("<font color='#000000'>Do you want to register in this event?</font>"))
                                .setPositiveButton("YES",
                                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FirebaseUser u = FirebaseAuth.getInstance().getCurrentUser();
                                DatabaseReference ref1 = database.getReference("Users");
                                ref1.child(u.getUid()).child("Registered Events").child(f).setValue("Registered");
                                Toast.makeText(EventDescription.this, "Event Registration Successful", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("NO",
                                new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).create();
                        adb.setTitle(Html.fromHtml("<font color='#000000'>Confirm Registration</font>"));
                        adb.show();
                    }
                });
            }
        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
    }
}
