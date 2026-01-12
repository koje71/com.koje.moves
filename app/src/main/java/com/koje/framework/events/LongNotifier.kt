package com.koje.framework.events

open class LongNotifier(content: Long) : Notifier<Long>(content) {

    fun increase() {
        set(content + 1)
    }

    fun increase(count: Int) {
        set(content + count)
    }

    fun decrease() {
        set(content - 1)
    }
}