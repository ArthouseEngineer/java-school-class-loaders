package com.sbt.javaclassloader.impl;

import com.sbt.javaclassloader.api.*;

public class CalculatorImpl implements ICalculator {
    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }
}
