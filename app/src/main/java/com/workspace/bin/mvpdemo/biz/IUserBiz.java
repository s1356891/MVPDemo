package com.workspace.bin.mvpdemo.biz;

/**
 * Created by bin on 2017/3/19.
 */

public interface IUserBiz {
    void login(String username, String password, OnLoginListener loginListener);
}
