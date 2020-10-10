package io.oddlot.ticker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_stock_ticker.view.*

class TickerItemAdapter (var tickerList: List<StockTicker>) : RecyclerView.Adapter<TickerItemViewHolder>() {
    val TAG = this::class.java.simpleName

    private lateinit var rvTickerTape: TickerTapeView

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TickerItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_stock_ticker, parent, false)

        return TickerItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TickerItemViewHolder, position: Int) {
        val staticPosition = if (position < tickerList.size) position else position % tickerList.size

        Log.d(TAG, "Item count: " + itemCount.toString())
        Log.d(TAG, "Position: " + position.toString())
        Log.d(TAG, "Static Position: " + staticPosition.toString())

        val symbol = tickerList[staticPosition].tickerSymbol
        holder.view.tickerSymbol.text = symbol
        holder.view.changeValue.text = tickerList[staticPosition].changeValue.toString()

        holder.view.setOnClickListener {
            Toast.makeText(holder.view.context, symbol, Toast.LENGTH_SHORT).show()

            rvTickerTape.stopScroll()
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        rvTickerTape = recyclerView as TickerTapeView
    }
}

class TickerItemViewHolder(val view: View): RecyclerView.ViewHolder(view)