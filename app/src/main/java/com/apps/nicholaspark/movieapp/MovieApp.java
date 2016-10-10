package com.apps.nicholaspark.movieapp;

import android.app.Application;


import com.apps.nicholaspark.movieapp.Modules.NetworkModule;
import com.apps.nicholaspark.movieapp.MovieData.DaggerMoviesRepositoryComponent;
import com.apps.nicholaspark.movieapp.MovieData.MoviesRepositoryComponent;
import com.apps.nicholaspark.movieapp.MovieData.MoviesRepositoryModule;

/**
 * Created by nicholaspark on 10/9/16.
 */

public class MovieApp extends Application {

    private MoviesRepositoryComponent mMoviesRepositoriesComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mMoviesRepositoriesComponent = DaggerMoviesRepositoryComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .moviesRepositoryModule(new MoviesRepositoryModule())
                .build();

    }

    public MoviesRepositoryComponent getmMoviesRepositoriesComponent(){
        return mMoviesRepositoriesComponent;
    }
}
