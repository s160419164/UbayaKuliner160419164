package com.ubaya.ubayakuliner160419164.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.ubayakuliner160419164.R
import com.ubaya.ubayakuliner160419164.model.Kuliner
import com.ubaya.ubayakuliner160419164.util.loadImage
import kotlinx.android.synthetic.main.kuliner_list_item.view.*

class ListKulinerAdapter(val kulinerList: ArrayList<Kuliner>):RecyclerView.Adapter<ListKulinerAdapter.KulinerViewHolder>() {
    class KulinerViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateKulinerList(newKulinerList: List<Kuliner>){
        kulinerList.clear()
        kulinerList.addAll(newKulinerList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KulinerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.kuliner_list_item, parent, false )
        return KulinerViewHolder(v)
    }

    override fun onBindViewHolder(holder: KulinerViewHolder, position: Int) {
        holder.view.txtNama.text = kulinerList[position].nama
        holder.view.imageView.loadImage(kulinerList[position].url)

        holder.view.buttonDetail.setOnClickListener{
            var id: String = kulinerList[position].id.toString()
            var action = ListKulinerFragmentDirections.actionDetailKuliner(id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return kulinerList.size
    }
}