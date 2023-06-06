package com.example.moviemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.main_button);
        TextView text1 = findViewById(R.id.create_account);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = findViewById(R.id.main_edit);

                Intent intent = new Intent(MainActivity.this, MainScreen.class);
                startActivity(intent);

                Toast t = Toast.makeText(MainActivity.this,"hello, "+edit.getText(),Toast.LENGTH_SHORT);
                t.show();
            }
        });


        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }




}
