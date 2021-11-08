package com.example.calculatorapp;

import java.util.ArrayList;

public class Calculator {
    String MyArray[] = new String[10];
    ArrayList<String> newArray = new ArrayList<String>();    // declare arraylist for History button
    int index = 0;
    int finalResult ;

    public void push(String value) {
        MyArray[index] = value;
        index++;
    }
    int calculate() {
        boolean moreOp = false;
      //  int index = 0;
        for (int i = 0; i < MyArray.length; i++) {
            if ((MyArray[i] !=null) &&  (MyArray[i].charAt(0) == '+' || MyArray[i].charAt(0) == '-' || MyArray[i].charAt(0) == '*' || MyArray[i].charAt(0) == '/')) {
                char op = MyArray[i].charAt(0);
                int number1 = Integer.parseInt(MyArray[i - 1]);
                int number2 = Integer.parseInt(MyArray[i + 1]);

                finalResult = calculateResult(number1, number2, op);
                MyArray[i + 1]  = String.valueOf(finalResult);
                moreOp = true;
                i = i + 1;
            }
        }
            return finalResult;
        }

        int calculateResult(int num1, int num2, char op){
            int calresult = 0;
            switch (op) {
                case '+':
                    calresult = num1 + num2;
                    break;
                case '-':
                    calresult = num1 - num2;
                    break;
                case '*':
                    calresult = num1 * num2;
                    break;
                case '/':
                    calresult = num1 / num2;
                    break;
            }
            System.out.println(calresult);
            return calresult;

        }
        void clear(){
        finalResult =0;
        index = 0;
        MyArray= new String[10];
        }
        void printHistory(String strPrint){
            newArray.add(strPrint);
        }

    }
