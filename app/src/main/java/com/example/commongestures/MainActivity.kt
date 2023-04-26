package com.example.commongestures

import android.app.Activity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import kotlin.math.abs

class MainActivity : Activity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private lateinit var mDetector: GestureDetectorCompat

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDetector = GestureDetectorCompat(this, this)
        mDetector.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    override fun onDown(event: MotionEvent): Boolean {
        Toast.makeText(applicationContext, "OnDown event", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onFling(
        event1: MotionEvent,
        event2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        Toast.makeText(applicationContext, "onFling event", Toast.LENGTH_SHORT).show()

        try {
            val swipeThreshold = 100
            val swipeVelocityThreshold = 100
            val diffY = event2.y - event1.y
            val diffX = event2.x - event1.x
            if (abs(diffX) > abs(diffY)) {
                if (abs(diffX) > swipeThreshold && abs(velocityX) > swipeVelocityThreshold) {
                    if (diffX > 0) {
                        Toast.makeText(applicationContext, "Left to Right swipe gesture", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(applicationContext, "Right to Left swipe gesture", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            if (abs(diffY) > abs(diffX)) {
                if (abs(diffY) > swipeThreshold && abs(velocityY) > swipeVelocityThreshold) {
                    if (diffY > 0) {
                        Toast.makeText(applicationContext, "Top Down swipe gesture", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(applicationContext, "Bottom Up swipe gesture", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        catch (exception: Exception) {
            exception.printStackTrace()
        }
        return true

    }

    override fun onScroll(
        event1: MotionEvent,
        event2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        //  Toast.makeText(this, "OnScroll event", Toast.LENGTH_SHORT).show()

        return true
    }

    override fun onLongPress(event: MotionEvent) {
        Toast.makeText(this, "OnLongPress event", Toast.LENGTH_SHORT).show()

    }

    override fun onShowPress(event: MotionEvent) {
        Toast.makeText(this, "OnShowPress event", Toast.LENGTH_SHORT).show()

    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        Toast.makeText(this, "OnSingleTap event", Toast.LENGTH_SHORT).show()

        return true
    }

    override fun onDoubleTap(event: MotionEvent): Boolean {
        Toast.makeText(this, "OnDoubleTap event", Toast.LENGTH_SHORT).show()

        return true
    }

    override fun onDoubleTapEvent(event: MotionEvent): Boolean {
        Toast.makeText(this, "onDoubleTap with motion event", Toast.LENGTH_SHORT).show()

        return true
    }

    override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
        Toast.makeText(this, "onSingleTapConfirmed event", Toast.LENGTH_SHORT).show()
        return true
    }

}

