package com.ubaya.ubayakuliner160419164.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.ubayakuliner160419164.R
import kotlinx.android.synthetic.main.fragment_detail_list_kuliner.*
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonVoucher.setOnClickListener(){
            val action= ProfileFragmentDirections.actionVoucherFragment()
            Navigation.findNavController(it).navigate(action)
        }

        buttonHelp.setOnClickListener(){
            val action = ProfileFragmentDirections.actionHelpFragment()
            Navigation.findNavController(it).navigate(action)
        }

        buttonPembayaran.setOnClickListener(){
            val action = ProfileFragmentDirections.actionPayFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}