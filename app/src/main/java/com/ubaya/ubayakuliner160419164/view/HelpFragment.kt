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
import com.ubaya.ubayakuliner160419164.viewmodel.ListViewHelp
import com.ubaya.ubayakuliner160419164.viewmodel.ListViewVoucher
import kotlinx.android.synthetic.main.fragment_help.*
import kotlinx.android.synthetic.main.fragment_voucher.*

class HelpFragment : Fragment() {
    private lateinit var viewHelp: ListViewHelp
    private val helpAdapter = HelpAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewHelp = ViewModelProvider(this).get(ListViewHelp::class.java)
        viewHelp.refresh()

        recViewHelp.layoutManager = LinearLayoutManager(context)
        recViewHelp.adapter = helpAdapter

        observeViewHelp()
    }
    fun observeViewHelp(){
          viewHelp.helpLD.observe(viewLifecycleOwner, Observer {
              helpAdapter.updateHelpList(it)
          })

    }
}