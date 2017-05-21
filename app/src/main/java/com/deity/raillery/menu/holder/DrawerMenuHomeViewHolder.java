package com.deity.raillery.menu.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deity.raillery.R;

import butterknife.ButterKnife;

/**
 * Created by Deity on 2017/5/17.
 */

public class DrawerMenuHomeViewHolder extends BaseViewHolder {

    private DrawerAdapter drawerAdapter;

    public DrawerMenuHomeViewHolder(View itemView,DrawerAdapter drawerAdapter) {
        super(itemView);
        this.drawerAdapter = drawerAdapter;
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bindData(int position, int viewType) {

    }

    public static DrawerMenuHomeViewHolder instance(ViewGroup parent,DrawerAdapter drawerAdapter){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_home,parent,false);
        return new DrawerMenuHomeViewHolder(view,drawerAdapter);
    }
}
