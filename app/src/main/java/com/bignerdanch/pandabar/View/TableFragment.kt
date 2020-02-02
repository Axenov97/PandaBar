package com.bignerdanch.pandabar.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bignerdanch.pandabar.Contract.Contract
import com.bignerdanch.pandabar.Presentation.Presenter
import com.bignerdanch.pandabar.R


class TableFragment:Fragment(),Contract.View, View.OnClickListener {
    private lateinit var textView: TextView
    private lateinit var editText:EditText
    private lateinit var buttonSave:Button
    private lateinit var presenter: Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = Presenter(this)
        return inflater.inflate(R.layout.fragment_table, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.textView)
        editText = view.findViewById(R.id.editText)
        buttonSave = view.findViewById(R.id.button_save)
        buttonSave.setOnClickListener(this)
        editText.setText(showCount())
    }

    override fun showCount():String? {
        var tableId:String = arguments!!.getSerializable(ARG_ID) as String
        return presenter.getCount(activity!!, tableId)
   }

    override fun onClick(v: View?) {
        var tableId:String = arguments!!.getSerializable(ARG_ID) as String
        presenter.onButtonSaveClicked(activity!!, editText.text.toString(), tableId)
    }

    companion object {
        private const val ARG_ID = "table_id"

        fun newInstance(tableId: String?): TableFragment? {
            val args = Bundle()
            args.putSerializable(ARG_ID, tableId)
            val fragment = TableFragment()
            fragment.arguments = args
            return fragment
        }
    }
}