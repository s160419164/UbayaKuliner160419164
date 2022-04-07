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
import com.ubaya.ubayakuliner160419164.viewmodel.ListViewPay
import kotlinx.android.synthetic.main.fragment_pay.*

class PayFragment : Fragment() {
    private lateinit var viewPay: ListViewPay
    private val payAdapter = PayAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pay, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPay = ViewModelProvider(this).get(ListViewPay::class.java)
        viewPay.refresh()

        recViewPay.layoutManager = LinearLayoutManager(context)
        recViewPay.adapter = payAdapter

        observeViewHelp()
    }
    fun observeViewHelp(){
        viewPay.payLD.observe(viewLifecycleOwner, Observer {
            payAdapter.updatePayList(it)
        })

    }
}