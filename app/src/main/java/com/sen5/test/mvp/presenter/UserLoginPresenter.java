package com.sen5.test.mvp.presenter;

import android.os.Handler;

import com.sen5.test.mvp.biz.ILoginCallBack;
import com.sen5.test.mvp.biz.UserLogin;
import com.sen5.test.mvp.view.IUserLoginView;

/**
 * Created by chenqianghua on 2017/2/9.
 */

public class UserLoginPresenter {
    private IUserLoginView mIUserLoginView;
    private UserLogin mUser;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView IUserLoginView) {
        this.mIUserLoginView = IUserLoginView;
        this.mUser = new UserLogin();
    }

    public void login(){
        mIUserLoginView.showProgressBar();
        mUser.login(mIUserLoginView.getUserName(), mIUserLoginView.getPassWord(), new ILoginCallBack() {
            @Override
            public void loginSuccess() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mIUserLoginView.showSuccess();
                    }
                });
            }

            @Override
            public void loginFail() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mIUserLoginView.showFail();
                    }
                });
            }
        });

    }
    public void clear(){
        mIUserLoginView.clear();
    }
}
