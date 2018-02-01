package com.rabindra.vehicalnepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.rabindra.vehicalnepal.R;

public class CarCompareActivity extends AppCompatActivity {

    ImageView vehicle1add, vehicle2add;
    TextView v1Name, v2Name;
    String fuel, dimensions, engine, performance, transmission, dynamics, name, image, price;
    LinearLayout compareItems;
    Button compareNow;
    Boolean v1=false, v2=false;
    int vehicleNo;
    AQuery aQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_compare);
        aQuery=new AQuery(this);
        vehicle1add = findViewById(R.id.vehicle1Image);
        vehicle2add = findViewById(R.id.vehicle2Image);
        compareItems = findViewById(R.id.compareItems);
        compareItems.setVisibility(View.GONE);
        compareNow = findViewById(R.id.compareNow);
        v1Name = findViewById(R.id.vehicle1);
        v2Name = findViewById(R.id.vehicle2);

        vehicle1add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarCompareActivity.this, CarBrandListActivity.class);
                intent.putExtra("flag", 1);
                vehicleNo=1;
                startActivityForResult(intent, 100);
            }
        });

        vehicle2add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarCompareActivity.this, CarBrandListActivity.class);
                intent.putExtra("flag", 1);
                vehicleNo=2;
                startActivityForResult(intent, 100);
            }
        });

        compareNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (v1&&v2) {
                    compareItems.setVisibility(View.VISIBLE);
                    Snackbar.make(view,"Comparison successful", Snackbar.LENGTH_LONG).show();
                }
                else
                    Snackbar.make(view,"Select both vehicles", Snackbar.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (100): {
                if (resultCode == Activity.RESULT_OK) {
                    transmission = data.getStringExtra("transmission");
                    engine = data.getStringExtra("engine");
                    performance = data.getStringExtra("performance");
                    dynamics = data.getStringExtra("dynamics");
                    dimensions = data.getStringExtra("dimensions");
                    fuel = data.getStringExtra("fuel");
                    name = data.getStringExtra("name");
                    image = data.getStringExtra("image");
                    price = data.getStringExtra("price");
                }
            }
        }
        if (vehicleNo==1){
            v1 = true;
            aQuery.id(vehicle1add).image(image);
            ((TextView)findViewById(R.id.name1)).setText(name);
            ((TextView)findViewById(R.id.transmission1)).setText(transmission);
            ((TextView)findViewById(R.id.engine1)).setText(engine);
            ((TextView)findViewById(R.id.dynamics1)).setText(dynamics);
            ((TextView)findViewById(R.id.performance1)).setText(performance);
            ((TextView)findViewById(R.id.dimensions1)).setText(dimensions);
            ((TextView)findViewById(R.id.fuel1)).setText(fuel);
            ((TextView)findViewById(R.id.price1)).setText(price);
        }
        else if (vehicleNo==2){
            v2 = true;
            aQuery.id(vehicle2add).image(image);
            ((TextView)findViewById(R.id.name2)).setText(name);
            ((TextView)findViewById(R.id.transmission2)).setText(transmission);
            ((TextView)findViewById(R.id.engine2)).setText(engine);
            ((TextView)findViewById(R.id.dynamics2)).setText(dynamics);
            ((TextView)findViewById(R.id.performance2)).setText(performance);
            ((TextView)findViewById(R.id.dimensions2)).setText(dimensions);
            ((TextView)findViewById(R.id.fuel2)).setText(fuel);
            ((TextView)findViewById(R.id.price2)).setText(price);
        }

    }
}
