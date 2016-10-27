package com.gabe.android.aca.filmsearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Gabe on 10/20/16.
 */

public class MovieItemClickListener implements RecyclerView.OnItemTouchListener{


    private OnItemClickListener Movielistener;


    public interface OnItemClickListener {
        public void onItemClick(View view, int position);

        public void onLongItemClick(View view, int position);
    }

    GestureDetector PosterGestureDetector;

    public MovieItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
        Movielistener = listener;
        PosterGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent g) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent g) {
                View child = recyclerView.findChildViewUnder(g.getX(), g.getY());
                if (child != null && Movielistener != null) {
                    Movielistener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        });
    }

    @Override public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && Movielistener != null && PosterGestureDetector.onTouchEvent(e)) {
            Movielistener.onItemClick(childView, view.getChildAdapterPosition(childView));
            return true;
        }
        return false;
    }

    @Override public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }

    @Override
    public void onRequestDisallowInterceptTouchEvent (boolean disallowIntercept){}
}

