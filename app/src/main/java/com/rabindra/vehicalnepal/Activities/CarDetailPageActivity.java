package com.rabindra.vehicalnepal.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.rabindra.vehicalnepal.R;

public class CarDetailPageActivity extends AppCompatActivity {
    String body, engine, performance, transmission, chassis, name, image, price,dynamics,fuelconsumption,dimensions;
    AQuery aQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_detail_page);
        aQuery = new AQuery(this);
        dynamics = getIntent().getStringExtra("dynamics");
        engine = getIntent().getStringExtra("engine");
        price = getIntent().getStringExtra("price");
        performance = getIntent().getStringExtra("performance");
        transmission = getIntent().getStringExtra("transmission");
        name = getIntent().getStringExtra("name");
        image = getIntent().getStringExtra("image");
        fuelconsumption = getIntent().getStringExtra("fuelconsumption");
        dimensions= getIntent().getStringExtra("dimensions");
        ImageView carImage = findViewById(R.id.carImage);
        ((TextView)findViewById(R.id.Dynamics)).setText(dynamics);
        ((TextView)findViewById(R.id.Engine)).setText(engine);
        ((TextView)findViewById(R.id.performance)).setText(performance);
        ((TextView)findViewById(R.id.Transmission)).setText(transmission);
      //  ((TextView) findViewById(R.id.chassis)).setText(chassis);
        ((TextView)findViewById(R.id.name)).setText(name);
        ((TextView)findViewById(R.id.price)).setText(price);
        ((TextView)findViewById(R.id.fuel)).setText(fuelconsumption);
        ((TextView)findViewById(R.id.Dimensions)).setText(dimensions);
        aQuery.id(carImage).image(image);

    }


}
