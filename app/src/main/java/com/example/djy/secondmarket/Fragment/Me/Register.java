package com.example.djy.secondmarket.Fragment.Me;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.djy.secondmarket.Fragment.Me.mode.LoginBO;
import com.example.djy.secondmarket.Fragment.Me.mode.RegisterBO;
import com.example.djy.secondmarket.Fragment.Me.mode.UserBO;
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

public class Register extends AppCompatActivity {

    private EditText et_username,et_password;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        et_username = (EditText) findViewById(R.id.Edit_username);
        et_password = (EditText) findViewById(R.id.Edit_password);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
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
                String url = "http://118.89.217.225:8080/Proj20/register";

                UserBO user = new UserBO();
                Resources res = getResources();
                Bitmap bmp = BitmapFactory.decodeResource(res,R.drawable.ding);//从drawable中取一个图片（以后大家需要从相册中取，或者相机中取）。
                //读取一个资源文件得到一个位图。如果位图数据不能被解码，或者opts参数只请求大小信息时，则返回NuLL。
                //（即当Options.inJustDecodeBounds=true,只请求图片的大小信息。）-->public static Bitmap decodeResource(Resources res, int id)
                byte[] uimages = Bitmap2Bytes(bmp);

                String uname = et_username.getText().toString().trim();//.getText()获取文本，.toString()转成string类型,.trim()去掉前后空白
                String upassword = et_password.getText().toString().trim();
                user.setOpType("90001");
                user.setUname(uname);
                user.setUpassword(upassword);
               // user.setUimage(uimages);

                Gson gson = new Gson();
                String jsonStr = gson.toJson(user,UserBO.class);

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
                            Log.i("test","response.body().string()==" + s);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Register.this,s,Toast.LENGTH_SHORT).show();

                                    Gson gson = new Gson();
                                    LoginBO LoginBO = gson.fromJson(s,LoginBO.class);
                                    LoginBO bo = new LoginBO();
                                    Log.i("test", "LoginBO is :" + LoginBO.toString());
                                    bo.getFlag();
                                    bo.getMessage();
                                    bo.getToken();
                                    int flag = bo.getFlag();
                                    if (flag == 200){

                                        Intent intent_login = new Intent(Register.this,Login.class);
                                        startActivity(intent_login);

                                    }
                                }
                            });

                        }
                    }
                });

            }
        }).start();

    }
    // bitmp转bytes
    public byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
