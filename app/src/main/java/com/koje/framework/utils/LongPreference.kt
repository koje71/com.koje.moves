package com.koje.framework.utils

import com.koje.framework.events.LongNotifier

open class LongPreference(val key: String, val initial: Long) :
    LongNotifier(Preferences.getLong(key, initial)) {

    override fun set(value: Long) {
        if (value == content) {
            return
        }
        super.set(value)
        Preferences.setLong(key, value)
    }

}