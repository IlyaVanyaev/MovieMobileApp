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

public class SignUpActivity extends AppCompatActivity {

    Button registerButton;
    DataBaseHelper dbh;

    EditText userName, password;
    TextView logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        registerButton = findViewById(R.id.register_button);
        userName = findViewById(R.id.edit_name);
        password = findViewById(R.id.edit_password);
        logIn = findViewById(R.id.return_to_log_in);

        dbh = new DataBaseHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String client = userName.getText().toString();
                String passwd = password.getText().toString();

                if (client.equals("") || passwd.equals(""))
                    Toast.makeText(SignUpActivity.this, "You have empty fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkClientName = dbh.checkUserName(client);
                    if (!checkClientName){
                        Boolean insert = dbh.insertData(client, passwd);
                        if (insert){
                            Toast.makeText(SignUpActivity.this, "Registration completed", Toast.LENGTH_SHORT).show();

                            finish();

                        } else Toast.makeText(SignUpActivity.this, "Registration failed...", Toast.LENGTH_SHORT).show();
                    }
                    else Toast.makeText(SignUpActivity.this, "This user already exists", Toast.LENGTH_SHORT).show();
                }

            }
        });


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}