package com.koje.framework.utils

import com.koje.framework.events.IntNotifier

class IntPreference(val key: String, content: Int) :
    IntNotifier(Preferences.getInt(key, content)) {

    override fun set(value: Int) {
        if (value == content) {
            return
        }
        super.set(value)
        Preferences.setInt(key, value)
    }

}