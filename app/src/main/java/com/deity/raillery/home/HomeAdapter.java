package com.deity.raillery.home;


import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.deity.raillery.R;
import com.deity.raillery.data.Params;
import com.deity.raillery.model.entity.DynamicEntity;
import com.deity.raillery.utils.AppUtils;
import com.othershe.baseadapter.ViewHolder;
import com.othershe.baseadapter.base.CommonBaseAdapter;

import java.util.List;

import static android.R.attr.data;
import static android.R.attr.width;


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

        final ImageView imageView = (ImageView)holder.getView(R.id.image_gif);
        final DynamicEntity entity = data;
        imageView.post(new Runnable() {
            @Override
            public void run() {
                float heightRatio = onMeasureHeightRatio(entity);
                if (heightRatio!=0){
                    ViewGroup.LayoutParams lp = imageView.getLayoutParams();
                    lp.height = (int)(AppUtils.getScreenPixels(context).widthPixels*heightRatio);
                    Log.i("width>>>",""+AppUtils.getScreenPixels(context).widthPixels);
                    imageView.setLayoutParams(lp);
                }
                if (!entity.getFileUrl().equals(imageView.getTag(R.id.image_key))) {
                    Log.i(HomeAdapter.class.getSimpleName(),Params.NetWork.WEBSITE_BASE_URL + entity.getFileUrl());
                    Glide.with(context).load(Params.NetWork.WEBSITE_BASE_URL + entity.getFileUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
                    imageView.setTag(R.id.image_key,entity.getFileUrl());
                }
            }
        });
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_dynamic;
    }

    /**
     * 相对宽度来说，图片的高度比例
     * @param data 从服务获取的数据
     * @return 高度比例
     */
    private float onMeasureHeightRatio(DynamicEntity data){
        if (null==data){//非空判断
            return 0.0f;
        }
        float width = data.getWidth();
        float height = data.getHeight();
        if (width == 0f||height == 0f){
            return 0.0f;
        }
        return (data.getHeight()/data.getWidth());
    }
}
