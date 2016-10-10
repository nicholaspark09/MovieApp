package com.apps.nicholaspark.movieapp.MovieData;

import android.support.annotation.NonNull;
import android.util.Log;

import com.apps.nicholaspark.movieapp.MovieData.Local.Local;
import com.apps.nicholaspark.movieapp.MovieData.Remote.Remote;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nicholaspark on 10/9/16.
 */
@Singleton
public class MoviesRepository implements MovieDataSource{

    private static final String TAG = MoviesRepository.class.getSimpleName();
    private final MovieDataSource localDataSource;
    private final MovieDataSource remoteDataSource;
    private boolean cacheIsDirty = false;

    //Keep a local cache
    List<Movie> cachedMovies;

    @Inject
    MoviesRepository(@Local @Named("localDataSource") MovieDataSource localDataSource, @Remote @Named("remoteDataSource") MovieDataSource remoteDataSource){
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }


    @Override
    public Observable<List<Movie>> getMovies(String page, String year) {
        if(cachedMovies != null && !cacheIsDirty){

        }

        if(cacheIsDirty)
            return remoteDataSource.getMovies(page,year);
        else{

        }
        return null;
    }

    @Override
    public Observable<Movie> getMovie(@NonNull int movieId) {
        return null;
    }

    @Override
    public void deleteMovie(@NonNull int movieId) {

    }

    @Override
    public void deleteAllMovies() {

    }

    @Override
    public void refreshMovies() {
        cacheIsDirty = true;
    }
}
