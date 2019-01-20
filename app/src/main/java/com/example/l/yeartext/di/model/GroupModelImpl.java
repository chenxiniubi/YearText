package com.example.l.yeartext.di.model;

import android.util.Log;

import com.example.l.yeartext.data.constant.Constant;
import com.example.l.yeartext.di.contract.GroupContract;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class GroupModelImpl implements GroupContract.IModel {
    @Override
    public void containGroupData(final CallBack callBack) {
        OkGo.<String>get(Constant.LEFT_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String s = response.body().toString();
                Log.i("cxx", "onSuccess: ========="+s);
                callBack.onGroupCall(s);
            }
        });
    }

    @Override
    public void containShopData(int cid, final CallBack callBack) {
        OkGo.<String>get(Constant.RIGHT_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String s = response.body().toString();
                callBack.onGroupCall(s);
            }
        });
    }
}
