package com.example.moviemaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.moviemaster.Retrofit.Movie;
import com.example.moviemaster.Retrofit.MoviesApiService;


import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainScreen extends AppCompatActivity implements MovieRecyclerInterface{

    RecyclerView recyclerView;

    static final String BASE_URL = "https://kinopoiskapiunofficial.tech";

    List<Movie> movies;

    MoviesAdapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        mAdapter = new MoviesAdapter(this, this);
        recyclerView.setAdapter(mAdapter);
        movies = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            movies.add(new Movie());
        }
        mAdapter.setMovieList(movies);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MoviesApiService service = retrofit.create(MoviesApiService.class);
        Call<Movie.MovieResult> call = service.getFilms();
        call.enqueue(new Callback<Movie.MovieResult>() {
            @Override
            public void onResponse(@NonNull Call<Movie.MovieResult> call, @NonNull Response<Movie.MovieResult> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    movies = mAdapter.setMovieList(response.body().getFilms());
                }
                else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movie.MovieResult> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });

    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
        intent.putExtra("IMAGE", movies.get(position).getPosterUrl());
        intent.putExtra("TITLE",movies.get(position).getNameRu());
        intent.putExtra("YEAR",movies.get(position).getYear());
        intent.putExtra("LENGTH",movies.get(position).getFilmLength());
        intent.putExtra("RATING",movies.get(position).getRating());
        startActivity(intent);

    }


    public static class MovieViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
        public MovieViewHolder(View itemView, MovieRecyclerInterface recyclerInterface)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.MovieImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (recyclerInterface != null){
                        int position = getAbsoluteAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) recyclerInterface.onItemClick(position);
                    }

                }
            });

        }
    }
}