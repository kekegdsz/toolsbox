package com.overarching.sky.module.home.ui.widget.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.overarching.sky.lib.BaseFragment;

import java.util.List;

public class WidgetsPageAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;

    public WidgetsPageAdapter(@NonNull FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
