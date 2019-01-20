package com.example.l.yeartext.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.l.yeartext.R;
import com.example.l.yeartext.data.bean.ShowBean;
import com.example.l.yeartext.di.contract.ShowContract;
import com.example.l.yeartext.di.presenter.ShowPresenteImpl;
import com.example.l.yeartext.ui.adapter.ShowAdapter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FirstFragment extends Fragment implements ShowContract.IView {

    @BindView(R.id.ed_text)
    EditText edText;

    Unbinder unbinder;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ShowContract.IPresenter presente;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        //创建P
        presente = new ShowPresenteImpl();
        presente.attachView(this);
//        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
//            @Override
//            public void onRefresh() {
                presente.requestShowData();
//            }
//
//            @Override
//            public void onLoadMore() {
//
//                presente.requestShowData();
//            }
//        });
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showData(String s) {
        Log.i("cx", "showData: =============" + s);
        Gson gson = new Gson();
        ShowBean showBean = gson.fromJson(s, ShowBean.class);
        List<ShowBean.ResultsBean> beanList = showBean.getResults();
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        ShowAdapter adapter = new ShowAdapter(R.layout.recycler_item, beanList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
