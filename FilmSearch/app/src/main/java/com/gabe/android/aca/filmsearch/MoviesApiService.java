package com.gabe.android.aca.filmsearch;

/**
 * Created by Gabe on 10/17/16.
 */

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApiService {

    @GET("/3/movie/popular?api_key=2455c8fe2f70107863adaac1aaa4c5a6")
    Call<Movie.MovieResult> getPopularMovies();


}
