package com.sen5.test.mvp.biz;

/**
 * Created by chenqianghua on 2017/2/9.
 */

public class UserLogin {

    public void login(final String userName, final String passWord, final ILoginCallBack back){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if (userName.equals("cqh")&&passWord.equals("123")){
                        back.loginSuccess();
                    }
                    else {
                        back.loginFail();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
