package io.oddlot.ticker

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.widget.HorizontalScrollView
import androidx.appcompat.widget.LinearLayoutCompat

class TickerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null)
    : HorizontalScrollView(context, attrs) {
    private val TAG = this::class.java.simpleName

    private lateinit var tickerTape: LinearLayoutCompat

    private var scrollPos = 0
    private var scrollBounds = Rect()
    private var itemBounds = Rect()

    init {
        isHorizontalScrollBarEnabled = false
        setBackgroundColor(Color.YELLOW)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        this.smoothScrollBy(ScrollSpeed.FAST, 0)
        scrollPos += ScrollSpeed.FAST

        if (scrollPos > 2000) {
            Log.d(TAG, tickerTape.width.toString())
            Log.d(TAG, scrollPos.toString())
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        tickerTape.getChildAt(0).getHitRect(itemBounds)

        val tickerWidth = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        scrollBounds.set(scrollX, scrollY, scrollX + tickerWidth, scrollY + height)

        Log.d(TAG, scrollBounds.toString())
        Log.d(TAG, tickerWidth.toString())
        Log.d(TAG, height.toString())
        Log.d(TAG, heightMeasureSpec.toString())

        tickerTape = findViewById(R.id.tickerTape)
        tickerTape.minimumWidth = tickerWidth + itemBounds.width()
    }

    fun startScroll() {
        TODO()
    }
    fun stopScroll() {
        TODO()
    }
}

enum class ScrollState {
    ON, OFF
}

abstract class ScrollSpeed {
    companion object {
        val SLOW = 1
        val NORMAL= 2
        val FAST = 3
    }
}