package com.example.moviemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviemaster.SQLite.DataBaseHelper;
import com.example.moviemaster.Test.TestActivity;

public class MainActivity extends AppCompatActivity{


    Button logInBtn;
    TextView createAccount;

    EditText userName, password;

    DataBaseHelper dbh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        logInBtn = findViewById(R.id.main_button);
        createAccount = findViewById(R.id.create_account);

        userName = findViewById(R.id.main_edit);
        password = findViewById(R.id.main_edit_password);

        dbh = new DataBaseHelper(this);


        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String client = userName.getText().toString();
                String passwd = password.getText().toString();
                if (client.equals("") || passwd.equals(""))
                    Toast.makeText(MainActivity.this, "You have empty fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkAccount = dbh.checkUserNamePassword(client,passwd);
                    if (checkAccount){
                        Toast.makeText(MainActivity.this,"Welcome, "+userName.getText(),Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                        startActivity(intent);

                    } else Toast.makeText(MainActivity.this, "Invalid account", Toast.LENGTH_SHORT).show();
                }

            }
        });


        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }




}
