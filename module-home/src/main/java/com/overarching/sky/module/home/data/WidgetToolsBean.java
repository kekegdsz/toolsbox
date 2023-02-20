package com.overarching.sky.module.home.data;

public class WidgetToolsBean extends BaseWidgetBean implements Widget {

    public WidgetToolsBean() {
    }

    @Override
    public int getType() {
        return WidgetType.WIDGET_TOOLS_TYPE;
    }
}
