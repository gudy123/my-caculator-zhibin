package com.example.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.io.StringBufferInputStream;

import static android.R.attr.button;
import static android.R.attr.elegantTextHeight;
import static android.R.attr.flipInterval;

public class MainActivity extends AppCompatActivity  {
    boolean ifOncePoint=true;
    boolean ifResult=false;
    double firstNum=0;
    double secondNum=0;
    int operateID=0;
    ///  “数字”  点击事件
    private View.OnClickListener NumListener1 = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            TextView resulte = (TextView) findViewById(R.id.Text1);
            if(resulte.getText().toString().equals("TOO BIG"))   return;
            if (resulte.getText().equals("0")||(ifResult==true)||(operateID>=1)) {
                resulte.setText("");
                ifResult=false;
            }
            Button btn = (Button) view;
            resulte.setText(resulte.getText()+btn.getText().toString());
        }
    };
    private void setNumButtonListener(int viewId){     ///绑定数字键监听器
        Button bt=(Button)findViewById(viewId);
        bt.setOnClickListener(NumListener1);
    }
//    加减乘除  的点击事件
    private View.OnClickListener OperateListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            TextView resulte = (TextView) findViewById(R.id.Text1);
            Button btn = (Button) view;
            if(resulte.getText().toString().equals("TOO BIG"))   return;
            secondNum = firstNum = Double.parseDouble(resulte.getText().toString());
            if(btn.getText().equals("÷"))   operateID = 1;
            else if(btn.getText().equals("×"))  operateID = 2;
            else if(btn.getText().equals("-"))  operateID = 3;
            else if(btn.getText().equals("+"))  operateID = 4;
            ifOncePoint = true;
        }
    };
    private void setOperate1ButtonListener(int viewId){     ///绑定加减乘除监听器
        Button bt=(Button)findViewById(viewId);
        bt.setOnClickListener(OperateListener);
    }
//    第一行开根号、平方、倒数  点击事件
    private View.OnClickListener Line1Listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            TextView resulte = (TextView) findViewById(R.id.Text1);
            Button btnLine1 = (Button) view;
            if(resulte.getText().toString().equals("TOO BIG"))   return;
            String textStr = resulte.getText().toString();
            double lastNum = Double.parseDouble(textStr);
            double newNum;
            if(btnLine1.getText().equals("√"))  {
                if(textStr.charAt(0) == '-')  {       //判断数字是否为负数
                    resulte.setText("WrongNum");
                    return;
                }
                newNum = Math.sqrt(lastNum);
            }
            else if(btnLine1.getText().equals("x²"))    newNum = Math.pow(lastNum,2);   
            else newNum = 1 / lastNum;

            String newStr = Double.toString( newNum );
            int endline = newStr.length();
            if( endline > 16 )  resulte.setText( "TOO BIG" );
            else if(newStr.substring(newStr.length()-2,newStr.length()).equals(".0")){
                resulte.setText(newStr.substring(0,newStr.length()-2));
            }
            else resulte.setText(newStr);
            ifResult=true;
        }
    };
    private void setLine1ButtonListener(int viewId){     ///绑定加减乘除监听器
        Button bt=(Button)findViewById(viewId);
        bt.setOnClickListener(Line1Listener);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView resulte = (TextView) findViewById(R.id.Text1); //    获取TextView Text1 ，将其置为0
        resulte.setText("0");

        setNumButtonListener(R.id.Btn0);        //    开始添加按钮监听函数
        setNumButtonListener(R.id.Btn1);
        setNumButtonListener(R.id.Btn2);
        setNumButtonListener(R.id.Btn3);
        setNumButtonListener(R.id.Btn4);
        setNumButtonListener(R.id.Btn5);
        setNumButtonListener(R.id.Btn6);
        setNumButtonListener(R.id.Btn7);
        setNumButtonListener(R.id.Btn8);
        setNumButtonListener(R.id.Btn9);
        setOperate1ButtonListener(R.id.BtnDivision);
        setOperate1ButtonListener(R.id.BtnAdd);
        setOperate1ButtonListener(R.id.BtnSub);
        setOperate1ButtonListener(R.id.BtnMul);
        setLine1ButtonListener(R.id.BtnSqRoot);
        setLine1ButtonListener(R.id.BtnSqua);
        setLine1ButtonListener(R.id.BtnRecip);
    }
    public void ClickBtnDelete(View v){                        //    “删除”的点击事件
        TextView resulte=(TextView) findViewById(R.id.Text1);
        if(resulte.getText().toString().equals("TOO BIG"))   return;
        String str=resulte.getText().toString();     ///getText!!!s
        if(ifResult==true) return; ///如果是结果就不能删
        if(str.charAt(str.length()-1)=='.')   ifOncePoint=true;
        if(str.length()==1) {
            resulte.setText("0");
            return ;
        }
        if(str.equals("0")) return ;
        resulte.setText(str.substring(0,str.length()-1));
    }
