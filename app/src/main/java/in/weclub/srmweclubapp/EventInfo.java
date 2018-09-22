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

    private String eventName, speaker, endTime, venue, evID, startTime, img;
    private boolean enrolled;

    public EventInfo(String name, String spkr, String st, String et, String ven, String img,
                     String ID, boolean en) {
        eventName = name;
        speaker = spkr;
        startTime = st;
        this.img = img;
        venue = ven;
        evID = ID;
        endTime = et;
        enrolled = en;
    }

    public EventInfo(String name, String spkr, String st, String et, String ven, String img,
                     String ID) {
        eventName = name;
        speaker = spkr;
        startTime = st;
        this.img = img;
        venue = ven;
        evID = ID;
        endTime = et;
    }

    public String getName() {
        return eventName;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getVenue() {
        return venue;
    }

    public String getEvID() {
        return evID;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getImg() { return img; }

    public boolean getEnrolled() { return enrolled; }

    public void setEnrolled (boolean t) {enrolled = t; }


}