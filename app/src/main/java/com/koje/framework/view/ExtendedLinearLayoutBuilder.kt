package com.koje.framework.view

class ExtendedLinearLayoutBuilder(override val view: NewLinearLayout) :
    LinearLayoutBuilder(view) {

    interface Editor : ViewEditor<ExtendedLinearLayoutBuilder>

    fun setMaxWidthDP(value: Int) {
        view.maxWidth = getPixelFromDP(value)
    }

}