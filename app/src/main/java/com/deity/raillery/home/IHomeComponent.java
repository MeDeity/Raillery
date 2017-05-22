package com.deity.raillery.home;

import com.deity.raillery.base.BaseRxPresenter;
import com.deity.raillery.base.BaseView;
import com.deity.raillery.model.entity.DynamicType;
import com.deity.raillery.model.entity.ResponseEntity;

/**
 * 接口定义
 * Created by Deity on 2017/4/25.
 */

public interface IHomeComponent {

    interface View extends BaseView{
        void showDynamic(ResponseEntity entity);
        void showLoadFail();
        void showLoadEnd();
    }

    abstract class Presenter<R> extends BaseRxPresenter<R,View>{
        /**
         * 分页加载动态消息数据
         * @param page 当前页数
         */
        abstract void loadDynamicByPage(int page);
    }


}
