package in.weclub.srmweclubapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
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

public class EventAdapter  extends RecyclerView.Adapter<EventAdapter.ViewHolder> implements View.OnClickListener{

    private List<EventInfo> events;
    private Context context;

    @Override
    public void onClick(View view) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView eventName, speaker, endTime , startTime, enr;
        public ImageView img;
        public RelativeLayout parentLayout;
        public ViewHolder(View v) {
            super(v);
            eventName = (TextView) v.findViewById(R.id.eventName);
            speaker = (TextView)v.findViewById(R.id.speaker);
            endTime = (TextView)v.findViewById(R.id.endTime);
            startTime = (TextView)v.findViewById(R.id.startTime);
            img = (ImageView) v.findViewById(R.id.imageView3);
            enr = (TextView) v.findViewById(R.id.enr);
            parentLayout = v.findViewById(R.id.parentLayout);
        }
    }

    public EventAdapter(Context context, List<EventInfo> infoList)
    {
        events = infoList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EventInfo info = events.get(position);
        holder.eventName.setText(info.getName());
        holder.speaker.setText(String.format("Speaker: %s", info.getSpeaker()));
        holder.startTime.setText(String.format("Start Time: %s", info.getStartTime()));
        holder.endTime.setText(String.format("End Time: %s", info.getEndTime()));
        Glide.with(context).load(info.getImg()).into(holder.img);
        final String s = info.getEvID();

        if(info.getEnrolled()){
            holder.enr.setText("Enrolled");
            holder.enr.setBackgroundColor(Color.rgb(219,25,25));
        }
        else{
            holder.enr.setText("Open");
            holder.enr.setBackgroundColor(Color.rgb(36 ,219,25));
        }
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Event Clicked " + s, Toast.LENGTH_SHORT).show();
                Intent it = new Intent(context,EventDescription.class);
                it.putExtra("Event ID",s);
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
