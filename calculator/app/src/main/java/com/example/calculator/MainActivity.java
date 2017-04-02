package com.example.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

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
        switch (v.getId()) {
            case R.id.Btn1:
                if (tV.getText() == "0") tV.setText("");
                tV.setText("1");
                break;
            case R.id.Btn2:
                if (tV.getText() == "0") tV.setText("");
                tV.setText("2");
                break;
            case R.id.Btn3:
                if (tV.getText() == "0") tV.setText("");
                tV.setText("3");
                break;
            case R.id.Btn4:
                if (tV.getText() == "0") tV.setText("");
                tV.setText("4");
                break;
            case R.id.Btn5:
                if (tV.getText() == "0") tV.setText("");
                tV.setText("5");
                break;
            case R.id.Btn6:
                if (tV.getText() == "0") tV.setText("");
                tV.setText("6");
                break;
            case R.id.Btn7:
                if (tV.getText() == "0") tV.setText("");
                tV.setText("7");
                break;
            case R.id.Btn8:
                if (tV.getText() == "0") tV.setText("");
                tV.setText("8");
                break;
            case R.id.Btn9:
                if (tV.getText() == "0") tV.setText("");
                tV.setText("9");
                break;
            case R.id.BtnZero:
                if (tV.getText() == "0") tV.setText("");
                tV.setText("0");
                break;
        }
    }
}