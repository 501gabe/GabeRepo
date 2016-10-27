package com.gabe.android.aca.filmsearch;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Gabe on 10/17/16.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder
{
    public ImageView imageView;


    public MovieViewHolder(View itemView)
    {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);


    }

}
