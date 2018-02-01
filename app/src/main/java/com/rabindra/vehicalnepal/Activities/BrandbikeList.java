package com.rock.vehicle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BrandbikeList extends AppCompatActivity {
    AQuery aQuery;
    String intentExtra = getIntent().getStringExtra("companyName");
    String baseUrl="http://192.168.100.199/vehicle/new/bikeData/";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aQuery=new AQuery(this);
        textView= (TextView) findViewById(R.id.test);
        fetchurl(baseUrl+intentExtra);

    }
    public void fetchurl(String url)
    {
        aQuery.ajax(url, JSONArray.class,new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray object, AjaxStatus status) {
                super.callback(url, object, status);
                ArrayList<VehicleInfo> vehicleList = new ArrayList<VehicleInfo>();
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
                    //for (String s: array1) {
                    //  Log.i("msg", "" + s);

                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
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
