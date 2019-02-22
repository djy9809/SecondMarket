package com.example.djy.secondmarket.Fragment.Me;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.Resource;
import com.example.djy.secondmarket.Fragment.Me.mode.UserBO;
import com.example.djy.secondmarket.Fragment.MeFragment;
import com.example.djy.secondmarket.MainActivity;
import com.example.djy.secondmarket.R;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class Login extends AppCompatActivity {
    private EditText et_uname,et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

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

        et_uname = (EditText)findViewById(R.id.et_uname);
        et_password = (EditText)findViewById(R.id.et_password);
        btn_login = (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = et_uname.getText().toString().trim();//.getText()获取文本，.toString()转成string类型,.trim()去掉前后空白
                String upassword = et_password.getText().toString().trim();

                Log.i("Test","unamer is:"+uname);
                Log.i("Test","upassword is:"+upassword);

                Resources res = getResources();
                Bitmap bmp = BitmapFactory.decodeResource(res,R.drawable.ding);//从drawable中取一个图片（以后大家需要从相册中取，或者相机中取）。
                //读取一个资源文件得到一个位图。如果位图数据不能被解码，或者opts参数只请求大小信息时，则返回NuLL。
                //（即当Options.inJustDecodeBounds=true,只请求图片的大小信息。）-->public static Bitmap decodeResource(Resources res, int id)
                byte[] uimages = Bitmap2Bytes(bmp);

                register( uname ,upassword.toString() , uimages );
            }
        });

    }

    private void register(String uname,String upassword,byte[] uimages){

        UserBO userBO = new UserBO();
        String uuid = UUID.randomUUID().toString();
        userBO.setUid(uuid);
        userBO.setUname(uname);
        userBO.setUpassword(upassword);
        userBO.setUimage(uimages);

        Gson gson = new Gson();
        String userJsonStr = gson.toJson(userBO,UserBO.class);
        Log.i("Test","jsonStr is :"+userJsonStr);

        String url = "http://192.168.0.184:8081/Proj13/login";
        sendRequest(url, userJsonStr);//（发给谁？，发什么？）
    }

    public void sendRequest(String url,String jsonStr){

        OkHttpClient client = new OkHttpClient();


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


}

