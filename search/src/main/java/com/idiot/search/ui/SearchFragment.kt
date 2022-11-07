package com.idiot.search.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.findNavController
import com.idiot.search.R
import timber.log.Timber

class SearchFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    Timber.d("SEARCH : ${findNavController().currentBackStackEntry?.destination}")
    return inflater.inflate(R.layout.fragment_search, container, false)
  }

}