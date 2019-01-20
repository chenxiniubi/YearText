package com.example.l.yeartext.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.l.yeartext.R;
import com.example.l.yeartext.data.bean.GroupRightBean;

import java.util.List;

public class GroupRightAdapter extends BaseQuickAdapter<GroupRightBean.DataBean,BaseViewHolder>{
    public GroupRightAdapter(int layoutResId, @Nullable List<GroupRightBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GroupRightBean.DataBean item) {
         helper.setText(R.id.tv_detail_title,item.getName());
        RecyclerView rv_goods = helper.getView(R.id.rv_goods);
        //商品条目
        List<GroupRightBean.DataBean.ListBean> beanList = item.getList();
        //布局管理器
        GridLayoutManager manager = new GridLayoutManager(mContext, 3, GridLayoutManager.VERTICAL, false);
        rv_goods.setLayoutManager(manager);
        GoodsAdapter adapter = new GoodsAdapter(R.layout.goods_itm, beanList);
        rv_goods.setAdapter(adapter);
    }
}
