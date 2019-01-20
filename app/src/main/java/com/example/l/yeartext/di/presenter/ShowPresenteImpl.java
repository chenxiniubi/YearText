package com.example.l.yeartext.di.presenter;

import com.example.l.yeartext.di.model.ShowModelImpl;
import com.example.l.yeartext.di.contract.ShowContract;

import java.lang.ref.SoftReference;

public class ShowPresenteImpl implements ShowContract.IPresenter<ShowContract.IView> {

    ShowContract.IView iView;
    private SoftReference<ShowContract.IView> reference;
    private ShowContract.IModel model;

    @Override
    public void attachView(ShowContract.IView iView) {
         this.iView = iView;
         //软
        reference = new SoftReference<>(iView);
        //创建M
        model = new ShowModelImpl();
    }

    @Override
    public void dettchView(ShowContract.IView iView) {
        reference.clear();
    }

    @Override
    public void requestShowData() {
        model.containShowData(new ShowContract.IModel.CallBack() {
            @Override
            public void onShowCall(String s) {
                iView.showData(s);
            }
        });
    }
}
