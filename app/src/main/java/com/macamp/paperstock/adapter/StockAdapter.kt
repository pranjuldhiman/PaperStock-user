package com.macamp.paperstock.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.macamp.paperstock.databinding.StocksListBinding

class StockAdapter(
    var context: Context,
    private var hashMap: LinkedHashMap<String,String>,
    /*: ArrayList<ConvertedBidAskData>*/
    /*: HashMap<String, String>*/
//private  var

) :
    RecyclerView.Adapter<StockAdapter.RecyclerHolder>() {
    private lateinit var binding: StocksListBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        binding = StocksListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
//        var socketData =BidAskData()


//        val socketData = hashMap[position]
//        holder.bind(socketData)
    }

    class RecyclerHolder(var item: StocksListBinding) : RecyclerView.ViewHolder(item.root) {
//        fun bind(socketData: BidAskData?) {
//            socketData?.let {
//                item.stockName.text = socketData./*bidAskData.*/bidask[0]
//                item.buyStockTxt.text = socketData./*bidAskData.*/bidask[2]
//                item.sellStockTxt.text = socketData./*bidAskData.*/bidask[4]
//            }
//        }
    }

    override fun getItemCount() = hashMap.size
}