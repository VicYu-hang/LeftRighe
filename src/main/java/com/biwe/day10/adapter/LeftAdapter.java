package com.biwe.day10.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biwe.day10.R;
import com.biwe.day10.bean.LeftBean;

/**
 * Created by VicYu on 2017/12/8.
 */

public class LeftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LeftBean leftBean;
    private onItemClickListener itemClickListener;

    public LeftAdapter(Context context, LeftBean leftBean) {
        this.context = context;
        this.leftBean = leftBean;
    }
    public void setOnItemClickListener(onItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface onItemClickListener{
        void onItemClickListener(LeftBean.DataBean dataBean);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item_left, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        final LeftBean.DataBean dataBean = leftBean.getData().get(position);
        viewHolder.mTvLeft.setText(leftBean.getData().get(position).getName());
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClickListener(dataBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return leftBean.getData().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        private TextView mTvLeft;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            mTvLeft = (TextView) view.findViewById(R.id.tv_left);
        }
    }

}
