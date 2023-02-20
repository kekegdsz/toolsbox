package com.overarching.sky.module.home.ui.pager.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.overarching.sky.module.home.R;
import com.overarching.sky.module.home.data.BaseWidgetBean;
import com.overarching.sky.module.home.data.WidgetType;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author keke
 * 顶部功能适配器
 */
public class WidgetsAdapter extends RecyclerView.Adapter {

    private List<BaseWidgetBean> items;

    public WidgetsAdapter(List<BaseWidgetBean> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case WidgetType.WIDGET_TITLE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_widget_title, parent, false);
                break;
            case WidgetType.WIDGET_TOOLS_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_widget_tools, parent, false);
                break;
        }
        return new ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void setData(@Nullable List<BaseWidgetBean> data) {
        this.items = data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
