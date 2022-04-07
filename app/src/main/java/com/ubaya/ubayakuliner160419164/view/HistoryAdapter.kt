package com.ubaya.ubayakuliner160419164.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.ubayakuliner160419164.R
import com.ubaya.ubayakuliner160419164.model.History
import com.ubaya.ubayakuliner160419164.model.Review
import com.ubaya.ubayakuliner160419164.util.loadImage
import kotlinx.android.synthetic.main.fragment_detail_list_kuliner.*
import kotlinx.android.synthetic.main.history_list_item.view.*
import kotlinx.android.synthetic.main.kuliner_list_item.view.*
import kotlinx.android.synthetic.main.review_list_item.view.*
import kotlinx.android.synthetic.main.review_list_item.view.imageView

class HistoryAdapter(val historyList: ArrayList<History>): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    class HistoryViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateHistoryList(newHistoryList: List<History>){
        historyList.clear()
        historyList.addAll(newHistoryList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.history_list_item, parent, false )
        return HistoryViewHolder(v)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.view.txtNamaMakanan.text = historyList[position].nama
        holder.view.txtHarga.text = historyList[position].harga
        holder.view.txtRestoran.text = historyList[position].restoran
        holder.view.imgView.loadImage(historyList[position].photoUrl)
    }

    override fun getItemCount(): Int {
        return historyList.size
    }
}