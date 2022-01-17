package com.example.options_menu_211;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Timer;
import java.util.TimerTask;

public class TestAct extends AppCompatActivity implements View.OnClickListener {
    private int counter=0;
    private boolean finished = false;
    private RadioGroup q1,q2,q3,q4,q5;
    private Button button_done,Reset_Btn;
    private String[] answers = {"1948","1478","רוסיה","18","הר האוורסט"};
    public static final String COUNTER_INTENT = "counter";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_form);
        Intent i = getIntent();
        findViews();

    }


    public void findViews() {
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        Reset_Btn = findViewById(R.id.resetbtn);
        button_done = findViewById(R.id.button_done);
        button_done.setOnClickListener(this);
        Reset_Btn.setOnClickListener(this);
    }


    private void calculateScore() {
        RadioButton selected_q1 = findViewById(q1.getCheckedRadioButtonId());
        RadioButton selected_q2 = findViewById(q2.getCheckedRadioButtonId());
        RadioButton selected_q3 = findViewById(q3.getCheckedRadioButtonId());
        RadioButton selected_q4 = findViewById(q4.getCheckedRadioButtonId());
        RadioButton selected_q5 = findViewById(q5.getCheckedRadioButtonId());
        if(selected_q1 != null && selected_q2 != null && selected_q3 != null && selected_q4 != null) {
            finished = true;
            counter=0;
            if (selected_q1.getText().equals(answers[0])) {
                counter += 20;
            }
            if (selected_q2.getText().equals(answers[1])) {
                counter += 20;
            }
            if (selected_q3.getText().equals(answers[2])) {
                counter += 20;
            }
            if (selected_q4.getText().equals(answers[3])) {
                counter += 20;
            }
            if (selected_q5.getText().equals(answers[4])) {
                counter += 20;
            }
            if(counter >= 100){
                counter =100;
            }
        }

    }


    @Override
    public void onClick(View view) {
        if(view == Reset_Btn){
            if(q1 == null&&q2 == null&&q3 == null&&q4 == null&&q5 == null){
                Toast.makeText(this,"you have to select an answer to reset!",Toast.LENGTH_LONG).show();

            }
            else{
                this.q1.clearCheck();
                this.q2.clearCheck();
                this.q3.clearCheck();
                this.q4.clearCheck();
                this.q5.clearCheck();
            }


        }
        if(view.getId() == R.id.button_done) {
            calculateScore();
            if (!finished) {
                Snackbar.make(view,"You haven't answered all the questions yet..",Snackbar.LENGTH_SHORT).show();
            } else {
                finished = false;
                Intent finish_act = new Intent(TestAct.this, FinishTestAct.class);
                finish_act.putExtra(COUNTER_INTENT,counter);
                //finish_act.putExtra(First_Name,firstname.toString());
                //finish_act.putExtra(Last_Name,lastname.toString());
                startActivity(finish_act);
            }
        }

    }
}
