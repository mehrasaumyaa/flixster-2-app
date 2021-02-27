package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String posterPath;
    String overview;
    String title;

    /*exception is thrown in case the given strings are not present
    whoever is calling this method is responsible for dealing with the exception, unlike try/catch
    where we deal with the exception on the go */
    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }

    //iterating JSONArray and creating a Movie for each element
    public static List<Movie> fromJSONArray(JSONArray moviesJSONArray)throws JSONException{
        List<Movie> movies = new ArrayList<>();
        for(int i=0;i<moviesJSONArray.length();i++){
            movies.add(new Movie(moviesJSONArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        //q: accessing image sizes
        //return posterPath; --> will only return relative path stored in results, hence we need full URL
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getOverview() {
        return overview;
    }

    public String getTitle() {
        return title;
    }
}
