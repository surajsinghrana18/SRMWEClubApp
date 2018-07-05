package in.weclub.srmweclubapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.ViewHolder>{

    private List<VendorInfo> vendors;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView vendName, vendLoc, offer;
        public ImageView img;
        public RelativeLayout parentLayout;

        public ViewHolder(View v) {
            super(v);
            vendName = (TextView)v.findViewById(R.id.vendName);
            vendLoc = (TextView)v.findViewById(R.id.vendLoc);
            offer = (TextView)v.findViewById(R.id.offer);
            img = (ImageView)v.findViewById(R.id.vendImg);
            parentLayout = v.findViewById(R.id.vend);
        }
    }

    public VendorAdapter(Context c, List<VendorInfo> vendorInfos){
        vendors = vendorInfos;
        context = c;
    }

    @NonNull
    @Override
    public VendorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vendor_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( @NonNull VendorAdapter.ViewHolder holder, int position) {
        VendorInfo v = vendors.get(position);
        holder.vendName.setText(v.getVendorName());
        holder.vendLoc.setText(v.getVendorLoc());
        holder.offer.setText(v.getOffer());
        Glide.with(context).load(v.getVendorImage()).into(holder.img);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Offer Claimed", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return vendors.size();
    }

}
