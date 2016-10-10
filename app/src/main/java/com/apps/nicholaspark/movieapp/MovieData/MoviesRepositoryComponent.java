package com.apps.nicholaspark.movieapp.MovieData;

import com.apps.nicholaspark.movieapp.AppModule;
import com.apps.nicholaspark.movieapp.Modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nicholaspark on 10/10/16.
 */
@Singleton
@Component(modules = {MoviesRepositoryModule.class, AppModule.class, NetworkModule.class})
public interface MoviesRepositoryComponent {

    MoviesRepository getMoviesRepository();
}
