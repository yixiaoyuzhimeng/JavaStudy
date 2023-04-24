package com.example.myapplication20_fregment.JT;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication20_fregment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_A} factory method to
 * create an instance of this fragment.
 */
public class Fragment_A extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__a, container, false);
    }
}