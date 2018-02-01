package com.rabindra.vehicalnepal.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.rabindra.vehicalnepal.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CarListActivity extends AppCompatActivity {
    AQuery aQuery;
    String baseUrl="http://192.168.100.199/vehicle/new/carData/";
    String intentExtra = "fail";
    int flag;
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
        flag= getIntent().getIntExtra("flag",0);
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
                        info.image=object1.getString("image");
                        info.Engine = convertToArrayList(object1.getJSONArray("ENGINE"));
                        info.Dynamics = convertToArrayList(object1.getJSONArray("DYNAMICS"));
                        info.Dimensions = convertToArrayList(object1.getJSONArray("DIMENSIONS"));
                        info.FuelConsumption = convertToArrayList(object1.getJSONArray("FUEL CONSUMPTION"));
                        info.Performance = convertToArrayList(object1.getJSONArray("PERFORMANCE"));
                        info.price=object1.getString("price");
                        info.Transmission = convertToArrayList(object1.getJSONArray("TRANSMISSION"));
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
                CarListAdapter carListAdapter = new CarListAdapter(context, vehicleList, flag);
                container.setAdapter(carListAdapter);
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

    public void setValue(VehicleInfo info){
        Intent intent = new Intent();
        Log.v("logmsg",info+"");
        intent.putExtra("body", formatString(info.Body));
        intent.putExtra("engine", formatString(info.Engine));
        intent.putExtra("performance", formatString(info.Performance));
        intent.putExtra("Transmission", formatString(info.Transmission));
        intent.putExtra("fuelconsumption", formatString(info.FuelConsumption));
        intent.putExtra("name", info.name);
        intent.putExtra("image", info.image);
        intent.putExtra("price", info.price);
        intent.putExtra("dynamics", info.Dynamics);
        intent.putExtra("chassis", info.Chassis);
        intent.putExtra("Dimensions", info.Dimensions);

        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public String formatString(ArrayList<String> arr){
        StringBuilder builder = new StringBuilder();
        for (String details : arr) {
            builder.append(details + "\n\n");
        }
        return builder.toString();
    }
}
