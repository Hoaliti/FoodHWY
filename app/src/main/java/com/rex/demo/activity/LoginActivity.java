package com.rex.demo.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rex.demo.presenter.Login;
import com.rex.demo.view.LoginView;
import com.rex.demo.R;

public class LoginActivity extends BaseActivity implements LoginView {
    private EditText mUserName,mPassword;
    private Login login;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        super.init();
        getSupportActionBar().hide();
        login = new Login(this);

        Button login_Button = findViewById(R.id.login);
        mUserName = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);

        login_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                hideKeyBoard();
                onStartLogin();
            }
        });

    }

    @Override
    public void onStartLogin() {
        login.login();
    }

    @Override
    public void onLoginSuccess() {
        Log.d("Login","Success!");
        toast(getString(R.string.login_success));
        switchToHome();
    }

    @Override
    public void onLoginFailed() {
        Log.d("Login","Failed!");
        toast(getString(R.string.login_fail));
    }
}
