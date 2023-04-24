package com.example.myapplication20_fregment.DT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication20_fregment.R;

import java.util.List;

public class DTActivity extends AppCompatActivity {
    private BaseFragment fragmentA,fragmentB,fragmentC,fragmentD;
    private TextView textCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dt);

        initView();
        initData();
    }

    private void initView() {
        textCount=(TextView) findViewById(R.id.text_fragment_count);
        findViewById(R.id.button_add_C).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addC();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_remove_C).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                removeC();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_show_C).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showC();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_hide_C).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                hideC();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_attach_C).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                attachC();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_detach_C).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                detachC();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_add_B).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addB();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_remove_B).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                removeB();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_show_B).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showB();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_hide_B).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                hideB();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_attach_B).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                attachB();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_detach_B).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                detachB();
                updateFragmentCount();
            }
        });
        findViewById(R.id.button_replace).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                replace();
                updateFragmentCount();
            }
        });
    }

    private void initData() {
        fragmentA=BaseFragment.instance("A");
        fragmentB=BaseFragment.instance("B");
        fragmentC=BaseFragment.instance("C");
        fragmentD=BaseFragment.instance("D");

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.layout_content_fragment,fragmentA);
        fragmentTransaction.add(R.id.layout_content_fragment,fragmentB);
        fragmentTransaction.add(R.id.layout_content_fragment,fragmentC);
        fragmentTransaction.commitNow();
        updateFragmentCount();
    }

    private void updateFragmentCount() {
        List<Fragment> fragments=getSupportFragmentManager().getFragments();
        int count=(fragments==null?0:fragments.size());
        textCount.setText("当前Fragment的个数为："+count);
    }

    private void replace() {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_content_fragment,fragmentD);
        fragmentTransaction.commitNow();
    }

    private void addC(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.layout_content_fragment,fragmentC);
        fragmentTransaction.commitNow();
    }
    private void removeC(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragmentC);
        fragmentTransaction.commitNow();
    }
    private void hideC(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(fragmentC);
        fragmentTransaction.commitNow();
    }
    private void showC(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(fragmentC);
        fragmentTransaction.commitNow();
    }
    private void attachC(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.attach(fragmentC);
        fragmentTransaction.commitNow();
    }
    private void detachC(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.detach(fragmentC);
        fragmentTransaction.commitNow();
    }

    private void addB(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.layout_content_fragment,fragmentB);
        fragmentTransaction.commitNow();
    }
    private void removeB(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragmentB);
        fragmentTransaction.commitNow();
    }
    private void hideB(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(fragmentB);
        fragmentTransaction.commitNow();
    }
    private void showB(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(fragmentB);
        fragmentTransaction.commitNow();
    }
    private void attachB(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.attach(fragmentB);
        fragmentTransaction.commitNow();
    }
    private void detachB(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.detach(fragmentB);
        fragmentTransaction.commitNow();
    }

}