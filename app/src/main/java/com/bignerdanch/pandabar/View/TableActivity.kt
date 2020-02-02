package com.bignerdanch.pandabar.View

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.bignerdanch.pandabar.Contract.Single

class TableActivity: Single() {
    override fun createFragment(): Fragment {
        var tableId: String = intent.getSerializableExtra(EXTRA_ID) as String
        return TableFragment.newInstance(tableId)!!

    }
    companion object {
        private val EXTRA_ID = "com.bignerdanch.table_id"

        fun newIntent(packageContext: Context, tableId:String): Intent {
            var intent = Intent(packageContext, TableActivity::class.java)
            intent.putExtra(EXTRA_ID, tableId)
            return intent
        }
    }
}