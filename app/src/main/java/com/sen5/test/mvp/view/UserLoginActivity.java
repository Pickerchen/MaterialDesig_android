package com.sen5.test.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sen5.test.R;
import com.sen5.test.mvp.presenter.UserLoginPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    @Bind(R.id.tv_userName)
    TextView mTvUserName;
    @Bind(R.id.et_userName)
    EditText mEtUserName;
    @Bind(R.id.et_passWord)
    EditText mEtPassWord;
    @Bind(R.id.btn_login)
    Button mBtnLogin;
    @Bind(R.id.btn_clear)
    Button mBtnClear;
    @Bind(R.id.activity_user_login)
    LinearLayout mActivityUserLogin;
    @Bind(R.id.pb_loading)
    ProgressBar mPbLoading;
    private UserLoginPresenter mUserLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);
        mUserLoginPresenter = new UserLoginPresenter(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mUserLoginPresenter.login();
                break;
            case R.id.btn_clear:
                mUserLoginPresenter.clear();
                break;
        }
    }

    @Override
    public void clear() {
        mEtPassWord.setText("");
        mEtUserName.setText("");
    }

    @Override
    public String getUserName() {
        return mEtUserName.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mEtPassWord.getText().toString();
    }

    @Override
    public void showSuccess() {
        mPbLoading.setVisibility(View.GONE);
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFail() {
        mPbLoading.setVisibility(View.GONE);
        Toast.makeText(this, "验证失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void disMissProgressBar() {
        mPbLoading.setVisibility(View.GONE);
    }
}
