package io.oddlot.ticker

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

class TickerTapeView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : RecyclerView(context, attrs) {
    val TAG = this::class.java.simpleName

    override fun onDraw(c: Canvas?) {
        Log.d(TAG, "drawing")
        Log.d(TAG, "X: $scrollX, Y: $scrollY") // TickerTapeView: X: 0, Y: 0
        super.onDraw(c)

        smoothScrollToPosition(10000)
    }
}