package com.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;
    @Override//你好
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton= (Button) findViewById(R.id.button);
        mTextView= (TextView) findViewById(R.id.textView);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mTextView.setText("更改后的类容");
//                mTextView.setTextColor(Color.argb(0xff,0xf,0xff,0x00));
//                mTextView.setTextSize(20);//此处传入值是像素
//                mTextView.setAutoLinkMask(Linkify.ALL);//只能修改后面的文本权限
//                mTextView.setText("可以上网搜索http://www.baidu.com");
               // mTextView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.cat,R.mipmap.cat,
               //         R.mipmap.cat,R.mipmap.cat);
                //富文本
//                String html="<h1>标题</h1><h3>3好标题</h3><a href='http:\\www.bjlingzhuo.com>领卓</a>";
//                String html="<font color='#ff0000'>红</font><font color='#00ff00'>绿</font>";
//                Spanned spannned= Html.fromHtml(html);
//                mTextView.setText(spannned);
                String text="你好<img src='cat'></img>,我有图片<img src='ic_launcher'></img>";
                Spanned spanned=Html.fromHtml(text,new Html.ImageGetter() {
                    @Override
                    public Drawable getDrawable(String source) {
                        Drawable drawable=null;
                        Class clazz=R.mipmap.class;
                        try {
                            Field field=clazz.getDeclaredField(source);
                            int id=field.getInt(null);//使用反射机制得到mipmap.ic_launcher的值
                            drawable=getResources().getDrawable(id);//使用资源的到id
                            //设置图片的宽高
                            drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        return drawable;
                    }
            },null);
                mTextView.setText(spanned);
            }
        });
    }




}
