package com.overarching.sky.module.home.ui.widget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.overarching.sky.module.home.R
import com.overarching.sky.module.home.ui.widget.adapter.ToolsAdapter

/**
 * @author keke
 * 首页组件适配器
 */
class WidgetsFragment : Fragment() {

    private var toolsRecycler: RecyclerView? = null
    private var toolsAdapter: ToolsAdapter? = null

    companion object {
        fun newInstance() = WidgetsFragment()
    }

    private lateinit var viewModel: WidgetsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_widgets, container, false)
        initViews(rootView)
        initAdapter()
        return rootView
    }

    private fun initAdapter() {
        val items = mutableListOf<String>()
        items.add("s")
        items.add("s")
        items.add("s")
        items.add("s")
        items.add("s")
        items.add("s")
        toolsAdapter = ToolsAdapter(items)
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        toolsRecycler?.layoutManager = linearLayoutManager
        toolsRecycler?.adapter = toolsAdapter

    }

    private fun initViews(rootView: View?) {
        toolsRecycler = rootView?.findViewById(R.id.tools_recycler)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WidgetsViewModel::class.java)

    }

}