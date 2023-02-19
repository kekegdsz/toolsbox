package com.overarching.sky.box

import android.app.Application
import android.content.res.Configuration
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager
import com.overarching.sky.lib.QDSkinManager

/**
 * @author: KYE keke
 * @email: keke@ky-tech.com.cn
 * @date: 2023/2/18 14:51
 */
class BoxApp : Application() {
    override fun onCreate() {
        super.onCreate()
        QMUISwipeBackActivityManager.init(this)
        QDSkinManager.install(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES) {
            QDSkinManager.changeSkin(QDSkinManager.SKIN_DARK)
        } else if (QDSkinManager.getCurrentSkin() == QDSkinManager.SKIN_DARK) {
            QDSkinManager.changeSkin(QDSkinManager.SKIN_BLUE)
        }
    }
}