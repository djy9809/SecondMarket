package com.example.djy.secondmarket.Fragment.Me;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djy.secondmarket.Fragment.Me.mode.LoginBO;
import com.example.djy.secondmarket.Fragment.Me.mode.LoginUser;
import com.example.djy.secondmarket.Fragment.Me.mode.RegisterBO;
import com.example.djy.secondmarket.R;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.djy.secondmarket.R.layout.login;

public class Login extends AppCompatActivity{
    private EditText et_uname,et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //点击注册、忘记密码、界面跳转
        Button b_register = (Button) findViewById(R.id.btn_register);
        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_register = new Intent(Login.this, Register.class);
                startActivity(intent_register);
            }
        });
        TextView t_foget = (TextView) findViewById(R.id.t_forget);
        t_foget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_forget = new Intent(Login.this, ForgetPassword.class);
                startActivity(intent_forget);
            }
        });

        //绑定布局
        et_uname = (EditText)findViewById(R.id.et_uname);
        et_password = (EditText)findViewById(R.id.et_password);
        btn_login = (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPostHttpRequest();
            }
        });

    }

    private void sendPostHttpRequest() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                String url ="http://118.89.217.225:8080/Proj20/login";
                LoginUser user = new LoginUser();
                String uname = et_uname.getText().toString().trim();//.getText()获取文本，.toString()转成string类型,.trim()去掉前后空白
                String upassword = et_password.getText().toString().trim();
                Gson gson = new Gson();
                user.setOpType("90002");
                user.setUname(uname);
                user.setUpassword(upassword);
                String jsonStr = gson.toJson(user,LoginUser.class);
                RequestBody requestBody = new FormBody.Builder()
                        .add("reqJson",jsonStr)
                        .build();
                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i("test", "获取数据失败" + e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()){
                            final String s = response.body().string();
                            Log.i("test", "response.body().string()==" + s);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Login.this,s,Toast.LENGTH_SHORT).show();
                                }
                            });
                            Gson gson = new Gson();
                            LoginBO loginBO = gson.fromJson(s,LoginBO.class);
                            LoginBO bo = new LoginBO();
                            Log.i("test", "LoginBO is :" + loginBO.toString());
                            bo.getFlag();
                            bo.getMessage();
                            bo.getToken();
                        }
                    }
                });
            }
        }).start();

    }


    @Override
    public boolean onKeyDown ( int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//点击完返回键，执行的动作
            Login.this.finish();
        }
        return true;
    }

    // bitmp转bytes
    public byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
    // bytes转bitmap
    public Bitmap Bytes2Bimap(byte[] b) {
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        } else {
            return null;
        }
    }

    // bitmap 缩放
    public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) width / w);
        float scaleHeight = ((float) height / h);
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
        return newbmp;
    }


}

