package com.biwe.day10.model;


import com.biwe.day10.bean.LeftBean;
import com.biwe.day10.bean.RightBean;
import com.biwe.day10.net.RetrofitHelper;
import com.biwe.day10.net.ServerApi;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by VicYu on 2017/12/8.
 */

public class RightModel {


    public void getData(Observer<RightBean> observer,String cid){

        ServerApi serverApi = RetrofitHelper.getServerApi();
        Observable<RightBean> rightBean = serverApi.getRightBean(cid);
        rightBean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
