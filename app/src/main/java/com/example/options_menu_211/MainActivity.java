package com.example.options_menu_211;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
        //if it was false the menu won't show
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.camera) {
            Toast.makeText(this,"בחרת ב - מצלמה",Toast.LENGTH_SHORT).show();

            Intent next_act = new Intent(MainActivity.this, Camera.class);
            startActivity(next_act);
            return true;
        }
        else if (id == R.id.tree_pali) {
            Toast.makeText(this,"בחרת ב - גנרטור",Toast.LENGTH_SHORT).show();
            Intent next_act = new Intent(MainActivity.this, TreeOrPali.class);
            startActivity(next_act);
            return true;
        }
        else if (id == R.id.forms) {
            Toast.makeText(this,"בחרת ב - פורמס",Toast.LENGTH_SHORT).show();
            Intent next_act = new Intent(MainActivity.this, TestAct.class);
            startActivity(next_act);
            return true;
        }
        return true;

    }
}