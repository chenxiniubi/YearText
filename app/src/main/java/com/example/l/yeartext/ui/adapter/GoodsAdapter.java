package com.example.l.yeartext.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.l.yeartext.R;
import com.example.l.yeartext.data.bean.GroupRightBean;

import java.util.List;

public class GoodsAdapter extends BaseQuickAdapter<GroupRightBean.DataBean.ListBean,BaseViewHolder> {
    public GoodsAdapter(int layoutResId, @Nullable List<GroupRightBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GroupRightBean.DataBean.ListBean item) {
         helper.setText(R.id.tv_goods_title,item.getName());
        ImageView iv_goods_icon = helper.getView(R.id.iv_goods_icon);
        Glide.with(mContext).load(item.getIcon()).into(iv_goods_icon);
    }
}
