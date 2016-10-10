package com.apps.nicholaspark.movieapp.MovieData.Remote;

import android.content.Context;

import com.apps.nicholaspark.movieapp.MovieData.Movie;
import com.apps.nicholaspark.movieapp.MovieData.MovieDataSource;

import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by nicholaspark on 10/8/16.
 */

public interface MoviesApiService{

    String ENDPOINT = "https://api.themoviedb.org";

    @GET("discover/movie")
    Observable<List<Movie>> getMovies(@QueryMap Map<String,String> options);

    @GET("movie/{id}")
    Observable<Movie> getMovie(@Path("id") int movieId);



    class CreatorFactory{
         public static MoviesApiService makeMoviesApiService(Context context){

             Retrofit retrofit = new Retrofit.Builder()
                     .baseUrl(MoviesApiService.ENDPOINT)
                     .addConverterFactory(GsonConverterFactory.create())
                     .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                     .build();

            return retrofit.create(MoviesApiService.class);
         }
    }
}
