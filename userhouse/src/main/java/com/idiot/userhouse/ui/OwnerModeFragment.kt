package com.idiot.userhouse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.FragmentOwnerModeBinding
import com.idiot.data.repository.samples.OwnerHouseSample

class OwnerModeFragment : Fragment() {

    private lateinit var binding: FragmentOwnerModeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_owner_mode, container,false
        )
        binding.ownerHouseList.adapter = OwnerHouseAdapter(OwnerHouseSample())
        return binding.root
    }

}