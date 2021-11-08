package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button num1;
    Button num2;
    Button num3;
    Button num4;
    Button num5;
    Button num6;
    Button num7;
    Button num8;
    Button num9;
    Button num0;

    Button add;
    Button minus;
    Button mul;
    Button divide;
    Button equal;
    Button clear;

    Button advance;

    TextView standardResult;
    TextView advanceResult;
    String calcStr = "";
    int mode = 1;
    Calculator obj = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (Button) findViewById(R.id.button1);
        num2 = (Button) findViewById(R.id.button2);
        num3 = (Button) findViewById(R.id.button3);
        num4 = (Button) findViewById(R.id.button4);
        num5 = (Button) findViewById(R.id.button5);
        num6 = (Button) findViewById(R.id.button6);
        num7 = (Button) findViewById(R.id.button7);
        num8 = (Button) findViewById(R.id.button8);
        num9 = (Button) findViewById(R.id.button9);
        num0 = (Button) findViewById(R.id.button11);

        equal = (Button) findViewById(R.id.buttonequal);
        clear = (Button) findViewById(R.id.button10);

        add = (Button) findViewById(R.id.buttonplus);
        minus = (Button) findViewById(R.id.buttonminus);
        mul = (Button) findViewById(R.id.buttonmultipication);
        divide = (Button) findViewById(R.id.buttondivide);
        advance = (Button) findViewById(R.id.buttonAdvance);
        standardResult = (TextView) findViewById(R.id.display_text);
        advanceResult = (TextView) findViewById(R.id.advanceDisplay);

        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        num0.setOnClickListener(this);
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        mul.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
        advance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String data = ((Button) v).getText().toString();
        if (v == clear) {
            obj.clear();
            calcStr = "";

            standardResult.setText("0.00");
        } else if (v == equal) {

            calcStr += "=" + obj.calculate();
            standardResult.setText(calcStr);
            obj.printHistory(calcStr);
            // advanceResult.setText(calcStr);
        } else if (v == advance) {

            if ( mode == 1) {
                advanceResult.setVisibility(View.VISIBLE);
                // obj.printHistory();
                for (int i = 0; i < obj.newArray.toArray().length; i++)
                    advanceResult.setText(advanceResult.getText()+"\n" + obj.newArray.get(i));
                advance.setText("advance-with history");
                mode =0;
            }
            else{
                mode = 1;
                advance.setText("Standard - No history");
                advanceResult.setText("");
            }
        } else {
            obj.push(data);
            calcStr += data;
            standardResult.setText(calcStr);

        }
    }
}