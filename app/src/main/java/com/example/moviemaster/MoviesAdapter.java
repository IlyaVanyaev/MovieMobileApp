package com.example.moviemaster;

import android.annotation.SuppressLint;
import android.content.Context;
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

    public MoviesAdapter(Context context)
    {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMovieList = new ArrayList<>();
    }

    @Override
    public MainScreen.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(R.layout.main_screen_recycler, parent, false);
        MainScreen.MovieViewHolder viewHolder = new MainScreen.MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainScreen.MovieViewHolder holder, int position)
    {
        Movie movie = mMovieList.get(position);

        // This is how we use Picasso to load images from the internet.
        Picasso.get().load(movie.getPosterUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount()
    {
        return (mMovieList == null) ? 0 : mMovieList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setMovieList(List<Movie> movieList)
    {
        this.mMovieList.clear();
        this.mMovieList.addAll(movieList);
        // The adapter needs to know that the data has changed. If we don't call this, app will crash.
        notifyDataSetChanged();
    }

}
