package com.deity.raillery.menu.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Deity on 2017/5/17.
 */

public abstract class BaseViewHolder<T>  extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(int position,int viewType);
}
