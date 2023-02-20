package com.overarching.sky.module.home.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.overarching.sky.lib.BaseFragment
import com.overarching.sky.module.home.R
import com.overarching.sky.module.home.data.BaseWidgetBean
import com.overarching.sky.module.home.ui.pager.adapter.WidgetsAdapter

class WidgetPageFragment(val title: String) : BaseFragment() {
    private var widgetRecycler: RecyclerView? = null
    private var widgetAdapter: WidgetsAdapter? = null

    companion object {
        fun newInstance(title: String) = WidgetPageFragment(title)
    }

    private lateinit var viewModel: WidgetPageViewModel


    override fun onCreateView(): View? {
        val rootView = LayoutInflater.from(activity)?.inflate(R.layout.fragment_widget_page, null)
        initViews(rootView)
        initAdapter()
        return rootView
    }

    private fun initAdapter() {
        val items = mutableListOf<BaseWidgetBean>()
        widgetAdapter = WidgetsAdapter(items)
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        widgetRecycler?.layoutManager = linearLayoutManager
        widgetRecycler?.adapter = widgetAdapter
    }

    private fun initViews(rootView: View?) {
        widgetRecycler = rootView?.findViewById(R.id.widget_recycler)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WidgetPageViewModel::class.java)
        viewModel.widgetItems.observe(viewLifecycleOwner){
            widgetAdapter?.setData(it)
        }
        viewModel.getWidgets()
    }

}