package com.ubaya.ubayakuliner160419164.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.ubayakuliner160419164.R
import com.ubaya.ubayakuliner160419164.model.History
import com.ubaya.ubayakuliner160419164.model.Voucher
import com.ubaya.ubayakuliner160419164.util.loadImage
import kotlinx.android.synthetic.main.history_list_item.view.*
import kotlinx.android.synthetic.main.voucher_list_item.view.*

class VoucherAdapter (val voucherList: ArrayList<Voucher>): RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>() {
    class VoucherViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateVoucherList(newVoucherList: List<Voucher>){
        voucherList.clear()
        voucherList.addAll(newVoucherList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.voucher_list_item, parent, false )
        return VoucherViewHolder(v)
    }

    override fun onBindViewHolder(holder: VoucherViewHolder, position: Int) {
        holder.view.txtNamaVoucher.text = voucherList[position].nama
        holder.view.txtDesc.text = voucherList[position].desc

    }

    override fun getItemCount(): Int {
        return voucherList.size
    }
}