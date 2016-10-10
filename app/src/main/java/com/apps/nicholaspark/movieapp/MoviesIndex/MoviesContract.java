package com.apps.nicholaspark.movieapp.MoviesIndex;

import android.support.annotation.NonNull;

import com.apps.nicholaspark.movieapp.BasePresenter;
import com.apps.nicholaspark.movieapp.BaseView;
import com.apps.nicholaspark.movieapp.MovieData.Movie;

import java.util.List;

/**
 * Created by nicholaspark on 10/9/16.
 */

public interface MoviesContract {

    interface View extends BaseView<Presenter>{
        void showMovies(@NonNull List<Movie> movies);
        void showMovieDetails(@NonNull int movieId);
        void showNoMovies();
    }

    interface Presenter extends BasePresenter{
        void result(int requestCode,int resultCode);
        void loadMovies(boolean forceUpdate);
        void openMovieDetails(@NonNull Movie movie);
        void clearMovies();
    }
}
