package com.example.myapplication21_okhttp;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telecom.Call;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import javax.security.auth.callback.Callback;
//import okhttp3.*;


public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private final String KEY="c1737759ee484c04897f8fd124251774";
    private TextView tv_weather_conten;
    private EditText et_cityname;
    private Button btn_select_weather;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Weather weather=(Weather) msg.obj;
            switch(msg.what){
                case 1:
                    tv_weather_conten.setText(
                            "时间："+String.valueOf(weather.getHeWeather6().get(0).getUpdate().getLoc())+
                            "、地点："+weather.getHeWeather6().get(0).getBasic().getLocation()+
                            "、天气："+weather.getHeWeather6().get(0).getNow().getCond_txt()+
                            "、风向："+weather.getHeWeather6().get(0).getNow().getWind_dir()+
                            "、气温"+weather.getHeWeather6().get(0).getNow().getTmp());
                    break;
            }
            Log.d(TAG,"onResponse"+String.valueOf(weather.getHeWeather6().get(0).getUpdate().getLoc()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initDate();

        btn_select_weather.setOnClickListener((v)->{
            String cityname=String.valueOf(et_cityname.getText());
            if(cityname.equals("")){
                Toast.makeText(MainActivity.this,"城市名不能为空",Toast.LENGTH_SHORT).show();
            }else{
                String url="https://free-api.heweather.com/s6/weather/now?key=c1737759ee484c04897f8fd124251774&location="+cityname;
                new MyAsynTask().execute(url);
            }
        });

    }

    private void initView() {
        tv_weather_conten=(TextView) this.findViewById(R.id.tv_weather_conten);
        et_cityname=(EditText) this.findViewById(R.id.et_cityname);
        btn_select_weather=(Button)this.findViewById(R.id.btn_select_weather);
    }

    private void initDate() {
    }

    private class MyAsynTask extends AsyncTask<String,Void,Void> {

        @Override
        protected Void doInBackground(String... strings) {
            String url=strings[0];
            setWeather(url);
            return null;
        }
    }

    private void setWeather(String url) {
//        OkHttpClient okHttpClient=new OkHttpClient();
//        final Request request=new Request.Builder().url(url).get().build();
//        Log.d(TAG,"url:"+url);
//        Call call=okHttpClient.newCall(request);
//        call.enqueue(new Callback(){
//        });
    }
}