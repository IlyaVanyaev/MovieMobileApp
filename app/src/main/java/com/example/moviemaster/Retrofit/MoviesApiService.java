package com.example.moviemaster.Retrofit;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MoviesApiService {
    @Headers({"X-API-KEY: api-key", "Content-Type: application/json"})
    @GET("/api/v2.2/films/top")
    Call<Movie.MovieResult> getFilms();
}
