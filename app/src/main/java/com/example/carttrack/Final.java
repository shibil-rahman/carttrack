package com.example.carttrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Final extends AppCompatActivity {

    Button pay, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        pay = findViewById(R.id.button4);
        home = findViewById(R.id.button5);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Final.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}