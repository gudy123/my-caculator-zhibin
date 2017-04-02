package com.example.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.io.StringBufferInputStream;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        获取TextView Text1 ，将其置为0
        TextView tV=(TextView) findViewById(R.id.Text1);
        tV.setText("0");

        //    //添加按钮监听函数
        Button btn1 = (Button) findViewById(R.id.Btn1);
        Button btn2 = (Button) findViewById(R.id.Btn2);
        Button btn3 = (Button) findViewById(R.id.Btn3);
        Button btn4 = (Button) findViewById(R.id.Btn4);
        Button btn5 = (Button) findViewById(R.id.Btn5);
        Button btn6 = (Button) findViewById(R.id.Btn6);
        Button btn7 = (Button) findViewById(R.id.Btn7);
        Button btn8 = (Button) findViewById(R.id.Btn8);
        Button btn9 = (Button) findViewById(R.id.Btn9);
        Button btn0 = (Button) findViewById(R.id.BtnZero);

        btn1.setOnClickListener(this );
        btn2.setOnClickListener(this );
        btn3.setOnClickListener(this );
        btn4.setOnClickListener(this );
        btn5.setOnClickListener(this );
        btn6.setOnClickListener(this );
        btn7.setOnClickListener(this );
        btn8.setOnClickListener(this );
        btn9.setOnClickListener(this );
        btn0.setOnClickListener(this );
    }
    @Override
    public void onClick(View v) {
        TextView tV = (TextView) findViewById(R.id.Text1);
        if (tV.getText() == "0") tV.setText("");
        switch (v.getId()) {
            case R.id.Btn1:
                tV.setText(tV.getText()+"1");
                break;
            case R.id.Btn2:
                tV.setText(tV.getText()+"2");
                break;
            case R.id.Btn3:
                tV.setText(tV.getText()+"3");
                break;
            case R.id.Btn4:
                tV.setText(tV.getText()+"4");
                break;
            case R.id.Btn5:
              tV.setText(tV.getText()+"5");
                break;
            case R.id.Btn6:
              tV.setText(tV.getText()+"6");
                break;
            case R.id.Btn7:
              tV.setText(tV.getText()+"7");
                break;
            case R.id.Btn8:
              tV.setText(tV.getText()+"8");
                break;
            case R.id.Btn9:
              tV.setText(tV.getText()+"9");
                break;
            case R.id.BtnZero:
                tV.setText(tV.getText()+"0");
                break;
        }
    }

    public void ClickBtnDelet(View v){
        TextView tV=(TextView) findViewById(R.id.Text1);
        StringBuffer str = new StringBuffer(R.id.Text1);
        str.deleteCharAt(str.length()-1);
        tV.setText(str.toString());
    }
}