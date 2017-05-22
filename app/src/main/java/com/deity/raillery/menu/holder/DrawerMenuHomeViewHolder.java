package com.deity.raillery.menu.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deity.raillery.R;
import com.deity.raillery.data.RailleryApplication;

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

    public void itemViewHighLight(int postion){
        if (postion == drawerAdapter.getmSelction()){
            itemView.setBackgroundColor(RailleryApplication.instance.getResources().getColor(R.color.drawer_bg_highlight_light));
        }else {
            itemView.setBackgroundColor(RailleryApplication.instance.getResources().getColor(R.color.drawer_bg_normal_light));
        }
    }

    @Override
    public void bindData(final int position, int viewType) {
        itemViewHighLight(position);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerAdapter.setSelection(position);
                DrawerSelectListener drawerSelectListener = drawerAdapter.getmDrawerSelectistener();
                if (null!=drawerSelectListener){
                    drawerSelectListener.onDrawerHomeItemSelect(position);
                }
            }
        });
    }

    public static DrawerMenuHomeViewHolder instance(ViewGroup parent,DrawerAdapter drawerAdapter){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_home,parent,false);
        return new DrawerMenuHomeViewHolder(view,drawerAdapter);
    }
}
