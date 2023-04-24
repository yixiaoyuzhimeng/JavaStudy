package com.example.myapplication18_intent;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Share_Activity extends AppCompatActivity {

    private EditText ed1;
    private ImageView im1;
    private Intent intent;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        ed1=findViewById(R.id.text1);
        im1=findViewById(R.id.image1);

    }


    public void click(View view) {
        switch (view.getId()){
            case R.id.but1:
                share();
                break;
            case R.id.but2:
                shareChoose();
                break;
            case R.id.image1:
                intent=new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null && resultCode==RESULT_OK){
            uri=data.getData();
            ContentResolver resolver=getContentResolver();
            try {
                Bitmap bitmap=MediaStore.Images.Media.getBitmap(resolver,uri);
                im1.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void shareChoose() {
        String str=ed1.getText().toString();
        intent =new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_TEXT,str);
        intent.putExtra(Intent.EXTRA_STREAM,uri);
        startActivity(Intent.createChooser(intent,"分享平台选择"));
    }

    private void share() {
        String str=ed1.getText().toString();
        intent =new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,str);
        startActivity(Intent.createChooser(intent,"分享文本信息"));

    }
}