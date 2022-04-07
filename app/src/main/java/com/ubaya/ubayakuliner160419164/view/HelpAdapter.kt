package com.ubaya.ubayakuliner160419164.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.ubayakuliner160419164.R
import com.ubaya.ubayakuliner160419164.model.Help
import kotlinx.android.synthetic.main.help_list_item.view.*


class HelpAdapter (val helpList: ArrayList<Help>): RecyclerView.Adapter<HelpAdapter.HelpViewHolder>() {
    class HelpViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateHelpList(newHelpList: List<Help>){
        helpList.clear()
        helpList.addAll(newHelpList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.help_list_item, parent, false )
        return HelpViewHolder(v)
    }

    override fun onBindViewHolder(holder: HelpViewHolder, position: Int) {
        holder.view.txtNamaHelp.text = helpList[position].nama
        holder.view.txtTny.text = helpList[position].tny
        holder.view.txtJwb.text = helpList[position].jwb

    }

    override fun getItemCount(): Int {
        return helpList.size
    }
}