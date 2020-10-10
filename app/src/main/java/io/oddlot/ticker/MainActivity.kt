package io.oddlot.ticker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ttv = findViewById<TickerTapeView>(R.id.tickerTape)
        ttv.adapter = TickerItemAdapter(
            listOf(
                StockTicker("TSLA", 10.4f),
                StockTicker("TSLA", 2.7f), StockTicker("AAPL", 4.1f), StockTicker("TSLA", 2.7f), StockTicker("AAPL", 4.1f)
            )
        )
        ttv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false).also {
//            val smoothScroller = LinearSmoothScroller(this) {
//                override fun getVerticalSnapPreference(): Int {
//                    return SNAP_TO_END
//                }
//            }
//            it.startSmoothScroll(smoothScroller)
        }
    }
}