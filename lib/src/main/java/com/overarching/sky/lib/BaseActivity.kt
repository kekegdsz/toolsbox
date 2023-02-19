package com.overarching.sky.lib

import android.os.Bundle
import com.qmuiteam.qmui.arch.QMUIActivity
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

/**
 * @author: KYE keke
 * @email: keke@ky-tech.com.cn
 * @date: 2023/2/18 16:12
 * 基类
 */
open class BaseActivity : QMUIActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        QMUIStatusBarHelper.setStatusBarLightMode(this)
    }
}