package com.rabindra.vehicalnepal.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.rabindra.vehicalnepal.R;

import java.util.ArrayList;

public class BikeDetailPageActivity extends AppCompatActivity {
    String body, engine, performance, transmission, name, image, price;
    AQuery aQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bike_detail_page);
        aQuery = new AQuery(this);
        body = getIntent().getStringExtra("body");
        engine = getIntent().getStringExtra("engine");
        performance = getIntent().getStringExtra("performance");
        transmission = getIntent().getStringExtra("transmission");
        name = getIntent().getStringExtra("name");
        image = getIntent().getStringExtra("image");
        price = getIntent().getStringExtra("price");
        ImageView bikeImage = findViewById(R.id.bikeImage);
        ((TextView)findViewById(R.id.body)).setText(body);
        ((TextView)findViewById(R.id.engine)).setText(engine);
        ((TextView)findViewById(R.id.performance)).setText(performance);
        ((TextView)findViewById(R.id.transmission)).setText(transmission);
        ((TextView)findViewById(R.id.name)).setText(name);
        ((TextView)findViewById(R.id.price)).setText(price);
        aQuery.id(bikeImage).image(image);

    }


}
