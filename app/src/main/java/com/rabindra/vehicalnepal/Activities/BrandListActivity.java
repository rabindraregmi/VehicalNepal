package com.rabindra.vehicalnepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

import com.rabindra.vehicalnepal.R;

import java.util.ArrayList;

public class BrandListActivity extends AppCompatActivity {
    GridLayout mainGrid;
    ArrayList<String> bikeList;
    int flag;
    String body, engine, performance, transmission, chassis, name, image, price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flag = getIntent().getIntExtra("flag",0);
        bikeList = new ArrayList<>();
        bikeList.add("ace-british-motorcycles");
        bikeList.add("aprilia-2");
        bikeList.add("bajaj-2");
        bikeList.add("benelli");
        bikeList.add("crossfire");
        bikeList.add("ducati");
        bikeList.add("hartford");
        bikeList.add("hero");
        bikeList.add("honda-2");
        bikeList.add("husqvarna");
        bikeList.add("italjet");
        bikeList.add("kawasaki");
        bikeList.add("ktm");
        bikeList.add("mahindra-2");
        bikeList.add("mv-agusta");
        bikeList.add("royal-enfield");
        bikeList.add("suzuki");
        bikeList.add("sym");
        bikeList.add("terra-motors");
        bikeList.add("tvs");
        bikeList.add("um");
        bikeList.add("vespa");
        bikeList.add("yamaha");
        setContentView(R.layout.grid_view);
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
                    String bikeName = bikeList.get(finalI);
                    Intent intent = new Intent(BrandListActivity.this, BikeListActivity.class);
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
                    body = data.getStringExtra("body");
                    engine = data.getStringExtra("engine");
                    performance = data.getStringExtra("performance");
                    transmission = data.getStringExtra("transmission");
                    chassis = data.getStringExtra("chassis");
                    name = data.getStringExtra("name");
                    image = data.getStringExtra("image");
                    price = data.getStringExtra("price");
                    Log.v("logmsg","Brandlistact onacresult : "+body);
                    Intent intent = new Intent();
                    intent.putExtra("body", body);
                    intent.putExtra("engine", engine);
                    intent.putExtra("performance", performance);
                    intent.putExtra("transmission", transmission);
                    intent.putExtra("chassis", chassis);
                    intent.putExtra("name", name);
                    intent.putExtra("image", image);
                    intent.putExtra("price", price);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
                break;
            }
        }
    }
}
