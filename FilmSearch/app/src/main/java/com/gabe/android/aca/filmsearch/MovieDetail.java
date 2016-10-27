package com.gabe.android.aca.filmsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {
     TextView mTitle;
    TextView mDescription;
    ImageView mBackdrop;
     Movie myMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);


        mTitle = (TextView) findViewById(R.id.title);
       mDescription= (TextView)findViewById(R.id.description);
        mBackdrop = (ImageView)findViewById(R.id.imageView2);


        Intent i = getIntent();
        myMovie = (Movie) i.getSerializableExtra("Movie");

        mTitle.setText(myMovie.getTitle());
        mDescription.setText(myMovie.getDescription());
        Picasso.with(this)
                .load(myMovie.getBackdrop())
                .placeholder(R.color.colorAccent)
                .into(mBackdrop);
    }

}
