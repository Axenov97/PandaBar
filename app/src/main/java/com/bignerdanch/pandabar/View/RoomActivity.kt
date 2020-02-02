package com.bignerdanch.pandabar.View

import androidx.fragment.app.Fragment
import com.bignerdanch.pandabar.Contract.Single
import com.bignerdanch.pandabar.R

class RoomActivity : Single() {
    override fun createFragment(): Fragment = RoomFragment()

}
