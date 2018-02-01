package com.rabindra.vehicalnepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.rabindra.vehicalnepal.R;

public class CompareActivity extends AppCompatActivity {
    ImageView vehicle1add, vehicle2add;
    TextView v1Info, v2Info;
    TextView v1Name, v2Name;
    String body, engine, performance, transmission, chassis, name, image, price;
    int vehicleNo;
    AQuery aQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare);
        aQuery=new AQuery(this);
        vehicle1add = findViewById(R.id.vehicle1Image);
        vehicle2add = findViewById(R.id.vehicle2Image);
        v1Info = findViewById(R.id.vehicle1Info);
        v2Info = findViewById(R.id.vehicle2Info);
        v1Name = findViewById(R.id.vehicle1);
        v2Name = findViewById(R.id.vehicle2);

        vehicle1add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompareActivity.this, BrandListActivity.class);
                intent.putExtra("flag", 1);
                vehicleNo=1;
                startActivityForResult(intent, 100);
            }
        });

        vehicle2add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompareActivity.this, BrandListActivity.class);
                intent.putExtra("flag", 1);
                vehicleNo=2;
                startActivityForResult(intent, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (100): {
                if (resultCode == Activity.RESULT_OK) {
                    body = data.getStringExtra("body");
                    engine = data.getStringExtra("engine");
                    performance = data.getStringExtra("performance");
                    transmission = data.getStringExtra("transmission");
                    chassis = data.getStringExtra("chassis");
                    name = data.getStringExtra("name");
                    image = data.getStringExtra("image");
                    price = data.getStringExtra("price");
                }
            }
        }
        if (vehicleNo==1){
            aQuery.id(vehicle1add).image(image);
            v1Name.setText(price);
        }
        else if (vehicleNo==2){
            aQuery.id(vehicle2add).image(image);
            v2Name.setText(price);
        }

    }
}
