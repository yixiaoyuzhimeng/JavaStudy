package com.example.myapplication11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int yourChoice;
    private ArrayList<Integer> yourChoices=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void normalDialog(View view) {
        AlertDialog.Builder nomalDialog = new AlertDialog.Builder(this);
        nomalDialog.setIcon(R.drawable.dia);
        nomalDialog.setTitle("我是一个普通的对话框");
        nomalDialog.setMessage("你要点击哪个按钮");
        nomalDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        nomalDialog.setCancelable(false);
        nomalDialog.show();
    }


    public void threeDialog(View view) {
        AlertDialog.Builder threeDialog = new AlertDialog.Builder(this);
        threeDialog.setTitle("我是一个按钮的对话框")
                .setIcon(R.drawable.dia)
                .setMessage("请点击任何一个按钮")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    public void listDialog(View view) {
        final String [] items={"我是1","我是2","我是3","我是4"};
        AlertDialog.Builder listDialog = new AlertDialog.Builder(this);
        listDialog.setTitle("列表选择对话框")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"你选择的是"+items[i],Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    public void singleDialog(View view) {
        final String [] items={"我是1","我是2","我是3","我是4"};
        yourChoice=-1;
        AlertDialog.Builder singleDialog = new AlertDialog.Builder(this);
        singleDialog.setTitle("单选对话框")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        yourChoice=i;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"你的选择是："+items[yourChoice],Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    public void multDialog(View view) {
        final String [] items={"我是1","我是2","我是3","我是4"};
        final boolean[] initChoices={false,false,false,false};
        yourChoices.clear();
        AlertDialog.Builder multDialog = new AlertDialog.Builder(this);
        multDialog.setTitle("多选对话框")
                .setMultiChoiceItems(items, initChoices, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b){
                            yourChoices.add(i);
                        }else{
                            yourChoices.remove(i);
                        }
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int size=yourChoices.size();
                        String str="";
                        for(int j=0;j<size;j++){
                            str+=items[yourChoices.get(j)]+"";
                        }
                        Toast.makeText(MainActivity.this,"你的选择是"+str,Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    public void editDialog(View view) {
        AlertDialog.Builder editDialog = new AlertDialog.Builder(this);
        final EditText editText=new EditText(MainActivity.this);
        editDialog.setView(editText)
                .setTitle("Edit对话框")
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"你输入的内容是"+editText.getText(),Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    public void custDialog(View view) {
        final View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.edit_layout, null);
        AlertDialog.Builder custDialog = new AlertDialog.Builder(this);
        custDialog.setView(inflate)
                .setTitle("自定义对话框")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText ed=(EditText) inflate.findViewById(R.id.edit1);
                        Toast.makeText(MainActivity.this,"你输入的内容是："+ed.getText(),Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

}