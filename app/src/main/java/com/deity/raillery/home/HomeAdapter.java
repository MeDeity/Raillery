package com.deity.raillery.home;


import android.content.Context;

import com.deity.raillery.model.entity.ResponseEntity;
import com.othershe.baseadapter.ViewHolder;
import com.othershe.baseadapter.base.CommonBaseAdapter;

import java.util.List;


/**
 * Created by Deity on 2017/4/25.
 */

public class HomeAdapter extends CommonBaseAdapter<ResponseEntity> {

    public HomeAdapter(Context context, List<ResponseEntity> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, ResponseEntity data) {

    }

    @Override
    protected int getItemLayoutId() {
        return 0;
    }
}
