package com.deity.raillery.home;


import android.content.Context;

import com.deity.raillery.model.entity.DynamicEntity;
import com.othershe.baseadapter.ViewHolder;
import com.othershe.baseadapter.base.CommonBaseAdapter;

import java.util.List;


/**
 * Created by Deity on 2017/4/25.
 */

public class HomeAdapter extends CommonBaseAdapter<DynamicEntity> {

    public HomeAdapter(Context context, List<DynamicEntity> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, DynamicEntity data) {

    }

    @Override
    protected int getItemLayoutId() {
        return 0;
    }
}
