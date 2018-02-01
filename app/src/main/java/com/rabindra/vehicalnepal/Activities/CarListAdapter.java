package com.rabindra.vehicalnepal.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.rabindra.vehicalnepal.R;

import java.util.ArrayList;

/**
 * Created by User on 2/1/2018.
 */
public class CarListAdapter extends ArrayAdapter<VehicleInfo> {
    Context context;
    AQuery aquery;
    int flag;
    public CarListAdapter(Context context, ArrayList<VehicleInfo> info, int flag) {
        super(context,0,info);
        this.context=context;
        this.flag = flag;
        aquery=new AQuery(context);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.bike_list_individual,null);
        final VehicleInfo info= getItem(position);
        ImageView image=view.findViewById(R.id.image);
        TextView name=view.findViewById(R.id.name_in_list_view);
        image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VehicleInfo info = getItem(position);
                    Intent intent = new Intent(context, CarDetailPageActivity.class);
                    intent.putExtra("engine", formatString(info.Engine));
                    intent.putExtra("performance", formatString(info.Performance));
                    intent.putExtra("transmission", formatString(info.Transmission));
                    intent.putExtra("fuelconsumption", formatString(info.FuelConsumption));
                    intent.putExtra("name", info.name);
                    intent.putExtra("image", info.image);
                    intent.putExtra("price", info.price);
                    intent.putExtra("dynamics", formatString(info.Dynamics));
                    intent.putExtra("dimensions", formatString(info.Dimensions));

                    if (flag==0) {
                        context.startActivity(intent);
                    }
                    else{
                        ((CarListActivity)context).setValue(info);
                        Toast.makeText(context, "Selected item "+ position, Toast.LENGTH_SHORT).show();
                    }
                }
            });

        aquery.id(image).image(info.image);
        name.setText(info.name);
        ((TextView)view.findViewById(R.id.price)).setText(info.price);
        return view;
    }

    public String formatString(ArrayList<String> arr){
        StringBuilder builder = new StringBuilder();
        for (String details : arr) {
            builder.append(details + "\n\n");
        }
        return builder.toString();
    }

}
