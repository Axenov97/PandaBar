package com.bignerdanch.pandabar.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bignerdanch.pandabar.databinding.FragmentRoomBinding

class RoomFragment:Fragment() {
    var binding:FragmentRoomBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentRoomBinding.inflate(inflater).apply {binding = this}.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startTableActivity(binding!!.tableFirst, "1")
        startTableActivity(binding!!.tableSecond,"2")
        startTableActivity(binding!!.tableThree,"3")
        startTableActivity(binding!!.tableFour,"4")
        startTableActivity(binding!!.tableFive,"5")
        startTableActivity(binding!!.tableSix,"6")
    }

   private fun startTableActivity(button: Button, id: String) {
        button.setOnClickListener{
            startActivity(TableActivity.newIntent(activity!!, tableId = id))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}