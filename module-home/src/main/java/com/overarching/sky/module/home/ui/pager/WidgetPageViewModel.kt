package com.overarching.sky.module.home.ui.pager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.overarching.sky.module.home.data.BaseWidgetBean
import com.overarching.sky.module.home.data.WidgetTitleBean
import com.overarching.sky.module.home.data.WidgetToolsBean

class WidgetPageViewModel : ViewModel() {

    val widgetItems by lazy { MutableLiveData<List<BaseWidgetBean>>() }
    fun getWidgets() {
        val items = mutableListOf<BaseWidgetBean>()
        items.add(WidgetTitleBean("热门组件"))
        items.add(WidgetToolsBean())
        items.add(WidgetToolsBean())
        items.add(WidgetToolsBean())
        items.add(WidgetTitleBean("热门组件"))
        items.add(WidgetToolsBean())
        items.add(WidgetToolsBean())
        items.add(WidgetToolsBean())
        widgetItems.postValue(items)
    }
}