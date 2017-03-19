package com.workspace.bin.mvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.workspace.bin.mvpdemo.Bean.User;
import com.workspace.bin.mvpdemo.presenter.UserLoginPresenter;
import com.workspace.bin.mvpdemo.view.IUserLoginView;

public class UserLoginActivity extends AppCompatActivity implements View.OnClickListener,IUserLoginView {
    private EditText et_user, et_pwd;
    private Button btn_login, btn_clear;
    private ProgressBar progressBar;
    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initView();
        initAction();
    }

    private void initAction() {
        btn_clear.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    private void initView() {
        et_user = (EditText) findViewById(R.id.username);
        et_pwd = (EditText) findViewById(R.id.pwd);
        btn_login = (Button) findViewById(R.id.login);
        btn_clear = (Button) findViewById(R.id.clear);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                userLoginPresenter.login();
                break;
            case R.id.clear:
                userLoginPresenter.clear();
                break;
            default:
                break;
        }
    }

    @Override
    public String getUsername() {
        return et_user.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_pwd.getText().toString();
    }

    @Override
    public void clearPassword() {
        et_user.setText("");
    }

    @Override
    public void clearUsername() {
        et_pwd.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
