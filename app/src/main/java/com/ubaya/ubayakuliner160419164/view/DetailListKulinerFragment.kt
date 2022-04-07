package com.ubaya.ubayakuliner160419164.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.ubayakuliner160419164.R
import com.ubaya.ubayakuliner160419164.util.loadImage
import com.ubaya.ubayakuliner160419164.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_list_kuliner.*

class DetailListKulinerFragment : Fragment() {
    private lateinit var detailModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_list_kuliner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailModel.getKulinerID(DetailListKulinerFragmentArgs.fromBundle(requireArguments()).idKuliner)

        ObserveDetailModel()
        buttonBack.setOnClickListener {
            val action= DetailListKulinerFragmentDirections.actionItemHome()
            Navigation.findNavController(it).navigate(action)
        }

        buttonReview.setOnClickListener(){
            val action= DetailListKulinerFragmentDirections.actionReviewFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun ObserveDetailModel(){
        detailModel.kulinerLD.observe(viewLifecycleOwner,Observer{
            textNama.setText(it.nama)
            textDeskripsi.setText(it.deskripsi)
            textAlamat.setText(it.alamat)
            textTelepon.setText(it.telepon)
            imageView2.loadImage(it.url.toString())
        })
    }
}