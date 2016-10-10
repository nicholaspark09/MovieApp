package com.apps.nicholaspark.movieapp.MoviesIndex;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nicholaspark on 10/10/16.
 */
@Module
public class MoviesPresenterModule {

    private final MoviesContract.View mView;

    public MoviesPresenterModule(MoviesContract.View view){
        mView = view;
    }

    @Provides
    MoviesContract.View providesMoviesContractView(){
        return mView;
    }
}
