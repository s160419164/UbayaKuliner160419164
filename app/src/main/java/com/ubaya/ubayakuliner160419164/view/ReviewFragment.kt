package com.ubaya.ubayakuliner160419164.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.ubayakuliner160419164.R
import com.ubaya.ubayakuliner160419164.viewmodel.ListViewModel
import com.ubaya.ubayakuliner160419164.viewmodel.ListViewReview
import kotlinx.android.synthetic.main.fragment_list_kuliner.*
import kotlinx.android.synthetic.main.fragment_review.*

class ReviewFragment : Fragment() {
    private lateinit var viewReview:ListViewReview
    private val reviewAdapter = ReviewAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewReview = ViewModelProvider(this).get(ListViewReview::class.java)
        viewReview.refreshR()

        recViewR.layoutManager = LinearLayoutManager(context)
        recViewR.adapter = reviewAdapter

        observeViewReview()
    }
    fun observeViewReview(){
        viewReview.reviewLD.observe(viewLifecycleOwner, Observer {
            reviewAdapter.updateReviewList(it)
        })
    }
}