package com.example.phonesmsreader

import android.content.ContentResolver
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.SimpleCursorAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_fetch_sms.*
import kotlinx.android.synthetic.main.row.*


class FetchSmsFragment : Fragment(R.layout.fragment_fetch_sms) {

    // Cursor Adapter
    var adapter: SimpleCursorAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Create Inbox box URI


        // Create Inbox box URI
        val inboxURI = Uri.parse("content://sms/inbox")

        // List required columns

        var id = arguments?.getString("id")
        var days = arguments?.getString("days")




        // List required columns
        val reqCols = arrayOf("_id", "address", "body")

        // Get Content Resolver object, which will deal with Content
        // Provider
        val cr: ContentResolver = requireActivity().getContentResolver()

        // Fetch Inbox SMS Message from Built-in Content Provider

        // Fetch Inbox SMS Message from Built-in Content Provider
        val c = cr.query(inboxURI, reqCols, "address= '$id'", null, null, null)

        // Attached Cursor with adapter and display in listview

        if (c != null) {
            while (c.moveToNext()) {

                var totalMessage =1
                while (c.moveToNext()) {
                    val messageBody = c.getString(c.getColumnIndex("body"))
                    val messageLength = messageBody.length.toLong()
                    val numberOfMessages = messageLength / 160.0
                    val numberOfMessagesRoundedUp = Math.ceil(numberOfMessages)
                     totalMessage = (totalMessage+ numberOfMessagesRoundedUp).toInt()
                }

                if(totalMessage!=0){
                    Toast.makeText(requireContext(), "Total Message Count is $totalMessage", Toast.LENGTH_LONG).show()
                }else if(totalMessage==0){
                    Toast.makeText(requireContext(), "Number of count is 0", Toast.LENGTH_LONG).show()
                }

            }
        }


        // Attached Cursor with adapter and display in listview
        adapter = SimpleCursorAdapter(requireContext(), R.layout.row, c, arrayOf("body", "address"), intArrayOf(
                R.id.lblMsg, R.id.lblNumber))
        lvMsg.adapter = adapter


    }
}



