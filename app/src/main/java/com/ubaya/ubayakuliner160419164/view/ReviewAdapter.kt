package com.ubaya.ubayakuliner160419164.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.ubayakuliner160419164.R
import com.ubaya.ubayakuliner160419164.model.Review
import kotlinx.android.synthetic.main.review_list_item.view.*

class ReviewAdapter(val reviewList: ArrayList<Review>):RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
   class ReviewViewHolder(var resView: View) : RecyclerView.ViewHolder(resView)

    fun updateReviewList(newReviewList: List<Review>){
        reviewList.clear()
        reviewList.addAll(newReviewList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rv = inflater.inflate(R.layout.review_list_item, parent, false )
        return ReviewViewHolder(rv)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.resView.textNamaRev.text = reviewList[position].nama
        holder.resView.textReview.text = reviewList[position].review
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }
}