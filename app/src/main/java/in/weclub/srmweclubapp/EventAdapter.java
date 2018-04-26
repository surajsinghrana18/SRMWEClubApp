package in.weclub.srmweclubapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by root on 24/4/18.
 */

public class EventAdapter  extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<EventInfo> events;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView eventName, speaker, t, venue ,date;
        public ViewHolder(View v) {
            super(v);
            eventName = (TextView) v.findViewById(R.id.eventName);
            speaker = (TextView)v.findViewById(R.id.speaker);
            t = (TextView) v.findViewById(R.id.eventTime);
            venue = (TextView) v.findViewById(R.id.venue);
            date = (TextView) v.findViewById(R.id.date);
        }
    }

    public EventAdapter(List<EventInfo> infoList)
    {
        events = infoList;
    }
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout, parent, false);
        return new ViewHolder(v);











    }

    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder holder, int position) {
        EventInfo info = events.get(position);
        holder.eventName.setText(info.getName());
        holder.speaker.setText(String.format("Speaker: %s", info.getSpeaker()));
        holder.date.setText(String.format("Date: %s", info.getDate()));
        holder.t.setText(String.format("Time: %s", info.getTime()));
        holder.venue.setText(String.format("Venue: %s", info.getVenue()));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
