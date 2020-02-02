package com.bignerdanch.pandabar.View

import androidx.fragment.app.Fragment
import com.bignerdanch.pandabar.Contract.Single

class RoomActivity : Single() {
    override fun createFragment(): Fragment = RoomFragment()
}
