package com.sen5.test.mvp.view;

/**
 * Created by chenqianghua on 2017/2/9.
 */

public interface IUserLoginView {
    public void clear();
    public String getUserName();
    public String getPassWord();
    public void showSuccess();
    public void showFail();
    public void showProgressBar();
    public void disMissProgressBar();
}
