package com.apps.nicholaspark.movieapp.MovieData;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;

/**
 * Created by nicholaspark on 10/8/16.
 */

public interface MovieDataSource {

    Observable<List<Movie>> getMovies(String page, String year);
    Observable<Movie> getMovie();



    void deleteMovie(@NonNull int movieId);
    void deleteAllMovies();
}
