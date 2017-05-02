package com.deity.raillery.home;


import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.deity.raillery.R;
import com.deity.raillery.data.Params;
import com.deity.raillery.model.entity.DynamicEntity;
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
        ImageView imageView = (ImageView)holder.getView(R.id.image_gif);
        //这部分显示高度不同图片,从服务器传递
//        String width = dataBean.getWidth();
//        String height = dataBean.getHeight();
//        ViewGroup.LayoutParams lp = holder.img.getLayoutParams();
//        lp.width = mWidth;
//        lp.height = (mWidth * Integer.parseInt(height) / Integer.parseInt(width));
//        imageView.setLayoutParams(lp);
        if (!data.getFileUrl().equals(imageView.getTag(R.id.image_key))) {
            Log.i(HomeAdapter.class.getSimpleName(),Params.NetWork.WEBSITE_BASE_URL + data.getFileUrl());
            Glide.with(context).load(Params.NetWork.WEBSITE_BASE_URL + data.getFileUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
            imageView.setTag(R.id.image_key,data.getFileUrl());
        }

    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_dynamic;
    }
}
