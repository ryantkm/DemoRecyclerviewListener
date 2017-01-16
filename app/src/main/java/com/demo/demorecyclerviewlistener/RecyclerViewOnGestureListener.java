package com.demo.demorecyclerviewlistener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import static android.content.ContentValues.TAG;

public class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    private RecyclerView mRecyclerView;
    private Context mContext;

    public RecyclerViewOnGestureListener(Context context, RecyclerView recyclerView) {
        mContext = context;
        mRecyclerView = recyclerView;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return super.onSingleTapUp(e);
    }

    @Override
    public void onLongPress(MotionEvent e) {
        View childView = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
        int position = mRecyclerView.getChildAdapterPosition(childView);
        Log.i(TAG, "Long Press on position: " + position);
        super.onLongPress(e);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int SWIPE_DISTANCE_THRESHOLD = 100;
        int SWIPE_VELOCITY_THRESHOLD = 100;
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                }
            } else {
                if (Math.abs(diffY) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeDown();
                    } else {
                        onSwipeUp();
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    @Override
    public void onShowPress(MotionEvent e) {
        super.onShowPress(e);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return super.onDown(e);
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        View childView = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
        int position = mRecyclerView.getChildAdapterPosition(childView);
        Log.i(TAG, "Double Tap on position: " + position);
        return super.onDoubleTap(e);
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return super.onDoubleTapEvent(e);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        View childView = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
        int position = mRecyclerView.getChildAdapterPosition(childView);
        Log.i(TAG, "Single Click on position: " + position);
        return super.onSingleTapConfirmed(e);
    }

    @Override
    public boolean onContextClick(MotionEvent e) {
        return super.onContextClick(e);
    }

    // additional methods for onFling so that these methods can be customised for each recyclerview needs
    public void onSwipeDown() {
        Log.i(TAG, "Swipe Down");
    }

    public void onSwipeUp() {
        Log.i(TAG, "Swipe Up");
    }

    public void onSwipeLeft() {
        Log.i(TAG, "Swipe Left");
    }

    public void onSwipeRight() {
        Log.i(TAG, "Swipe Right");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}