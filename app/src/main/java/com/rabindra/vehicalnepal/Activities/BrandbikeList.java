package com.rabindra.vehicalnepal.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.rabindra.vehicalnepal.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BrandbikeList extends AppCompatActivity {
    AQuery aQuery;
    String baseUrl="http://192.168.100.199/vehicle/new/bikeData/";
    String intentExtra = "fail";
    ListView container;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bike_list);
        container = findViewById(R.id.listConatainer);
        context = this;
        aQuery=new AQuery(this);
        intentExtra= getIntent().getStringExtra("url");
        Log.v("logmessage",intentExtra);
        fetchurl(baseUrl+intentExtra+"Data");

    }
    public void fetchurl(String url)
    {
        aQuery.ajax(url, JSONArray.class,new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray object, AjaxStatus status) {
                super.callback(url, object, status);
                ArrayList<VehicleInfo> vehicleList = new ArrayList<VehicleInfo>();
                Log.v("logmessage",object+"");
                for (int i = 0; i < object.length(); i++) {
                    try {
                        VehicleInfo info = new VehicleInfo();
                        JSONObject object1 = object.getJSONObject(i);
                        info.name=object1.getString("name");
                        info.id=object1.getString("id");
                       // textView.setText(brake);
                        info.Body = convertToArrayList(object1.getJSONArray("Body/ Exterior Design/ Dimensions"));
                        info.image=object1.getString("image");
                        info.Chassis = convertToArrayList(object1.getJSONArray("CHASSIS / BRAKES / SUSPENSIONS"));
                        info.Engine = convertToArrayList(object1.getJSONArray("Engine Specifications"));
                        info.Performance = convertToArrayList(object1.getJSONArray("PERFORMANCE"));
                        info.price=object1.getString("price");
                        info.Transmission = convertToArrayList(object1.getJSONArray("Transmission"));
                        vehicleList.add(info);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.v("logmessage",vehicleList.size()+"");
                for (VehicleInfo s: vehicleList) {
                    Log.v("logmessage", "" + s.name);
                }
                BikeListAdapter bikeListAdapter = new BikeListAdapter(context, vehicleList);
                container.setAdapter(bikeListAdapter);
                container.setScrollingCacheEnabled(false);
                }

        });

    }

    public ArrayList<String> convertToArrayList(JSONArray jArray){
        ArrayList<String> listdata = new ArrayList<String>();
        if (jArray != null) {
            for (int i=0;i<jArray.length();i++){
                try {
                    listdata.add(jArray.getString(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return listdata;
    }
}
