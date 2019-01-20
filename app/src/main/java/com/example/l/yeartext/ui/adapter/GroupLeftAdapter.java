package com.example.l.yeartext.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.l.yeartext.R;
import com.example.l.yeartext.data.bean.GroupLeftBean;

import java.util.List;

public class GroupLeftAdapter extends BaseQuickAdapter<GroupLeftBean.DataBean,BaseViewHolder> {
    public GroupLeftAdapter(int layoutResId, @Nullable List<GroupLeftBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GroupLeftBean.DataBean item) {
           helper.setText(R.id.tv_show,item.getName());
    }
}
