package com.example.myapplication13_async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Map<String,Object>> allFileItems=new ArrayList<>();
    private SimpleAdapter simple=null;
    private ListView fileList=null;
    private ListFileThread ft=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      调用布局管理器
        setContentView(R.layout.activity_main);
//      取得组件
        this.fileList=(ListView) super.findViewById(R.id.list);
//      从根目录下列出
        File filePath=new File(File.separator);
//      定义子任务
        this.ft=new ListFileThread();
//      传递File
        this.ft.execute(filePath);
//        设置事件
        this.fileList.setOnItemClickListener(new OnItemClickListenerImpl());
    }



    private class OnItemClickListenerImpl implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//            单击事件
//            取得选中选项
            File currFile=(File)MainActivity.this.allFileItems.get(i).get("name");

            if(currFile.isDirectory()){
                //            给定路径是文件夹,新列表
                MainActivity.this.allFileItems=new ArrayList<Map<String,Object>>();
                //            实例化线程对象
                ListFileThread ft=new ListFileThread();
                //            如果是文件夹则重新列出
                ft.execute(currFile);
            }
//            如果是文件就什么都不做
        }
    }

    private class ListFileThread extends AsyncTask<File,File,String> {
        @Override
        protected String doInBackground(File... files) {
            if(!files[0].getPath().equals(java.io.File.separator)){
                Map<String,Object> fileItem=new HashMap<String,Object>();
                fileItem.put("img",R.drawable.folderopen);
                fileItem.put("name",files[0].getParentFile());
                MainActivity.this.allFileItems.add(fileItem);
            }
            if(files[0].isDirectory()){
                File tempFile[]=files[0].listFiles();
                if(tempFile!=null){
                    for(int x=0;x<tempFile.length;x++){
                        this.publishProgress(tempFile[x]);
                    }
                }
            }
            return "文件已经列出";
        }
//        更新
        @Override
        protected void onProgressUpdate(File... values) {
            Map<String,Object> fileItem=new HashMap<String,Object>();
//            设置图标
            if(values[0].isDirectory()){
                fileItem.put("img",R.drawable.folderclose);
            }else{
                fileItem.put("img",R.drawable.file);
            }
//            设置文字
            fileItem.put("name",values[0]);
//            向集合中保存
            MainActivity.this.allFileItems.add(fileItem);
            MainActivity.this.simple=new SimpleAdapter(
                    MainActivity.this,
                    allFileItems,
                    R.layout.file_list,
                    new String[]{"img","name"},
                    new int[]{R.id.img,R.id.name}
            );
//            显示数据
            MainActivity.this.fileList.setAdapter(MainActivity.this.simple);
        }
    }

}