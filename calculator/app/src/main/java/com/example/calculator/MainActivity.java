package com.example.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.io.StringBufferInputStream;

import static android.R.attr.button;
import static android.R.attr.flipInterval;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    boolean ifOncePoint=true;
    boolean ifResult=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        获取TextView Text1 ，将其置为0
        TextView resulte=(TextView) findViewById(R.id.Text1);
        resulte.setText("0");

        //    添加按钮监听函数
        Button btn1 = (Button) findViewById(R.id.Btn1);
        Button btn2 = (Button) findViewById(R.id.Btn2);
        Button btn3 = (Button) findViewById(R.id.Btn3);
        Button btn4 = (Button) findViewById(R.id.Btn4);
        Button btn5 = (Button) findViewById(R.id.Btn5);
        Button btn6 = (Button) findViewById(R.id.Btn6);
        Button btn7 = (Button) findViewById(R.id.Btn7);
        Button btn8 = (Button) findViewById(R.id.Btn8);
        Button btn9 = (Button) findViewById(R.id.Btn9);
        Button btn0 = (Button) findViewById(R.id.Btn0);

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

//    数字键 onclick
    public void onClick(View v) {
        TextView resulte= (TextView) findViewById(R.id.Text1);
        if (resulte.getText().equals("0")||(ifResult==true))
        {
           // Log.e("here","ppp");///调试用的案例
            resulte.setText("");
            ifResult=false;
        }
        switch (v.getId()) {
            case R.id.Btn1:
                resulte.setText(resulte.getText()+"1");
                break;
            case R.id.Btn2:
                resulte.setText(resulte.getText()+"2");
                break;
            case R.id.Btn3:
                resulte.setText(resulte.getText()+"3");
                break;
            case R.id.Btn4:
                resulte.setText(resulte.getText()+"4");
                break;
            case R.id.Btn5:
              resulte.setText(resulte.getText()+"5");
                break;
            case R.id.Btn6:
              resulte.setText(resulte.getText()+"6");
                break;
            case R.id.Btn7:
              resulte.setText(resulte.getText()+"7");
                break;
            case R.id.Btn8:
              resulte.setText(resulte.getText()+"8");
                break;
            case R.id.Btn9:
              resulte.setText(resulte.getText()+"9");
                break;
            case R.id.Btn0:
                resulte.setText(resulte.getText()+"0");
                break;
        }

    }

    //  求”平方根“的点击事件
    public void ClickBtnSqRoot(View v){
        TextView resulte = (TextView) findViewById(R.id.Text1);
        String textStr=resulte.getText().toString();
        double lastNum =Double.parseDouble(textStr);
        double  newNum =Math.sqrt(lastNum);
        String secondString=Double.toString(newNum);
        int endline=secondString.length();

        if(textStr.charAt(0)=='-')  {       //判断数字是否为负数
            resulte.setText("wrong");
            return;
        }
        if(endline>=8)  endline=8;
        String newStr=Double.toString(newNum).substring(0,endline);       ///设置输出位数不大于8位字符

        resulte.setText(newStr);
        ifResult=true;
    }

//    “平方”的点击事件
    public void ClickBtnSqua(View v){
        TextView resulte = (TextView) findViewById(R.id.Text1);
        String textString=resulte.getText().toString();
        double lastNum = Double.parseDouble(textString);
        double  newNum = Math.pow(lastNum,2);
        String secondString = Double.toString(newNum);
        int endline=secondString.length();

        if(endline>=8)  endline=8;
        String newStr=Double.toString(newNum).substring(0,endline);       ///设置输出位数不大于8位字符

        resulte.setText(newStr);
        ifResult=true;
    }
//        “倒数”的点击事件
    public void ClickBtnRecip(View v){
        TextView resulte = (TextView) findViewById(R.id.Text1);
        String textString=resulte.getText().toString();
        double lastNum = Double.parseDouble(textString);
        double  newNum = 1/lastNum;
        String secondString = Double.toString(newNum);
        int endline=secondString.length();

        if(endline>=8)  endline=8;
        String newStr=Double.toString(newNum).substring(0,endline);       ///设置输出位数不大于8位字符

        resulte.setText(newStr);
        ifResult=true;

    }
//    “删除”的点击事件
    public void ClickBtnDelete(View v){
        TextView resulte=(TextView) findViewById(R.id.Text1);
        String str=resulte.getText().toString();     ///getText!!!s
        if(str.charAt(str.length()-1)=='.')   ifOncePoint=true;
        if(str.length()==1) {
            resulte.setText("0");
            return ;
        }
        if(str.equals("0")) return ;
        resulte.setText(str.substring(0,str.length()-1));
//        StringBuffer str = new StringBuffer(resulte.getText().toString());
//        str.deleteCharAt(str.length()-1);
//        resulte.setText(str.toString());
    }

//    “CE” 的点击事件
    public void ClickBtnCE (View v){
        TextView resulte = (TextView) findViewById(R.id.Text1);
        resulte.setText("0");
        ifOncePoint=true;
        ifResult=false;
    }

//    “正负转换” 的点击事件
    public void ClickBtnPorN(View v){
        TextView resulte = (TextView) findViewById(R.id.Text1);
        String str=resulte.getText().toString();
        if(str.charAt(0)=='-')
            resulte.setText(str.substring(1,str.length()));
        else if((str.charAt(0)=='0')&&(str.length()==1))
            return;
        else
            resulte.setText("-"+str);

    }

//    “小数点”  的点击事件
    public void ClickBtnPoint(View v){
        TextView resulte = (TextView) findViewById(R.id.Text1);
        String str=resulte.getText().toString();
        if(ifOncePoint) {
            resulte.setText(str+".");
            ifOncePoint=false;       /// 等号 && delete && CE && C 中最后要变为true！！！！！！！！！！！！！！！！！！！！！！！！！！！
        }
        else {
            return;
        }
    }
}