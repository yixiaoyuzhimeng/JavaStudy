package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends  AppCompatActivity {
    private Spinner sp1;
    private  Spinner sp2;
    private String[] prov={"四川省","江苏省"};
    private String[][] cities ={{"成都市","绵阳市","宜宾市","德阳市"},{"南京","苏州","无锡","徐州"}};
    private ArrayAdapter<String> provAdapter;
    private ArrayAdapter<String> cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1 = (Spinner) findViewById(R.id.sp1);
        sp2 = (Spinner) findViewById(R.id.sp2);

//        创建省份适配器， 参数：上下文对象，样式，数据
        provAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,prov);
//          设置适配器
        sp1.setAdapter(provAdapter);
//        创建城市适配器，不放数据，而是动态添加数据
        cityAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        sp2.setAdapter(cityAdapter);


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] city=cities[i];
                cityAdapter.clear();
                cityAdapter.addAll(city);
                sp2.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}