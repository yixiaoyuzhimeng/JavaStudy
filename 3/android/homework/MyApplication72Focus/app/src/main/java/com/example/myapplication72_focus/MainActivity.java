package com.example.myapplication72_focus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edit1;
    private EditText edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);

        edit1.setOnClickListener(new MyOnclickListener());
        edit1.setOnFocusChangeListener(new MyOnFocusChangeListener());
        edit2.setOnClickListener(new MyOnclickListener());
        edit2.setOnFocusChangeListener(new MyOnFocusChangeListener());

    }

//    实现点击哪个输入框，哪个输入框内容清空
    private class MyOnclickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if ((view.getId()==edit1.getId())) {
                edit1.setText("");
            }else{
                edit2.setText("");
            }
        }
    }

    private class MyOnFocusChangeListener implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean b) {
            if (view.getId()==edit1.getId()) {
                Toast.makeText(MainActivity.this,"手机号文本框获取焦点",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this,"地址栏文本框获取焦点",Toast.LENGTH_SHORT).show();
            }
        }
    }
}