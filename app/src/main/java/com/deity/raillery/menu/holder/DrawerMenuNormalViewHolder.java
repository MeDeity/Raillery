package com.deity.raillery.menu.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.deity.raillery.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Deity on 2017/5/17.
 */

public class DrawerMenuNormalViewHolder extends BaseViewHolder {

    @BindView(R.id.drawer_item_logo)
    public ImageView drawerItemLogo;

    @BindView(R.id.drawer_item_title)
    public TextView drawerItemTitle;

    private DrawerAdapter mDrawerAdapter;

    public DrawerMenuNormalViewHolder(View itemView,DrawerAdapter mDrawerAdapter) {
        super(itemView);
        this.mDrawerAdapter = mDrawerAdapter;
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bindData(int position, int viewType) {

    }

    public static DrawerMenuNormalViewHolder instance(ViewGroup parent,DrawerAdapter adapter){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_home,null);
        return new DrawerMenuNormalViewHolder(view,adapter);
    }
}
