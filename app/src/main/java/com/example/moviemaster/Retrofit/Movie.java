package com.example.moviemaster.Retrofit;

import com.google.gson.annotations.SerializedName;


import java.util.List;


public class Movie {
    @SerializedName("filmId")
    public int filmId;

    @SerializedName("nameRu")
    public String nameRu;

    @SerializedName("year")
    public String year;

    @SerializedName("posterUrl")
    public String posterUrl;

    @SerializedName("filmLength")
    public String filmLength;

    @SerializedName("rating")
    public String rating;


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }



    public static class MovieResult {
        @SerializedName("films")
        public List<Movie> films;

        public List<Movie> getFilms() {
            return films;
        }

        public void setFilms(List<Movie> films) {
            this.films = films;
        }
    }
}
