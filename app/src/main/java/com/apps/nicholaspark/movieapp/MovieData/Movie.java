package com.apps.nicholaspark.movieapp.MovieData;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 8/20/2016.
 */
public class Movie implements Parcelable{
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("overview")
    String overview;
    @SerializedName("original_title")
    String original_title;
    @SerializedName("poster_path")
    String poster_path;
    @SerializedName("vote_average")
    float vote_average;
    @SerializedName("popularity")
    float popularity;
    @SerializedName("release_date")
    String release_date;
    @SerializedName("vote_count")
    int vote_count;
    @SerializedName("original_language")
    String original_language;

    public Movie(){
        this.id = -1;
    }


    public Movie(int id, String title, String overview, String original_title, String poster_path, float vote_average){
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.original_title = original_title;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
    }

    public Movie(Parcel in) {

        this.id = in.readInt();
        this.title = in.readString();
        this.overview = in.readString();
        this.vote_average = in.readFloat();
        this.poster_path = in.readString();
        this.original_title = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeFloat(vote_average);
        parcel.writeString(poster_path);
        parcel.writeString(original_title);
    }



 
}
