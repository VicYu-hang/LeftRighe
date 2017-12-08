package com.biwe.day10.presenter;

import com.biwe.day10.bean.LeftBean;
import com.biwe.day10.bean.RightBean;
import com.biwe.day10.model.LeftModel;
import com.biwe.day10.model.RightModel;
import com.biwe.day10.view.ILeftView;
import com.biwe.day10.view.IRightView;

import rx.Observer;

/**
 * Created by VicYu on 2017/12/8.
 */

public class RightPresenter {

    private IRightView iRightView;
    private RightModel rightModel;

    public RightPresenter(IRightView iRightView) {
        this.iRightView=iRightView;
        rightModel= new RightModel();
    }

    public void getData(){
        rightModel.getData(new Observer<RightBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(RightBean rightBean) {
                iRightView.showRight(rightBean);
            }
        },iRightView.cid());

    }

}
