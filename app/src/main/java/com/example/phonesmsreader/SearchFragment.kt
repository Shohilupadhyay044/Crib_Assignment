package com.example.phonesmsreader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnLaunchSecondFragment.setOnClickListener {


            val bundle = bundleOf("Phone" to etPhone.text.toString(),
                "Days" to etDays.text.toString())


            navController.navigate(R.id.action_searchFragment_to_fetchSmsFragment,bundle)

        }
    }
}