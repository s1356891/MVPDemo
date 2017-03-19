package com.workspace.bin.mvpdemo.view;

import com.workspace.bin.mvpdemo.Bean.User;

/**
 * Created by bin on 2017/3/19.
 */

public interface IUserLoginView {
    String getUsername();
    String getPassword();
    void clearPassword();
    void clearUsername();
    void showLoading();
    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
