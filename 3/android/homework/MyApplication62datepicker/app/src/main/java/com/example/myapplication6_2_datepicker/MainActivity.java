package com.example.myapplication6_2_datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int year,month,day,hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar= Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH)+1;
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hour=calendar.get(Calendar.HOUR);
        minute=calendar.get(Calendar.MINUTE);
        DatePicker da=(DatePicker) findViewById(R.id.datePicker);
        TimePicker ti=(TimePicker) findViewById(R.id.timePicker);

        da.init(year, month, day, new DatePicker.OnDateChangedListener() {
//            问题：时间无法改变
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                MainActivity.this.year=i;
                MainActivity.this.month=i1+1;
                MainActivity.this.day=i2;
                showDate(i,i1+1,i2,hour,minute);
                System.out.println("ddd");
            }
        });
        ti.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                MainActivity.this.hour=i;
                MainActivity.this.minute=i1;
                showDate(year,month,day,i,i1);
                System.out.println("ttt");
            }
        });
    }

    private void showDate(int year, int month, int day, int hour, int minute) {
        EditText ed = (EditText) findViewById(R.id.editTest);
        ed.setText("您选择的日期为："+year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分");
        System.out.println("sss");
    }
}