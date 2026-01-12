package com.koje.framework.view

import android.widget.Switch
import com.koje.framework.utils.BooleanPreference


class SwitchBuilder(override val view: Switch) :
    ViewBuilder(view) {

    fun setValue(value: Boolean) {
        view.isChecked = value
    }

    fun setProperty(property: BooleanPreference) {
        setValue(property.get())
        view.setOnCheckedChangeListener { buttonView, isChecked ->
            property.set(isChecked)
        }
    }

    fun setOnCheckedChangeListener(pref: BooleanPreference) {
        view.setOnCheckedChangeListener { buttonView, isChecked ->
            pref.set(isChecked)
        }

    }
}