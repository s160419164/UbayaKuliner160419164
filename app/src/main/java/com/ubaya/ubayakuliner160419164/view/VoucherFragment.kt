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
import com.ubaya.ubayakuliner160419164.viewmodel.ListViewVoucher
import kotlinx.android.synthetic.main.fragment_voucher.*

class VoucherFragment : Fragment() {
    private lateinit var viewVoucher: ListViewVoucher
    private val voucherAdapter = VoucherAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_voucher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewVoucher = ViewModelProvider(this).get(ListViewVoucher::class.java)
        viewVoucher.refresh()

        recViewVoucher.layoutManager = LinearLayoutManager(context)
        recViewVoucher.adapter = voucherAdapter

        observeViewReview()
    }
    fun observeViewReview(){
        viewVoucher.voucherLD.observe(viewLifecycleOwner, Observer {
            voucherAdapter.updateVoucherList(it)
        })
    }
}