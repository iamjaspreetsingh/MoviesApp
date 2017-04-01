package com.example.jasmeetsingh.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jasmeetsingh on 30/03/17.
 */

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.MoviesViewHolder>
{
    Context context;
    ArrayList<MoviesDetails> arrayList;

    PopularMoviesAdapter(Context context,ArrayList<MoviesDetails> arrayList){
        super();
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_movies_details,parent,false);
        MoviesViewHolder moviesViewHolder = new MoviesViewHolder(view);
        return moviesViewHolder;
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        MoviesDetails moviesDetails = arrayList.get(position);
        holder.releasingDate.setText(moviesDetails.getReleaseDate());
        holder.rating.setText(moviesDetails.getVoteAverage().toString());
        holder.movieName.setText(moviesDetails.getOriginalTitle());
        StringBuilder genresString = new StringBuilder();
        for(int i =0 ;i<moviesDetails.getGenreIds().size()-1;i++) {
            genresString.append( Genres.getHashMap().get(moviesDetails.getGenreIds().get(i))+",");
        }

        Log.i("abcc",genresString.toString());

        Log.e("jj",Genres.getHashMap().get(14));
       // Log.d("aaa",moviesDetails.getGenreIds().get(1).toString());
       // Log.i("abbb",Genres.hashMap.get(moviesDetails.getGenreIds().get(1)).toString());
        genresString.append(Genres.hashMap.get(moviesDetails.getGenreIds().get(moviesDetails.getGenreIds().size()-1)));
        holder.genres.setText(genresString.toString());
        Picasso.with(context).load("http://image.tmdb.org/t/p/w185"+ moviesDetails.getPosterPath()).into(holder.movieImage);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder{
        TextView movieName;
        ImageView movieImage;
        TextView rating;
        TextView releasingDate;
        TextView genres;
         public MoviesViewHolder(View itemView){
             super(itemView);
             movieImage = (ImageView) itemView.findViewById(R.id.imageView);
             movieName = (TextView) itemView.findViewById(R.id.movieName);
             rating = (TextView) itemView.findViewById(R.id.rate);
             releasingDate = (TextView) itemView.findViewById(R.id.date);
             genres = (TextView) itemView.findViewById(R.id.overView);
         }
    }
}
