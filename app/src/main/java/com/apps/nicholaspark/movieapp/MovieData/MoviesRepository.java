package com.apps.nicholaspark.movieapp.MovieData;

import android.support.annotation.NonNull;
import android.util.Log;

import com.apps.nicholaspark.movieapp.MovieData.Local.Local;
import com.apps.nicholaspark.movieapp.MovieData.Remote.Remote;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by nicholaspark on 10/9/16.
 */
@Singleton
public class MoviesRepository implements MovieDataSource{

    private static final String TAG = MoviesRepository.class.getSimpleName();
    private final MovieDataSource localDataSource;
    private final MovieDataSource remoteDataSource;

    @Inject
    MoviesRepository(@Local @Named("localDataSource") MovieDataSource localDataSource, @Remote @Named("remoteDataSource") MovieDataSource remoteDataSource){
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Movie>> getMovies(String page, String year) {


        //Get from the local db first, then start an intent service to get data from the server
        Log.d(TAG,"MoviesRepository get movies called");
        //Call the sync method just to test it out
        //return localDataSource.getMovies();
        return remoteDataSource.getMovies(page,year);
    }

    @Override
    public Observable<Movie> getMovie() {
        return null;
    }

    @Override
    public void deleteMovie(@NonNull int movieId) {

    }

    @Override
    public void deleteAllMovies() {

    }
}
