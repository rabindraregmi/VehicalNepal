package com.rabindra.vehicalnepal.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rabindra.vehicalnepal.Activities.BikeCompareActivity;
import com.rabindra.vehicalnepal.Activities.CarCompareActivity;
import com.rabindra.vehicalnepal.R;

/**
 * Created by User on 2/2/2018.
 */

public class CompareFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.compare_fragment, null);
        view.findViewById(R.id.bikes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BikeCompareActivity.class));
            }
        });
        view.findViewById(R.id.cars).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CarCompareActivity.class));
            }
        });
        return view;
    }
}
