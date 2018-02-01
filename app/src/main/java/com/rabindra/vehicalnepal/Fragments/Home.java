package com.rabindra.vehicalnepal.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.rabindra.vehicalnepal.Activities.BrandListActivity;
import com.rabindra.vehicalnepal.R;

import java.util.HashMap;

/**
 * Created by rabindra on 1/13/18.
 */

public class Home extends android.support.v4.app.Fragment implements BaseSliderView.OnSliderClickListener,ViewPagerEx.OnPageChangeListener{
    ListView listView;
    Spinner spinner;
    TextView Welcome;
    TextView textView;
    CardView cardView;

    LinearLayout linearLayout;
    private SliderLayout mDemoSlider;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, null);
        cardView=view.findViewById(R.id.newscard);
        cardView.setOnClickListener(mOnCardViewClickListner);

        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("A", R.mipmap.bike);
        file_maps.put("B", R.mipmap.bike2);
        file_maps.put("C", R.mipmap.car1);
        file_maps.put("D", R.mipmap.car2);
        file_maps.put("E", R.mipmap.car3);
        file_maps.put("F", R.mipmap.car1);


        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener((BaseSliderView.OnSliderClickListener) this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(6000);
        mDemoSlider.addOnPageChangeListener((ViewPagerEx.OnPageChangeListener) this);
       // textView = (TextView) .findViewById(R.id.message);


        return view;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    private CardView.OnClickListener mOnCardViewClickListner=new CardView.OnClickListener(){

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(getContext(),BrandListActivity.class);
            //intent.putExtra("info","This is activity from card item index  "+finalI);
            startActivity(intent);
            Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
        }
    } ;

}


