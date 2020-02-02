package com.bignerdanch.pandabar.Presentation

import android.content.Context
import android.util.Log
import com.bignerdanch.pandabar.Contract.Contract
import com.bignerdanch.pandabar.Model.TableModel
import com.bignerdanch.pandabar.View.TableFragment

class Presenter: Contract.Presenter {

    private companion object val TAG = "Presenter"
    private var view: Contract.View
    private var model: Contract.Model

    constructor(tableView: TableFragment){
        this.view = tableView
        this.model = TableModel()
    }

    override fun getCount(context: Context, id: String):String
        = model.returnCount(context, id)

    override fun getTea(context: Context, id: String): String
        = model.returnTea(context, id)

    override fun getCake(context: Context, id: String): String
        = model.returnCake(context, id)

    override fun onButtonSaveClicked(context: Context, count:String, tea:String, cake:String, id:String) {
        model.addCount(context, count, tea, cake, id)
    }

    override fun onButtonCalcClicked(context: Context, count: String, tea: String, cake: String, id: String):Int
        = model.calcCost(context, count, tea, cake, id)


    override fun onDestroy() {
        Log.d(TAG, "onDestroy()")
    }
}