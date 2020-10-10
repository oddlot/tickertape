package io.oddlot.ticker

data class StockTicker(var tickerSymbol: String, var changeValue: Float, var exchangeCode: String? = null) : BaseTicker(234)  {
}