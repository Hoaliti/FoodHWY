package com.rex.demo.presenter;



import com.rex.demo.view.LoginView;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Login implements LoginPresenter {
    private LoginView mLoginView;


    public Login(LoginView loginView){
        mLoginView = loginView;
    }

    @Override
    public void login() {
        Thread loginThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://php7.foodhwy.net/api/login";
                String userName = "6479891678";
                String pwd = "cfb326cd57";
                OkHttpClient client = new OkHttpClient();
                RequestBody body = new FormBody.Builder()
                        .add("username",userName)
                        .add("password",pwd)
                        .build();
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                try{
                    Response response = client.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }

                    String result = "";
                    result = response.body().string();
                    JSONObject jsonResponse = new JSONObject(result);
                    if(jsonResponse.get("status").equals(1)){
                        mLoginView.onLoginSuccess();
                    }else{
                        mLoginView.onLoginFailed();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        loginThread.start();
    }

}
