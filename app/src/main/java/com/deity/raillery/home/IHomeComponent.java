package com.deity.raillery.home;

import com.deity.raillery.base.BaseRxPresenter;
import com.deity.raillery.base.BaseView;
import com.deity.raillery.model.entity.DynamicEntity;

/**
 * 接口定义
 * Created by Deity on 2017/4/25.
 */

public interface IHomeComponent {

    public interface View extends BaseView{
        void showDynamic(DynamicEntity entity);
    }

    public abstract class Presenter<R> extends BaseRxPresenter<R,View>{
        /**
         * 分页加载动态消息数据
         * @param page 当前页数
         */
        abstract void loadDynamicByPage(int page);
    }


}
