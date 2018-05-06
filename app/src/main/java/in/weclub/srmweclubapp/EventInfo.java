package in.weclub.srmweclubapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

/**
 * Created by root on 1/4/18.
 */

public class EventInfo {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabase;
    private String eventName, speaker, time, venue, evID, date;

    public EventInfo(String name, String spkr, String date, String time, String ven, String ID) {
        eventName = name;
        speaker = spkr;
        this.time = time;
        venue = ven;
        evID = ID;
        this.date = date;
    }


    protected void OnCreate(Bundle savedInstancesState) {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Event");
    }

    public String getName() {
        return eventName;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getTime() {
        return time;
    }

    public String getVenue() {
        return venue;
    }

    public String getEvID() {
        return evID;
    }

    public String getDate() {
        return date;
    }

    public void setInfo(String name, String spkr, String time, String ven, String ID) {
        eventName = name;
        speaker = spkr;
        this.time = time;
        venue = ven;
        evID = ID;
    }

    public void onStart() {
        ValueEventListener eListner = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataSnapshot.getValue(EventAdapter.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("loadPost:onCancelled", databaseError.toException());

            }
        };

    }
    ChildEventListener childEventListner = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                dataSnapshot.getValue(EventAdapter.class);
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            dataSnapshot.getValue(EventAdapter.class);
        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {
            dataSnapshot.getKey();
        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }

    };

}