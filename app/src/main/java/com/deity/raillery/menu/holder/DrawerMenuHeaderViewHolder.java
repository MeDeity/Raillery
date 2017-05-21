package com.deity.raillery.menu.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deity.raillery.R;

import butterknife.ButterKnife;

/**
 * Created by Deity on 2017/5/17.
 */

public class DrawerMenuHeaderViewHolder extends BaseViewHolder {

    public DrawerMenuHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bindData(int position, int viewType) {

    }

    public static DrawerMenuHeaderViewHolder instance(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_header,parent,false);
        return new DrawerMenuHeaderViewHolder(view);
    }
}
