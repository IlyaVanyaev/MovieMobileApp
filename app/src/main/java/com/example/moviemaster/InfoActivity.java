package com.example.moviemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    ImageView infoImage;
    TextView infoTitle, infoYear, infoLength, infoRating;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        String poster = getIntent().getStringExtra("IMAGE");
        String ruName = getIntent().getStringExtra("TITLE");
        String year = getIntent().getStringExtra("YEAR");
        String length = getIntent().getStringExtra("LENGTH");
        String rating = getIntent().getStringExtra("RATING");


        infoImage = findViewById(R.id.info_image);
        infoTitle = findViewById(R.id.info_title);
        infoYear = findViewById(R.id.info_year);
        infoLength = findViewById(R.id.info_length);
        infoRating = findViewById(R.id.info_rating);

        Picasso.get().load(poster).into(infoImage);

        infoTitle.setText(ruName);
        infoYear.setText("Год выпуска: "+year);
        infoLength.setText("Длительность фильма: "+length);
        infoRating.setText("Рейтинг фильма: "+rating);

    }
}