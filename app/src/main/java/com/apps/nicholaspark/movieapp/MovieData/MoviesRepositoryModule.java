package com.apps.nicholaspark.movieapp.MovieData;

import android.app.Application;
import android.content.Context;

import com.apps.nicholaspark.movieapp.MovieData.Local.Local;
import com.apps.nicholaspark.movieapp.MovieData.Local.MovieDatabase;
import com.apps.nicholaspark.movieapp.MovieData.Local.MoviesLocalDataSource;
import com.apps.nicholaspark.movieapp.MovieData.Remote.MoviesApiService;
import com.apps.nicholaspark.movieapp.MovieData.Remote.MoviesRemoteDataSource;
import com.apps.nicholaspark.movieapp.MovieData.Remote.Remote;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by nicholaspark on 10/9/16.
 */
@Module
public class MoviesRepositoryModule {

    @Singleton
    @Provides
    MovieDatabase providesMovieDatabase(Context context){
        return new MovieDatabase(context);
    }

    @Provides
    @Singleton
    MoviesApiService providesMoviesApiService(Context context){
        return MoviesApiService.CreatorFactory.makeMoviesApiService(context);
    }


    @Singleton
    @Provides
    @Local
    @Named("localDataSource")
    MovieDataSource providesLocalDataSource(MovieDatabase db){
        return new MoviesLocalDataSource(db);
    }

    @Singleton
    @Provides
    @Remote
    @Named("remoteDataSource")
    MovieDataSource providesRemoteDataSource(MoviesApiService apiService){
        return new MoviesRemoteDataSource(apiService);
    }
}