//    “CE” 的点击事件
    public void ClickBtnCE (View v){
        TextView resulte = (TextView) findViewById(R.id.Text1);
        resulte.setText("0");
        ifOncePoint=true;
        ifResult=false;
    }
//       “ C” 的点击事件
    public  void ClickBtnC(View v){
        TextView resulte = (TextView) findViewById(R.id.Text1);
        if(resulte.getText().toString().equals("TOO BIG"))   return;
        resulte.setText("0");
        firstNum=0;
        ifOncePoint=true;
        ifResult=false;
    }
//    “正负转换” 的点击事件
    public void ClickBtnPorN(View v){
        TextView resulte = (TextView) findViewById(R.id.Text1);
        String str=resulte.getText().toString();
        if(str.equals("TOO BIG"))   return;
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
        if(str.equals("TOO BIG"))   return;
        if(ifOncePoint) {
            resulte.setText(str+".");
            ifOncePoint=false;       /// 等号 && delete && CE && C 中最后要变为true！！！！！！！！！！！！！！！！！！！！！！！！！！！
        } else {
            return;
        }
    }
//     “等号”的点击事件
    public  void ClickBtnEqua(View v){
        TextView resulte = (TextView)findViewById(R.id.Text1);
        double nowNum = Double.parseDouble(resulte.getText().toString());
        secondNum = nowNum;
        String newStr;
        switch (operateID){
            case 1:
                nowNum /= firstNum;
                newStr = Double.toString(nowNum);
                if(newStr.substring(newStr.length()-2,newStr.length()).equals(".0")){
                    resulte.setText(newStr.substring(0,newStr.length()-2));
                }
                else resulte.setText(newStr);
                ifResult = true;
                ifOncePoint = true;
                break;
            case 2:
                nowNum *= firstNum;
                newStr = Double.toString(nowNum);
                if(newStr.substring(newStr.length()-2,newStr.length()).equals(".0")){
                    resulte.setText(newStr.substring(0,newStr.length()-2));
                }
                else resulte.setText(newStr);
                ifResult = true;
                ifOncePoint = true;
                break;
            case 3:
                nowNum = firstNum-nowNum;
                newStr = Double.toString(nowNum);
                if(newStr.substring(newStr.length()-2,newStr.length()).equals(".0")){
                    resulte.setText(newStr.substring(0,newStr.length()-2));
                }
                else resulte.setText(newStr);
                ifResult = true;
                ifOncePoint = true;
                break;
            case 4:
                nowNum += firstNum;
                newStr = Double.toString(nowNum);
                if(newStr.substring(newStr.length()-2,newStr.length()).equals(".0")){
                    resulte.setText(newStr.substring(0,newStr.length()-2));
                }
                else resulte.setText(newStr);
                ifResult = true;
                ifOncePoint = true;
                break;
            default:break;   ///连加连减处理
        }
    }
}