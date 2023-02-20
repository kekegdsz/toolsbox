package com.overarching.sky.module.home.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

import com.overarching.sky.module.home.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * 简单widget
 * 一般会实现一个BroadcastReceiver当接收到广播时，更新widget;本例子直接用定时任务实现更新。
 *
 * @author fwwdn
 */

//定时任务类
public class MyTime extends TimerTask {
    RemoteViews remoteViews;
    AppWidgetManager appWidgetManager;
    ComponentName thisWidget;

    public MyTime(Context context, AppWidgetManager appWidgetManager) {
        this.appWidgetManager = appWidgetManager;
        remoteViews = new RemoteViews(context.getPackageName(), R.layout.count_down_app_widget);
        thisWidget = new ComponentName(context, CountDownAppWidget.class);
    }

    //定时任务内容
    public void run() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        remoteViews.setTextViewText(R.id.appwidget_text, format);
        //更新Widget内容
        appWidgetManager.updateAppWidget(thisWidget, remoteViews);
    }
}
