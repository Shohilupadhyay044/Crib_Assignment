package com.example.phonesmsreader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

class FetchSmsFragment : Fragment(R.layout.fragment_fetch_sms) {

    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        var phone = arguments?.getString("Phone")
        var numberOfDays = arguments?.getString("Days")
    }

}