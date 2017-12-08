package com.biwe.day10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.biwe.day10.adapter.LeftAdapter;
import com.biwe.day10.adapter.RightAdapter;
import com.biwe.day10.bean.LeftBean;
import com.biwe.day10.bean.RightBean;
import com.biwe.day10.presenter.LeftPresenter;
import com.biwe.day10.presenter.RightPresenter;
import com.biwe.day10.view.ILeftView;
import com.biwe.day10.view.IRightView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ILeftView,IRightView {


    private LeftPresenter leftPresenter;
    private RecyclerView mRvLeft;
    private RecyclerView mRvRight;
    private RightPresenter rightPresenter;
    private int cid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        leftPresenter = new LeftPresenter(this);
        leftPresenter.getData();
        rightPresenter = new RightPresenter(this);


    }

    @Override
    public void showLeft(LeftBean leftBean) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRvLeft.setLayoutManager(layoutManager);
        LeftAdapter leftAdapter = new LeftAdapter(this,leftBean);
        mRvLeft.setAdapter(leftAdapter);
        leftAdapter.setOnItemClickListener(new LeftAdapter.onItemClickListener() {



            @Override
            public void onItemClickListener(LeftBean.DataBean dataBean) {
                cid = dataBean.getCid();
                rightPresenter.getData();

            }
        });
    }

    @Override
    public void showRight(RightBean rightBean) {
        mRvRight.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        RightAdapter rightAdapter = new RightAdapter(this,rightBean);
        mRvRight.setAdapter(rightAdapter);
    }

    @Override
    public String cid() {
        return cid+"";
    }

    private void initView() {
        mRvLeft = (RecyclerView) findViewById(R.id.rv_left);
        mRvRight = (RecyclerView) findViewById(R.id.rv_right);

    }
}
