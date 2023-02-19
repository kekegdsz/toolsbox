package com.overarching.sky.module.home.ui.pager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WidgetPageViewModel : ViewModel() {

    val widgetItems by lazy { MutableLiveData<List<String>>() }
    fun getWidgets() {
        val items = mutableListOf<String>()
        items.add("Test")
        items.add("Test")
        items.add("Test")
        items.add("Test")
        items.add("Test")
        items.add("Test")
        widgetItems.postValue(items)
    }
}