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
import kotlinx.android.synthetic.main.fragment_list_kuliner.*
import kotlinx.android.synthetic.main.kuliner_list_item.*

class ListKulinerFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val listKulinerAdapter = ListKulinerAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_kuliner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = listKulinerAdapter

        observeViewModel()

    }
    fun observeViewModel(){
        viewModel.kulinerLD.observe(viewLifecycleOwner, Observer {
           listKulinerAdapter.updateKulinerList(it)
        })
    }
}



