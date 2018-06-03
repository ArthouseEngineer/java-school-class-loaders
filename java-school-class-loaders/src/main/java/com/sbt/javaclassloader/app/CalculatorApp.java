package com.sbt.javaclassloader.app;

import com.sbt.javaclassloader.impl.*;

public class CalculatorApp   {

    CalculatorImpl calculator;

    public CalculatorApp(CalculatorImpl calculator) {
        this.calculator = calculator;
    }

    public  void additional(){
        System.out.println(calculator.addition(2,2));
    }

    public  void substraction(){
        System.out.println(calculator.subtraction(2,2));
    }
}
