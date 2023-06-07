package com.example.moviemaster;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.moviemaster.Retrofit.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MainScreen.MovieViewHolder>{
    private List<Movie> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;

    private MovieRecyclerInterface recyclerInterface;

    public MoviesAdapter(Context context, MovieRecyclerInterface recyclerInterface)
    {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMovieList = new ArrayList<>();
        this.recyclerInterface = recyclerInterface;
    }

    @Override
    public MainScreen.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(R.layout.main_screen_recycler, parent, false);
        MainScreen.MovieViewHolder viewHolder = new MainScreen.MovieViewHolder(view, recyclerInterface);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainScreen.MovieViewHolder holder, int position)
    {
        Movie movie = mMovieList.get(position);

        Picasso.get().load(movie.getPosterUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount()
    {
        return (mMovieList == null) ? 0 : mMovieList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public List<Movie> setMovieList(List<Movie> movieList)
    {
        this.mMovieList.clear();
        this.mMovieList.addAll(movieList);
        // The adapter needs to know that the data has changed. If we don't call this, app will crash.
        notifyDataSetChanged();

        return mMovieList;
    }

}
