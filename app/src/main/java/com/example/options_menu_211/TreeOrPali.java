package com.example.options_menu_211;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class TreeOrPali extends AppCompatActivity implements View.OnClickListener {
    Button GenButton;
    ImageView Pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tree_or_pali);
        Intent i = getIntent();
        init();
        GenButton.setOnClickListener(this);
    }
    private void init(){
        GenButton = findViewById(R.id.genbtn);
        Pic = findViewById(R.id.pic);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
        //if it was false the menu won't show
    }
    @Override
    public void onClick(View view) {
        if(GenButton == view){
            Toast.makeText(this, "Generated!",Toast.LENGTH_SHORT);
            Random rnd = new Random();
            int x = rnd.nextInt(10);
            if(x%2==0){
                Pic.setImageResource(R.drawable.pali);
            }
            else{
                Pic.setImageResource(R.drawable.tree);
            }
        }
    }
}