package com.example.myapplication20_fregment.CS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication20_fregment.R;

public class CsActivity extends AppCompatActivity {

    final String TAG="aaa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs);
        if(savedInstanceState==null){
            Log.d(TAG, "No saveInstanceState ");
            CsFragment csFragment=CsFragment.instance("aaa");
            getSupportFragmentManager().beginTransaction().replace(R.id.layout_content_fragment2,csFragment).commitNow();
        }else{
            Log.d(TAG, " save InstanceState ");
        }
    }
}