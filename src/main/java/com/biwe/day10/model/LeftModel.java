package com.biwe.day10.model;


import com.biwe.day10.bean.LeftBean;
import com.biwe.day10.net.RetrofitHelper;
import com.biwe.day10.net.ServerApi;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by VicYu on 2017/12/8.
 */

public class LeftModel {


    public void getData(Observer<LeftBean> observer){

        ServerApi serverApi = RetrofitHelper.getServerApi();
        Observable<LeftBean> bean = serverApi.getLeftBean();
        bean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);


    }
}
