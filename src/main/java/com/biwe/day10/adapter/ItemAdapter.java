package com.biwe.day10.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biwe.day10.R;
import com.biwe.day10.bean.RightBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by VicYu on 2017/12/8.
 */

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RightBean.DataBean.ListBean> list;
    private Context context;

    public ItemAdapter(List<RightBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item_item, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mTextview3.setText(list.get(position).getName());
        viewHolder.mSdv.setImageURI(list.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        SimpleDraweeView mSdv;
        TextView mTextview3;

        ViewHolder(View view) {
            super(view);
            this.mSdv = (SimpleDraweeView) view.findViewById(R.id.sdv);
            this.mTextview3 = (TextView) view.findViewById(R.id.textview3);
        }
    }
}
