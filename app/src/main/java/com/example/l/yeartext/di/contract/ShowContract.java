package com.example.l.yeartext.di.contract;

public interface ShowContract  {
    //V
    public interface IView{
        public void showData(String s);
    }
    //P
    public interface IPresenter<T>{
        public void attachView(T t);
        public void dettchView(T t);
        public void requestShowData();
    }
    //M
    public interface IModel{
        public void containShowData(CallBack callBack);
        public interface CallBack{
             public void onShowCall(String s);
        }
    }
}
