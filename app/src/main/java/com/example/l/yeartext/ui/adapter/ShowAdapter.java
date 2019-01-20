package com.example.l.yeartext.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.l.yeartext.R;
import com.example.l.yeartext.data.bean.ShowBean;

import java.util.List;

public class ShowAdapter extends BaseQuickAdapter<ShowBean.ResultsBean,BaseViewHolder>{
    public ShowAdapter(int layoutResId, @Nullable List<ShowBean.ResultsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShowBean.ResultsBean item) {
        ImageView imag_icon = helper.getView(R.id.img_icon);
        Glide.with(mContext).load(item.getUrl()).into(imag_icon);
    }
}
