package com.example.myapplication3;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

//实现单选按钮方法二
public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton man;
    private RadioButton woman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        man=(RadioButton) findViewById(R.id.man);
        woman=(RadioButton) findViewById(R.id.woman);
        man.setOnClickListener(this);
        woman.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.man:
                Toast.makeText(this,man.getText()+"2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.woman:
                Toast.makeText(this,woman.getText()+"2",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}