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
import com.ubaya.ubayakuliner160419164.viewmodel.ListViewHistory
import com.ubaya.ubayakuliner160419164.viewmodel.ListViewReview
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_review.*

class HistoryFragment : Fragment() {
    private lateinit var viewHistory: ListViewHistory
    private val historyAdapter = HistoryAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewHistory = ViewModelProvider(this).get(ListViewHistory::class.java)
        viewHistory.refresh()

        recViewHistory.layoutManager = LinearLayoutManager(context)
        recViewHistory.adapter = historyAdapter

        observeViewReview()
    }
    fun observeViewReview(){
        viewHistory.historyLD.observe(viewLifecycleOwner, Observer {
            historyAdapter.updateHistoryList(it)
        })
    }
}