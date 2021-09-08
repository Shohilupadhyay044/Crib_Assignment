package com.example.phonesmsreader

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Telephony
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.jar.Manifest

class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLaunchSecondFragment.setOnClickListener {


            navController = Navigation.findNavController(view)

            val bundle = bundleOf("id" to etPhone.text.toString(),
                    "days" to etDays.text.toString())

            navController.navigate(R.id.action_searchFragment_to_fetchSmsFragment,bundle)

        }
    }

}
           

