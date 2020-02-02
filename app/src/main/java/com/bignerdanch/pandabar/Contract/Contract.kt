package com.bignerdanch.pandabar.Contract

import android.content.Context
import android.widget.Button
import com.bignerdanch.pandabar.Model.TableModel
import java.util.*

interface Contract {
    interface View {
        fun showCount():String?
    }

    interface Presenter {
        fun onButtonSaveClicked(context: Context, count: String, id: String)
        fun getCount(context:Context, id: String):String
        fun onDestroy()
    }

    interface Model {
        fun addCount(context: Context, count: String, id: String)
        fun returnCount(context: Context, id: String):String
    }
}
