package com.overarching.sky.module.home.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.overarching.sky.lib.BaseFragment
import com.overarching.sky.module.home.R

class WidgetPageFragment(val title: String): BaseFragment() {

    companion object {
        fun newInstance(title: String) = WidgetPageFragment(title)
    }

    private lateinit var viewModel: WidgetPageViewModel


    override fun onCreateView(): View {
        return LayoutInflater.from(activity).inflate(R.layout.fragment_widget_page, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WidgetPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}