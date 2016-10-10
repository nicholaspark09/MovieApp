package com.apps.nicholaspark.movieapp.MovieData.Local;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.apps.nicholaspark.movieapp.MovieData.Movie;
import com.apps.nicholaspark.movieapp.MovieData.MovieDataSource;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by nicholaspark on 10/8/16.
 */
@Singleton
public class MoviesLocalDataSource implements MovieDataSource{


    private final BriteDatabase mDb;

    @Inject
    public MoviesLocalDataSource(MovieDatabase db){
        mDb = SqlBrite.create().wrapDatabaseHelper(db,Schedulers.io());
    }


    @Override
    public Observable<List<Movie>> getMovies(String page, String year) {
        return mDb.createQuery(MoviesPersistenceContract.MovieEntry.TABLE_NAME,"SELECT * FROM "+MoviesPersistenceContract.MovieEntry.TABLE_NAME)
                .mapToList(new Func1<Cursor, Movie>() {
                    @Override
                    public Movie call(Cursor cursor) {
                        Movie movie = new Movie();
                        movie.setId(cursor.getInt(cursor.getColumnIndexOrThrow(MoviesPersistenceContract.MovieEntry.COLUMN_NAME_ID)));
                        movie.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(MoviesPersistenceContract.MovieEntry.COLUMN_NAME_TITLE)));
                        return movie;
                    }
                });
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
