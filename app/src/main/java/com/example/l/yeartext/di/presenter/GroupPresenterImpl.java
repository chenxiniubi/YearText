package com.example.l.yeartext.di.presenter;

import com.example.l.yeartext.di.contract.GroupContract;
import com.example.l.yeartext.di.model.GroupModelImpl;

import java.lang.ref.SoftReference;

public class GroupPresenterImpl implements GroupContract.IPresenter<GroupContract.IView> {

    GroupContract.IView iView;
    private SoftReference<GroupContract.IView> reference;
    private GroupContract.IModel model;

    @Override
    public void attachView(GroupContract.IView iView) {
       this.iView = iView;
       //软
        reference = new SoftReference<>(iView);
        //M
        model = new GroupModelImpl();
    }

    @Override
    public void dettchView(GroupContract.IView iView) {
        reference.clear();
    }

    @Override
    public void requestGroupData() {
        model.containGroupData(new GroupContract.IModel.CallBack() {
            @Override
            public void onGroupCall(String s) {
                iView.groupData(s);
            }
        });
    }

    @Override
    public void requestShopData(int cid) {
        model.containShopData(cid,new GroupContract.IModel.CallBack() {
            @Override
            public void onGroupCall(String s) {
                iView.ShopData(s);
            }
        });
    }
}
