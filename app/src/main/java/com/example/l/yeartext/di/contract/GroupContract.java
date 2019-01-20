package com.example.l.yeartext.di.contract;

public interface GroupContract {
    //V
    public interface IView{
        public void groupData(String s);
        public void ShopData(String s);
    }
    //P
    public interface IPresenter<T>{
        public void attachView(T t);
        public void dettchView(T t);
        public void requestGroupData();
        public void requestShopData(int cid);
    }
    //M
    public interface IModel{
        public void containGroupData(CallBack callBack);
        public void containShopData(int cid, CallBack callBack);
        public interface CallBack{
            public void onGroupCall(String s);
        }
    }
}
