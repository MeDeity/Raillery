package com.deity.raillery.home;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.deity.raillery.R;
import com.deity.raillery.data.Params;
import com.deity.raillery.model.entity.DynamicEntity;
import com.deity.raillery.model.entity.ResponseEntity;
import com.google.gson.Gson;
import com.othershe.baseadapter.ViewHolder;
import com.othershe.baseadapter.base.CommonBaseAdapter;

import java.util.List;


/**
 * Created by Deity on 2017/4/25.
 */

public class HomeAdapter extends CommonBaseAdapter<DynamicEntity> {
    private Context context;

    public HomeAdapter(Context context, List<DynamicEntity> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, DynamicEntity data) {
        holder.setText(R.id.image_description,data.getDescription());
        Glide.with(context).load(Params.NetWork.WEBSITE_BASE_URL+data.getFileUrl()).into((ImageView)holder.getView(R.id.image_gif));
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_dynamic;
    }
}
