package com.overarching.sky.module.home.data;

public class WidgetTitleBean extends BaseWidgetBean {

    private String title;

    public WidgetTitleBean(String title) {
        this.title = title;
    }

    @Override
    public int getType() {
        return WidgetType.WIDGET_TITLE_TYPE;
    }
}
