package com.calculator;

/**
 * Created by keyarash on 07.01.17.
 */
public interface MathProcessing {
    // interfaces represent a contract, they only contain methods and constants
    // interface do not own any constructors as they wont be instantiated
    // classes which obey this contract should be able to identify the methods defined in the interface.
    String SEPARTOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculate(double leftVal, double rightVal);
}
