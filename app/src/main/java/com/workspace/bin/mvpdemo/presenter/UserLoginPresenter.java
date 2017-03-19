package com.workspace.bin.mvpdemo.presenter;

import android.os.Handler;

import com.workspace.bin.mvpdemo.Bean.User;
import com.workspace.bin.mvpdemo.biz.IUserBiz;
import com.workspace.bin.mvpdemo.biz.OnLoginListener;
import com.workspace.bin.mvpdemo.biz.UserBiz;
import com.workspace.bin.mvpdemo.view.IUserLoginView;

/**
 * Created by bin on 2017/3/19.
 */

public class UserLoginPresenter {
    private IUserBiz iUserBiz;
    private IUserLoginView iUserLoginView;
    private Handler handler = new Handler();

    public UserLoginPresenter(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
        this.iUserBiz = new UserBiz();
    }

    public void login() {
        iUserLoginView.showLoading();
        iUserBiz.login(iUserLoginView.getUsername(), iUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toMainActivity(user);
                        iUserLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.showFailedError();
                        iUserLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        iUserLoginView.clearUsername();
        iUserLoginView.clearPassword();
    }
}
