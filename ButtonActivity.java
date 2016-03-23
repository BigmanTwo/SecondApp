package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Asus on 2016/3/23.
 */
public class ButtonActivity  extends AppCompatActivity  implements View.OnClickListener{
     private Button mButton;
    private Button mButton1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_button);
        mButton= (Button) findViewById(R.id.button);
        mButton1= (Button) findViewById(R.id.button2);
    }

    @Override
    public void onClick(View v) {

    }
}
