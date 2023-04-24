package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        1.获取组件
        EditText ed5 = (EditText) findViewById(R.id.ed5);
        EditText ed6 = (EditText) findViewById(R.id.ed6);
        EditText ed7 = (EditText) findViewById(R.id.ed7);
        EditText ed8 = (EditText) findViewById(R.id.ed8);
//        2.为组件设置事件监听
//        点击事件
        ed5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                提示信息，在当前Activity页面
                Toast.makeText(MainActivity.this, "只允许输入数字", Toast.LENGTH_SHORT).show();
            }
        });
//        获取焦点事件
        ed6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasfocus) {
                Toast.makeText(MainActivity.this, "焦点改变", Toast.LENGTH_SHORT).show();
            }
        });
//        编辑事件 按enter以后
        ed7.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Toast.makeText(MainActivity.this, "2333" + v.getText(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//        文本内容见他
        ed8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(MainActivity.this,""+editable,Toast.LENGTH_SHORT).show();
            }

        });
    }
}