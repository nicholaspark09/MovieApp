package com.apps.nicholaspark.movieapp.MoviesIndex;

import android.support.annotation.NonNull;
import android.util.Log;

import com.apps.nicholaspark.movieapp.MovieData.Movie;
import com.apps.nicholaspark.movieapp.MovieData.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nicholaspark on 10/9/16.
 */

final class MoviesPresenter implements MoviesContract.Presenter {

    private static final String TAG = MoviesPresenter.class.getSimpleName();
    private final MoviesContract.View mView;
    private final MoviesRepository moviesRepository;

    @Inject
    MoviesPresenter(MoviesRepository moviesRepository, MoviesContract.View view){
        this.moviesRepository = moviesRepository;
        this.mView = view;
    }

    @Inject
    void setupListeners(){
        mView.setPresenter(this);
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadMovies(boolean forceUpdate) {
        moviesRepository.getMovies("1","2016")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Movie>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG,"Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"Error: "+e.getMessage());
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        Log.d(TAG,"Movies: "+movies.size());

                        mView.showMovies(movies);
                    }
                });
    }

    @Override
    public void openMovieDetails(@NonNull Movie movie) {

    }

    @Override
    public void clearMovies() {

    }

    @Override
    public void start() {
        loadMovies(true);
    }
}
