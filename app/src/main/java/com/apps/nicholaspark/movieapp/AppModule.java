package com.apps.nicholaspark.movieapp;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nicholaspark on 10/9/16.
 */
@Module
public class AppModule {

    private Context mContext;

    AppModule(Context context){
        this.mContext = context;
    }

    @Provides
    Context providesContext(){
        return mContext;
    }

}
