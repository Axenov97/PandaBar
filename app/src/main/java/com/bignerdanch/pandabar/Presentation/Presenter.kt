package com.bignerdanch.pandabar.Presentation

import android.content.Context
import android.util.Log
import com.bignerdanch.pandabar.Contract.Contract
import com.bignerdanch.pandabar.Model.TableModel
import com.bignerdanch.pandabar.View.TableFragment

class Presenter: Contract.Presenter {

    private companion object val TAG = "MainPresenter"
    private var view: Contract.View
    private var model: Contract.Model

    constructor(tableView: TableFragment){
        this.view = tableView
        this.model = TableModel()
    }

    override fun getCount(context: Context, id: String):String {
        return model.returnCount(context, id)
    }
    override fun onButtonSaveClicked(context: Context, count:String, id:String) {
        model.addCount(context, count, id)
    }

    override fun onDestroy() {
        /**
         * Если бы мы работали например с RxJava, в этом классе стоило бы отписываться от подписок
         * Кроме того, при работе с другими методами асинхронного андроида здесь мы боремся с утечкой контекста
         */

        Log.d(TAG, "onDestroy()")
    }
}