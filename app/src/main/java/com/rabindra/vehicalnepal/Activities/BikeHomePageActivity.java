package com.rabindra.vehicalnepal.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

import com.rabindra.vehicalnepal.R;

import java.util.ArrayList;

public class BikeHomePageActivity extends AppCompatActivity {
    GridLayout mainGrid;
    ArrayList<String> bikeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                    Intent intent = new Intent(BikeHomePageActivity.this, BrandListActivity.class);
                    intent.putExtra("url", bikeName);
                    Log.v("logmessage", bikeName);
                    startActivity(intent);


                }
            });
        }
    }
}
