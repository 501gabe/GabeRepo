package com.gabe.android.aca.filmsearch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.gabe.android.aca.filmsearch.R.id.recyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MoviesAdapter mAdapter;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

/////////////////Recyclerview
        mRecyclerView = (RecyclerView) findViewById(recyclerView);





        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        mAdapter = new MoviesAdapter(this);////////ADAPTER
        mRecyclerView.setAdapter(mAdapter);


        List<Movie> movies = new ArrayList<>(); //Dummy list

        for (int i = 0; i < 26; i++) {
            movies.add(new Movie());
        }
        mAdapter.setMovieList(movies);

        Retrofit restAdapter = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.themoviedb.org/")
                .build();

        MoviesApiService apiService = restAdapter.create(MoviesApiService.class);

        Call<Movie.MovieResult> call = apiService.getPopularMovies();
        call.enqueue(new Callback<Movie.MovieResult>() {
            @Override
            public void onResponse(Call<Movie.MovieResult> call, Response<Movie.MovieResult> response) {
                mAdapter.setMovieList(response.body().getResults());
            }

            @Override
            public void onFailure(Call<Movie.MovieResult> call, Throwable t) {
                t.printStackTrace();
            }
        });



        mRecyclerView.addOnItemTouchListener(
                new MovieItemClickListener(context, mRecyclerView, new MovieItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent M = new Intent(getApplicationContext(), MovieDetail.class);
                        M.putExtra("Movie",mAdapter.getMovieList().get(position));
                        startActivity(M);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        getTitle();
                    }
                }));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
