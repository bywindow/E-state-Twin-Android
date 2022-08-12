package com.idiot.e_state_twin_android.core.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.core.adapters.UserRecommendAdapter
import com.idiot.e_state_twin_android.core.data.assets.RecommendedHousesSample
import com.idiot.e_state_twin_android.core.viewmodels.UserViewModel
import com.idiot.e_state_twin_android.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_more, container,false
        )

        subscribeUi(binding)
        navigateTo()

        return binding.root
    }

    private fun subscribeUi(binding: FragmentMoreBinding) {
        binding.toolbarMore.toolbarTitleText.text = "더보기"
        binding.userNameTextView.text = "홍길동"
        binding.userRoleTextView.text = "기업회원"
    }

    // TODO: Add another tab button clickListener
    private fun navigateTo() {
        binding.register.setClickListener {
            val directions = MoreFragmentDirections.actionMoreFragmentToRegisterForBrokerFragment()
            it.findNavController().navigate(directions)
        }
    }
}