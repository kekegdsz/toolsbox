package com.overarching.sky.module.home.ui.widget

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.overarching.sky.lib.BaseFragment
import com.overarching.sky.module.home.R
import com.overarching.sky.module.home.ui.pager.WidgetPageFragment
import com.overarching.sky.module.home.ui.widget.adapter.ToolsAdapter
import com.overarching.sky.module.home.ui.widget.adapter.WidgetsPageAdapter
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import com.qmuiteam.qmui.widget.tab.QMUITabIndicator
import com.qmuiteam.qmui.widget.tab.QMUITabSegment


/**
 * @author keke
 * 首页组件适配器
 */
class WidgetsFragment : BaseFragment() {

    private var toolsRecycler: RecyclerView? = null
    private var tabSegment: QMUITabSegment? = null
    private var viewPager: ViewPager? = null
    private var toolsAdapter: ToolsAdapter? = null

    companion object {
        fun newInstance() = WidgetsFragment()
    }

    private lateinit var viewModel: WidgetsViewModel

    override fun onCreateView(): View? {
        val rootView = LayoutInflater.from(activity)?.inflate(R.layout.fragment_widgets, null)
        initViews(rootView)
        initAdapter()
        return rootView
    }

    private fun initAdapter() {
        val items = mutableListOf<String>()
        toolsAdapter = ToolsAdapter(items)
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        toolsRecycler?.layoutManager = linearLayoutManager
        toolsRecycler?.adapter = toolsAdapter


        val fragments = mutableListOf<BaseFragment>()
        fragments.add(WidgetPageFragment.newInstance("推荐"))
        fragments.add(WidgetPageFragment.newInstance("超小组件"))
        fragments.add(WidgetPageFragment.newInstance("vip专区"))
        fragments.add(WidgetPageFragment.newInstance("语音来电"))
        fragments.add(WidgetPageFragment.newInstance("x-面板"))
        fragments.add(WidgetPageFragment.newInstance("趣味组件"))
        fragments.add(WidgetPageFragment.newInstance("生活工具"))
        fragments.add(WidgetPageFragment.newInstance("时钟"))
        fragments.add(WidgetPageFragment.newInstance("日历"))
        fragments.add(WidgetPageFragment.newInstance("倒数日"))
        fragments.add(WidgetPageFragment.newInstance("咨询"))
        fragments.add(WidgetPageFragment.newInstance("其他"))

        val widgetsPageAdapter =
            activity?.supportFragmentManager?.let { WidgetsPageAdapter(it, fragments) }
        viewPager?.adapter = widgetsPageAdapter
        viewPager?.setCurrentItem(0, false)
        val tabBuilder = tabSegment?.tabBuilder()
        fragments.forEach {
            val title = (it as WidgetPageFragment).title
            tabBuilder?.setTextSize(
                QMUIDisplayHelper.dp2px(activity, 14),
                QMUIDisplayHelper.dp2px(activity, 14)
            )?.setText(title)
            val qmuiTab = tabBuilder?.build(activity)
            tabSegment?.addTab(qmuiTab)
        }
        val space = QMUIDisplayHelper.dp2px(context, 16)
        tabSegment?.setIndicator(
            QMUITabIndicator(
                QMUIDisplayHelper.dp2px(context, 2), false, true
            )
        )
        tabSegment?.mode = QMUITabSegment.MODE_SCROLLABLE
        tabSegment?.setItemSpaceInScrollMode(space)
        tabSegment?.setupWithViewPager(viewPager, false)
        tabSegment?.setPadding(space, 0, space, 0)
        tabSegment?.addOnTabSelectedListener(object : QMUITabSegment.OnTabSelectedListener {
            override fun onTabSelected(index: Int) {

            }

            override fun onTabUnselected(index: Int) {

            }

            override fun onTabReselected(index: Int) {

            }

            override fun onDoubleTap(index: Int) {

            }
        })

    }

    private fun initViews(rootView: View?) {
        toolsRecycler = rootView?.findViewById(R.id.tools_recycler)
        tabSegment = rootView?.findViewById(R.id.tabSegment)
        viewPager = rootView?.findViewById(R.id.viewPager)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WidgetsViewModel::class.java)
        viewModel.toolItems.observe(viewLifecycleOwner) {
            toolsAdapter?.setData(it)
        }
        viewModel.getToolsItems()


    }

}