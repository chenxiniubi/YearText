package com.example.l.yeartext.di.model;

import android.util.Log;

import com.example.l.yeartext.data.constant.Constant;
import com.example.l.yeartext.di.contract.ShowContract;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class ShowModelImpl implements ShowContract.IModel{
    @Override
    public void containShowData(final CallBack callBack) {
        OkGo.<String>get(Constant.SHOW_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String s = response.body().toString();
                Log.i("cx", "onSuccess: =========="+s);
                callBack.onShowCall(s);
            }
        });
    }
}
