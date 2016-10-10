package com.apps.nicholaspark.movieapp.MovieData.Local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by nicholaspark on 10/8/16.
 */
@Singleton
public class MovieDatabase extends SQLiteOpenHelper {

    private static final String DB_NAME = "findovie.db";
    private static final int DB_VERSION = 1;
    private static final String SQL_ENTRIES =
            "CREATE TABLE "+MoviesPersistenceContract.MovieEntry.TABLE_NAME+"("
            +MoviesPersistenceContract.MovieEntry.COLUMN_NAME_ID+" integer primary key,"
            +MoviesPersistenceContract.MovieEntry.COLUMN_NAME_TITLE+" text default null,"
            +MoviesPersistenceContract.MovieEntry.COLUMN_NAME_OVERVIEW+" text default null,"
            +MoviesPersistenceContract.MovieEntry.COLUMN_NAME_AVERAGE+" float default null,"
            +MoviesPersistenceContract.MovieEntry.COLUMN_NAME_POSTER_PATH+" text default null,"
            +MoviesPersistenceContract.MovieEntry.COLUMN_NAME_POPULARITY+" float default null,"
            +MoviesPersistenceContract.MovieEntry.COLUMN_NAME_ORIGINAL_TITLE+" text default null,"
            +MoviesPersistenceContract.MovieEntry.COLUMN_NAME_RELEASE_DATE+" text default null,"
            +MoviesPersistenceContract.MovieEntry.COLUMN_NAME_VOTE_COUNT+" integer default null)";

    @Inject
    public MovieDatabase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+MoviesPersistenceContract.MovieEntry.TABLE_NAME);
        onCreate(db);
    }
}
