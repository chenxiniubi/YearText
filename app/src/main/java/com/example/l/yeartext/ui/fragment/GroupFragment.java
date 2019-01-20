package com.example.l.yeartext.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.l.yeartext.R;
import com.example.l.yeartext.data.bean.GroupLeftBean;
import com.example.l.yeartext.data.bean.GroupRightBean;
import com.example.l.yeartext.di.contract.GroupContract;
import com.example.l.yeartext.di.presenter.GroupPresenterImpl;
import com.example.l.yeartext.ui.adapter.GroupLeftAdapter;
import com.example.l.yeartext.ui.adapter.GroupRightAdapter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GroupFragment extends Fragment implements GroupContract.IView {

    @BindView(R.id.rv_show)
    RecyclerView rvShow;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    Unbinder unbinder;
    private GroupContract.IPresenter presenter;
    private List<GroupLeftBean.DataBean> beanList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_fragment, container, false);
        //P
        presenter = new GroupPresenterImpl();
        presenter.attachView(this);
        presenter.requestGroupData();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void groupData(String s) {
        Log.i("cxx", "groupData: =====" + s);
        Gson gson = new Gson();
        GroupLeftBean groupLeftBean = gson.fromJson(s, GroupLeftBean.class);
        beanList = groupLeftBean.getData();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvShow.setLayoutManager(manager);
        GroupLeftAdapter adapter = new GroupLeftAdapter(R.layout.group_left_item, beanList);
        rvShow.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //获取请求参数
                int cid = beanList.get(position).getCid();
                //点击触发商品
                presenter.requestShopData(cid);
            }
        });
    }

    @Override
    public void ShopData(String s) {
        Gson gson = new Gson();
        GroupRightBean groupRightBean = gson.fromJson(s, GroupRightBean.class);
        List<GroupRightBean.DataBean> beanList1 = groupRightBean.getData();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(manager);
        GroupRightAdapter adapter = new GroupRightAdapter(R.layout.shop_item, beanList1);
        rvList.setAdapter(adapter);
        
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.dettchView(this);
        unbinder.unbind();
    }
}
