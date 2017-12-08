package com.biwe.day10.net;

import com.biwe.day10.bean.LeftBean;
import com.biwe.day10.bean.RightBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by VicYu on 2017/12/8.
 */

public interface ServerApi {

    @GET(Api.LEFT)
    Observable<LeftBean>getLeftBean();
    @GET(Api.RIGHT)
    Observable<RightBean>getRightBean(@Query("cid")String cid);

}
