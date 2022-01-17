package com.example.options_menu_211;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Camera extends AppCompatActivity implements View.OnClickListener {
Bitmap bitmap;
ImageView imgv;
Button BtnPic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_layout);
        init();
    }

    private void init(){
        BtnPic=findViewById(R.id.btnupdatecamera);
        BtnPic.setOnClickListener(this);
        imgv=findViewById(R.id.pic);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
        //if it was false the menu won't show
    }
    private void opencamera() {
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0)
        {
            if(resultCode==RESULT_OK)
            {
                bitmap=(Bitmap) data.getExtras().get("data");
                imgv.setImageBitmap(bitmap);
            }
            else{
                Toast.makeText(this,"no picture taken", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        if(BtnPic == view){
            opencamera();
        }
    }
}
