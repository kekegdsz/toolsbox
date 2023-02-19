package com.overarching.sky.module.home.ui.widget

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WidgetsViewModel : ViewModel() {
    /**
     *  工具入口数据
     */
    val toolItems by lazy { MutableLiveData<List<String>>() }

    fun getToolsItems() {
        val items = mutableListOf<String>()
        items.add("Test")
        items.add("Test")
        items.add("Test")
        items.add("Test")
        items.add("Test")
        items.add("Test")
        toolItems.postValue(items)
    }

}