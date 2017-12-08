package com.biwe.day10.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biwe.day10.R;
import com.biwe.day10.bean.LeftBean;
import com.biwe.day10.bean.RightBean;

import java.util.List;

/**
 * Created by VicYu on 2017/12/8.
 */

public class RightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private RightBean rightBean;

    public RightAdapter(Context context, RightBean rightBean) {
        this.context = context;
        this.rightBean = rightBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item_right, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mTvLeft.setText(rightBean.getData().get(position).getName());
        viewHolder.rv.setLayoutManager(new GridLayoutManager(context,5));
        ItemAdapter itemAdapter = new ItemAdapter(rightBean.getData().get(position).getList(),context);
        viewHolder.rv.setAdapter(itemAdapter);
    }

    @Override
    public int getItemCount() {
        return rightBean.getData().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        private TextView mTvLeft;
        private RecyclerView rv;
        ViewHolder(View view) {
            super(view);
            this.view = view;
            mTvLeft = (TextView) view.findViewById(R.id.tv_left);
            rv= (RecyclerView) view.findViewById(R.id.rv_item);
        }
    }
}
