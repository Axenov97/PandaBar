package com.bignerdanch.pandabar.View

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bignerdanch.pandabar.Contract.Contract
import com.bignerdanch.pandabar.Presentation.Presenter
import com.bignerdanch.pandabar.R
import com.bignerdanch.pandabar.databinding.FragmentTableBinding
import kotlinx.android.synthetic.main.fragment_table.view.*


class TableFragment:Fragment(),Contract.View, View.OnClickListener {

    var binding: FragmentTableBinding? = null
    private lateinit var presenter: Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = Presenter(this)
        return FragmentTableBinding.inflate(inflater).apply {binding = this}.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       binding!!.buttonSave.setOnClickListener(this)
        binding!!.buttonCalc.setOnClickListener(this)

        val tableId:String = arguments!!.getSerializable(ARG_ID) as String
        binding!!.editTextPeople.setText(presenter.getCount(activity!!, tableId))
        binding!!.editTextTea.setText(presenter.getTea(activity!!, tableId))
        binding!!.editTextCake.setText(presenter.getCake(activity!!, tableId))
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        val tableId:String = arguments!!.getSerializable(ARG_ID) as String
        when(v!!.id){
            R.id.button_save ->
                presenter.onButtonSaveClicked(activity!!, binding!!.editTextPeople.text.toString(),
                    binding!!.editTextTea.text.toString(), binding!!.editTextCake.text.toString(), tableId)
            R.id.button_calc ->
                binding!!.textViewCalc.text = "К оплате " + presenter.onButtonCalcClicked(activity!!, binding!!.editTextPeople.text.toString(),
                    binding!!.editTextTea.text.toString(), binding!!.editTextCake.text.toString(), tableId).toString() + " рублей"
        }
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