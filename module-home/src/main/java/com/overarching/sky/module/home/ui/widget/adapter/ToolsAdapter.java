package com.overarching.sky.module.home.ui.widget.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.overarching.sky.module.home.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import java.util.List;

/**
 * @author keke
 * 顶部功能适配器
 */
public class ToolsAdapter extends RecyclerView.Adapter {

    private List<String> items;

    public ToolsAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tools, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int screenWidth = QMUIDisplayHelper.getScreenWidth(holder.itemView.getContext());
        //减去平布padding
        int padding = QMUIDisplayHelper.dp2px(holder.itemView.getContext(), 12);
        int width = (screenWidth - padding * 2) / 3;
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.width = width;
        holder.itemView.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
