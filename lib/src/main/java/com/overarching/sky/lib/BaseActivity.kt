package com.overarching.sky.lib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

/**
 * @author: KYE keke
 * @email: keke@ky-tech.com.cn
 * @date: 2023/2/18 16:12
 * 基类
 */
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        QMUIStatusBarHelper.setStatusBarLightMode(this)
    }
}