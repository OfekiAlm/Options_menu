package com.example.options_menu_211;


import static com.example.options_menu_211.TestAct.COUNTER_INTENT;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FinishTestAct extends AppCompatActivity implements View.OnClickListener {
    Button btn,pic;
    Bitmap bitmap;
    ImageView imgv;
    TextView displayscore;
    TextView namescore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_test_layout);

        init();
        Intent intent = getIntent();
        if(intent != null) {
            int counter = intent.getIntExtra(COUNTER_INTENT,0);
            displayscore.setText("Your score test is - "+counter);
        }

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == btn.getId()) {
            finish();
        }else if(view.getId() == pic.getId()) {
            opencamera();
        }

    }
    public void init(){
        btn=findViewById(R.id.btn);
        pic=findViewById(R.id.btn_pic);
        imgv=findViewById(R.id.pic1);
        displayscore = findViewById(R.id.scorevalue);
        btn.setOnClickListener(this);
        pic.setOnClickListener(this);
        namescore = findViewById(R.id.namnam);

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
                Toast.makeText(this,"no picture taken", Toast.LENGTH_LONG).show();
            }
        }
    }
}

