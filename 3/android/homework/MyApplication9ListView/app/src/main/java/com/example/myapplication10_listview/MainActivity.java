package com.example.myapplication10_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView lv;
    private ArrayList<Spot> spots;
    private View pwView;
    private PopupWindow pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);

//        ArrayList<Map<String,Object>> maps=new ArrayList<>();
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("pho",R.drawable.f1);
//        map.put("name","条目名1");
//        map.put("dsc","条目介绍");
//        maps.add(map);
//        map=new HashMap<>();
//        map.put("pho",R.drawable.f2);
//        map.put("name","条目名2");
//        map.put("dsc","条目介绍");
//        maps.add(map);
//        map=new HashMap<>();
//        map.put("pho",R.drawable.f3);
//        map.put("name","条目名3");
//        map.put("dsc","条目介绍");
//        maps.add(map);
//        map=new HashMap<>();
//        map.put("pho",R.drawable.f4);
//        map.put("name","条目名4");
//        map.put("dsc","条目介绍");
//        maps.add(map);
//        map=new HashMap<>();
//        map.put("pho",R.drawable.f5);
//        map.put("name","条目名5");
//        map.put("dsc","条目介绍");
//        maps.add(map);
//        map=new HashMap<>();
//        map.put("pho",R.drawable.f6);
//        map.put("name","条目名6");
//        map.put("dsc","条目介绍");
//        maps.add(map);
//        map=new HashMap<>();
//        map.put("pho",R.drawable.f7);
//        map.put("name","条目名7");
//        map.put("dsc","条目介绍");
//        maps.add(map);
//        String[] from={"pho","name","dsc"};
//        int[] to={R.id.iv,R.id.tv1,R.id.tv2};
//
//        SimpleAdapter adapter=new SimpleAdapter(this,maps,R.layout.item_adapter,from,to);
//        lv.setAdapter(adapter);
//    }
//}
        spots = new ArrayList<>();
        spots.add(new Spot(R.drawable.f1,"图片1","描述"));
        spots.add(new Spot(R.drawable.f2,"图片2","描述"));
        spots.add(new Spot(R.drawable.f3,"图片3","描述"));
        spots.add(new Spot(R.drawable.f4,"图片4","描述"));
        spots.add(new Spot(R.drawable.f5,"图片5","描述"));
        spots.add(new Spot(R.drawable.f6,"图片6","描述"));
        spots.add(new Spot(R.drawable.f7,"图片7","描述"));
        spots.add(new Spot(R.drawable.f8,"图片8","描述"));
        spots.add(new Spot(R.drawable.f9,"图片9","描述"));
        spots.add(new Spot(R.drawable.f10,"图片10","描述"));
        spots.add(new Spot(R.drawable.f11,"图片11","描述"));
        spots.add(new Spot(R.drawable.f12,"图片12","描述"));
        spots.add(new Spot(R.drawable.f13,"图片13","描述"));
        MyAdapter adapter=new MyAdapter();
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(pw==null){
                    pwView=View.inflate(MainActivity.this,R.layout.pw_layout,null);
                    pwView.findViewById(R.id.zx).setOnClickListener(MainActivity.this);
                    pwView.findViewById(R.id.cf).setOnClickListener(MainActivity.this);
                    pwView.findViewById(R.id.fx).setOnClickListener(MainActivity.this);
                    pw=new PopupWindow(pwView,view.getWidth()-100,view.getHeight()-80);
                    pw.setBackgroundDrawable(new BitmapDrawable());
                }
                if(pw.isShowing()){
                    pw.dismiss();
                }
                pw.showAsDropDown(view,40,-view.getHeight());
                new ScaleAnimation(0,1,0,1);

                ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1);
                scaleAnimation.setDuration(1000);
                pwView.startAnimation(scaleAnimation);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zx:
                pw.dismiss();
                Toast.makeText(this,"咨询",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cf:
                pw.dismiss();
                Toast.makeText(this,"出发",Toast.LENGTH_SHORT).show();
                break;
            case R.id.fx:
                pw.dismiss();
                Toast.makeText(this,"分享",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    class MyAdapter extends BaseAdapter{
        private ViewHolder ho;
        @Override
        public int getCount() {
            return spots.size();
        }
        @Override
        public Object getItem(int i) {
            return spots.get(i);
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
//        显示条目内容：当前位置，[缓存]信息，parent容器(ListView)
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view=View.inflate(MainActivity.this,R.layout.item_adapter,null);
                ho= new ViewHolder();
                ho.im=(ImageView) view.findViewById(R.id.iv);
                ho.tv1=(TextView)  view.findViewById(R.id.tv1);
                ho.tv2=(TextView) view.findViewById(R.id.tv2);
                view.setTag(ho);
            }else{
                ho=(ViewHolder)view.getTag();
            }
            Spot spot=(Spot) getItem(i);
            Glide.with(MainActivity.this).load(spot.getPho()).into(ho.im);
            ho.tv1.setText(spot.getName());
            ho.tv2.setText(spot.getDsc());
            return view;
        }
    }
    static class ViewHolder{
        public ImageView im;
        public TextView tv1;
        public TextView tv2;
    }
}