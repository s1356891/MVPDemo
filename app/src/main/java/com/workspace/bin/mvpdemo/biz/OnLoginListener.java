package com.workspace.bin.mvpdemo.biz;

import com.workspace.bin.mvpdemo.Bean.User;

/**
 * Created by bin on 2017/3/19.
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
