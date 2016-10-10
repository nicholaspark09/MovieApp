package com.apps.nicholaspark.movieapp.MoviesIndex;

//import com.apps.nicholaspark.movieapp.MainActivity;
import com.apps.nicholaspark.movieapp.MovieData.MoviesRepositoryComponent;
import com.apps.nicholaspark.movieapp.Utils.FragmentScoped;

import dagger.Component;

/**
 * Created by nicholaspark on 10/10/16.
 */
@FragmentScoped
@Component(dependencies = MoviesRepositoryComponent.class,modules = {MoviesPresenterModule.class})
public interface MoviesComponent {

    void inject(MoviesActivity activity);
}
