package com.rabindra.vehicalnepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

import com.rabindra.vehicalnepal.R;

import java.util.ArrayList;

public class CarBrandListActivity extends AppCompatActivity {
    GridLayout mainGrid;
    ArrayList<String> carList;
    int flag;
    String body, engine, performance, transmission, chassis,dimensions, name, image, price,fuelConsumption,dynamics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flag = getIntent().getIntExtra("flag",0);
        carList = new ArrayList<>();
        carList.add("chery");
        carList.add("daihatsu");
        carList.add("datsun");
        carList.add("fiat");
        carList.add("ford");
        carList.add("geely");
        carList.add("great-wall");
        carList.add("honda");
        carList.add("hyundai");
        carList.add("kia");
        carList.add("mahindra");
        carList.add("mazda");
        carList.add("mg");
        carList.add("mitsubishi");
        carList.add("nissan");
        carList.add("peugeot");
        carList.add("proton");
        carList.add("renault");
        carList.add("skoda");
        carList.add("ssangyong");
        carList.add("subaru");
        carList.add("suzuki");
        carList.add("tata");
        carList.add("toyota");
        carList.add("volkswagen");
        setContentView(R.layout.car_grid_view);
        mainGrid = findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {

        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            final int finalI1 = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.v("logmessage",finalI+"");
                    String bikeName = carList.get(finalI);
                    Intent intent = new Intent(CarBrandListActivity.this, CarListActivity.class);
                    intent.putExtra("url", bikeName);
                    Log.v("logmessage", bikeName);
                    if (flag!=0){
                        intent.putExtra("flag", flag);
                        startActivityForResult(intent, 101);
                    }
                    else {
                        startActivity(intent);
                    }

                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("logmsg","Brandlistact onacresult");
        switch(requestCode) {
            case (101) : {
                Log.v("logmsg","Brandlistact onacresult success");
                if (resultCode == Activity.RESULT_OK) {
                    Log.v("logmsg","Brandlistact onacresult success2");
                    engine = data.getStringExtra("engine");
                    performance = data.getStringExtra("performance");
                    transmission = data.getStringExtra("transmission");
                    name = data.getStringExtra("name");
                    image = data.getStringExtra("image");
                    price = data.getStringExtra("price");
                    fuelConsumption=data.getStringExtra("fuel");
                    dynamics=data.getStringExtra("dynamics");
                    dimensions=data.getStringExtra("dimensions");

                    Log.v("logmsg","Brandlistact onacresult : "+body);
                    Intent intent = new Intent();
                    intent.putExtra("engine", engine);
                    intent.putExtra("performance", performance);
                    intent.putExtra("transmission", transmission);
                    intent.putExtra("fuel", fuelConsumption);
                    intent.putExtra("name", name);
                    intent.putExtra("image", image);
                    intent.putExtra("price", price);
                    intent.putExtra("dynamics", dynamics);
                    intent.putExtra("dimensions", dimensions);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
                break;
            }
        }
    }
}
