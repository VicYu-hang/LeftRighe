package com.biwe.day10.presenter;

import android.util.Log;

import com.biwe.day10.bean.LeftBean;
import com.biwe.day10.model.LeftModel;
import com.biwe.day10.view.ILeftView;

import rx.Observer;

/**
 * Created by VicYu on 2017/12/8.
 */

public class LeftPresenter {

    private ILeftView iLeftView;
    private LeftModel leftModel;

    public LeftPresenter(ILeftView iLeftView) {
        this.iLeftView = iLeftView;
        leftModel= new LeftModel();
    }

    public void getData(){
        leftModel.getData(new Observer<LeftBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(LeftBean leftBean) {
                iLeftView.showLeft(leftBean);
            }
        });

    }

}
