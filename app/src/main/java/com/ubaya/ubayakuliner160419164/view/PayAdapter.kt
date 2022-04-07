package com.ubaya.ubayakuliner160419164.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.ubayakuliner160419164.R
import com.ubaya.ubayakuliner160419164.model.Pay
import kotlinx.android.synthetic.main.help_list_item.view.*
import kotlinx.android.synthetic.main.pay_list_item.view.*

class PayAdapter (val payList: ArrayList<Pay>): RecyclerView.Adapter<PayAdapter.PayViewHolder>() {
    class PayViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updatePayList(newPayList: List<Pay>){
        payList.clear()
        payList.addAll(newPayList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.pay_list_item, parent, false )
        return PayViewHolder(v)
    }

    override fun onBindViewHolder(holder: PayViewHolder, position: Int) {
        holder.view.txtNamaPay.text = payList[position].nama
        holder.view.txtDescPay.text = payList[position].desc

    }

    override fun getItemCount(): Int {
        return payList.size
    }
}