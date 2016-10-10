package com.apps.nicholaspark.movieapp.MovieData.Local;

import android.provider.BaseColumns;

/**
 * Created by nicholaspark on 10/8/16.
 */

public final class MoviesPersistenceContract {

    //So that no one accidentally instantiates this class
    private MoviesPersistenceContract(){}

    public static abstract class MovieEntry implements BaseColumns{
        public static final String TABLE_NAME = "movies";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_OVERVIEW = "overview";
        public static final String COLUMN_NAME_AVERAGE = "vote_average";
        public static final String COLUMN_NAME_POSTER_PATH = "poster_path";
        public static final String COLUMN_NAME_POPULARITY = "popularity";
        public static final String COLUMN_NAME_ORIGINAL_TITLE = "original_title";
        public static final String COLUMN_NAME_RELEASE_DATE = "release_date";
        public static final String COLUMN_NAME_VOTE_COUNT = "vote_count";
    }
}
