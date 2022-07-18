package com.example.financecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SimpleInterest extends AppCompatActivity {
EditText principal,interest, duration;
Button calculate,back;
TextView intout,totout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest);
        principal=findViewById(R.id.principle);
        interest=findViewById(R.id.interest);
        duration=findViewById(R.id.time);
        calculate=findViewById(R.id.calculate_si);
        intout=findViewById(R.id.interest_out);
        totout=findViewById(R.id.tot_out);
        back=findViewById(R.id.bsi);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float principle,rate,time;
                principle=Float.parseFloat(principal.getText().toString());
                rate=Float.parseFloat(interest.getText().toString());
                time=Float.parseFloat(duration.getText().toString());

                calculatesi(principle,rate,time);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SimpleInterest.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
    void calculatesi(float principal,float rate,float time){
        float years=time/12;
        float interest=principal*rate*years;
        interest=interest/100;
        float tot=principal+interest;

        intout.setText("Total interest is "+Float.toString(interest));
        intout.setVisibility(View.VISIBLE);
        totout.setText("The total amount is "+Float.toString(tot));
        totout.setVisibility(View.VISIBLE);




    }
}