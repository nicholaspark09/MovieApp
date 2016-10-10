package com.apps.nicholaspark.movieapp.MoviesIndex;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.nicholaspark.movieapp.MovieData.Movie;
import com.apps.nicholaspark.movieapp.MovieData.MoviesRepository;
import com.apps.nicholaspark.movieapp.R;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MoviesIndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MoviesIndexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoviesIndexFragment extends Fragment implements MoviesContract.View{


    private MoviesContract.Presenter mPresenter;


    private OnFragmentInteractionListener mListener;

    public MoviesIndexFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoviesIndexFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoviesIndexFragment newInstance(String param1, String param2) {
        MoviesIndexFragment fragment = new MoviesIndexFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_index, container, false);



        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showMovies(@NonNull List<Movie> movies) {

    }

    @Override
    public void showMovieDetails(@NonNull int movieId) {

    }

    @Override
    public void showNoMovies() {

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(@NonNull MoviesContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
