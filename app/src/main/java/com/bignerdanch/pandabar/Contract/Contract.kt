package com.bignerdanch.pandabar.Contract

import android.content.Context
import android.widget.Button
import com.bignerdanch.pandabar.Model.TableModel
import java.util.*

interface Contract {
    interface View {

    }
    interface Presenter {
        fun onButtonSaveClicked(context: Context, count: String, tea: String, cake: String, id: String)
        fun onButtonCalcClicked(context: Context, count: String, tea: String, cake: String, id: String):Int

        fun getCount(context:Context, id: String):String
        fun getTea(context:Context, id: String):String
        fun getCake(context:Context, id: String):String
        fun onDestroy()
    }

    interface Model {
        fun addCount(context: Context, count: String, tea:String, cake:String, id: String)
        fun calcCost(context: Context, count: String, tea:String, cake:String, id: String):Int
        fun returnCount(context: Context, id: String):String
        fun returnCake(context: Context, id: String):String
        fun returnTea(context: Context, id: String):String

    }
}

