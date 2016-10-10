package com.apps.nicholaspark.movieapp.MovieData.Remote;

import android.support.annotation.NonNull;

import com.apps.nicholaspark.movieapp.MovieData.Movie;
import com.apps.nicholaspark.movieapp.MovieData.MovieDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nicholaspark on 10/8/16.
 */

public class MoviesRemoteDataSource implements MovieDataSource {

    private MoviesApiService apiService;

    private static final String SCHEME = "https";
    private static final String AUTHORITY = "api.themoviedb.org";
    private static final String SEARCH_PATH = "search";
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "233b079d26e4a9a38a4db60a7880703e";
    private static final String API_SECRET = "233b079d26e4a9a38a4db60a7880703e";
    private static final String KEY_SORT = "sort_by";
    private static final String KEY_POPULARITY_DESC = "popularity.desc";
    private static final String KEY_PAGE = "page";
    private static final String KEY_RELEASE_YEAR = "primary_release_year";


    @Inject
    public MoviesRemoteDataSource(MoviesApiService apiService){
        this.apiService = apiService;
    }


    @Override
    public Observable<List<Movie>> getMovies(String page, String year) {

        Map<String,String> params = new HashMap<>();
        params.put("api_key",API_KEY);
        params.put("api_secret",API_SECRET);
        params.put("query","");
        params.put("page",page);
        params.put(KEY_RELEASE_YEAR,year);
        return apiService.getMovies(params);
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

    }

}
