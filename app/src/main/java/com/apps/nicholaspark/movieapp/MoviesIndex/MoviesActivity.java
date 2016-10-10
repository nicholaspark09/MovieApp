package com.apps.nicholaspark.movieapp.MoviesIndex;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apps.nicholaspark.movieapp.MovieApp;
import com.apps.nicholaspark.movieapp.R;

import javax.inject.Inject;

public class MoviesActivity extends AppCompatActivity implements MoviesIndexFragment.OnFragmentInteractionListener{

    //Absolutely need to inject the presenter
    //Dagger will set it later into the view
    @Inject
    MoviesPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        MoviesIndexFragment fragment = MoviesIndexFragment.newInstance("","");
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,fragment).commit();
        DaggerMoviesComponent.builder()
                .moviesRepositoryComponent(((MovieApp) getApplication()).getmMoviesRepositoriesComponent())
                .moviesPresenterModule(new MoviesPresenterModule(fragment))
                .build()
                .inject(this);
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
