package com.deity.raillery.menu.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.deity.raillery.model.entity.MenuEntity;

import java.util.List;

/**
 * Created by Deity on 2017/5/17.
 */

public class DrawerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int TYPE_HEADER_ITEM = 0;
    public static final int TYPE_HOME_ITEM = 1;
    public static final int TYPE_NORMAL_ITEM = 6;

    public List<MenuEntity> menuEntities;
    private Context context;
    private int mSelction = 1;

    private DrawerSelectListener mDrawerSelectistener;

    public DrawerAdapter(Context context,List<MenuEntity> menuEntities){
        this.menuEntities = menuEntities;
        this.context = context;
    }

    public DrawerAdapter(){
    }

    public void setSelection(int position) {

        int lastpos = mSelction;

        mSelction = position;

        notifyItemChanged(lastpos);

        notifyItemChanged(mSelction);

    }

    public int getmSelction() {
        return mSelction;
    }

    public DrawerSelectListener getmDrawerSelectistener() {
        return mDrawerSelectistener;
    }

    public void setmDrawerSelectistener(DrawerSelectListener mDrawerSelectistener) {
        this.mDrawerSelectistener = mDrawerSelectistener;
    }

    @Override
    public int getItemViewType(int position) {
        return position>1?TYPE_NORMAL_ITEM:position;//当postion大于1的情况下，则是正常的ITEM
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder = null;
        switch (viewType){
            case TYPE_HEADER_ITEM:
                holder = DrawerMenuHeaderViewHolder.instance(parent);
                break;
            case TYPE_HOME_ITEM:
                holder = DrawerMenuHomeViewHolder.instance(parent,this);
                break;
            case TYPE_NORMAL_ITEM:
                holder = DrawerMenuNormalViewHolder.instance(parent,this);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        holder.bindData(position,viewType);
    }

    @Override
    public int getItemCount() {
        return null==menuEntities?2:menuEntities.size()+2;
    }
}
