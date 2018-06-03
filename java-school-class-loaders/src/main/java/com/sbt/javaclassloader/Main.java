package com.sbt.javaclassloader;

import com.sbt.javaclassloader.loaders.*;
import com.sbt.javaclassloader.app.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {


        /*
         * https://www.concretepage.com/java/custom-classloader-java-example
         */

        ApiClassLoader apiClassLoader = new ApiClassLoader(ClassLoader.getSystemClassLoader());
        ImplClassLoader implClassLoader = new ImplClassLoader(ClassLoader.getSystemClassLoader());
        AppClassLoader appClassLoaders = new AppClassLoader(ClassLoader.getSystemClassLoader());

        try {
            Class<?> calcImpl = implClassLoader.findClass("com.sbt.javaclassloader.impl.CalculatorImpl");
            Object calculator = calcImpl.newInstance();

            Class<?> calcApp = appClassLoaders.findClass("com.sbt.javaclassloader.app.CalculatorApp");
            CalculatorApp calculatorApp = (CalculatorApp) calcApp.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
