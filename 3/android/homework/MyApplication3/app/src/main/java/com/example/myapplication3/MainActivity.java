package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private boolean[] checkedArray = new boolean[]{false,false,false,false};
    private CheckBox ch1;
    private CheckBox ch2;
    private CheckBox ch3;
    private CheckBox ch4;
    private TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实现单选按钮方法一
        RadioGroup rd_group = (RadioGroup) findViewById(R.id.rd_group);
        rd_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton man=(RadioButton)findViewById(R.id.man);
                RadioButton woman=(RadioButton)findViewById(R.id.woman);
                switch (i) {
                    case R.id.man:
                        Toast.makeText(MainActivity.this,man.getText(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.woman:
                        Toast.makeText(MainActivity.this,woman.getText(),Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
//        实现复选框
        ch1=(CheckBox)findViewById(R.id.chckbox1);
        ch2=(CheckBox)findViewById(R.id.chckbox2);
        ch3=(CheckBox)findViewById(R.id.chckbox3);
        ch4=(CheckBox)findViewById(R.id.chckbox4);
        tx1=(TextView)findViewById(R.id.textview1);

        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkedArray[0]=b;
                textViewResult();
            }
        });
        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkedArray[1]=b;
                textViewResult();
            }
        });
        ch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkedArray[2]=b;
                textViewResult();
            }
        });
        ch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkedArray[3]=b;
                textViewResult();
            }
        });



    }

    private void textViewResult() {
        int sum=0;
        String val="";
//        这里的语法不是很懂 针对于Array的循环
        for(boolean v:checkedArray)
            if(v==true){
                sum+=1;
            }
            if(sum==0){
                tx1.setText("0 选择");
            }else{
                if(checkedArray[0]==true) val+=",篮球";
                if(checkedArray[1]==true) val+=",排球";
                if(checkedArray[2]==true) val+=",乒乓球";
                if(checkedArray[3]==true) val+=",足球";
                val=sum+"选择性："+val.substring(1);
                tx1.setText(val);
            }

    }
}