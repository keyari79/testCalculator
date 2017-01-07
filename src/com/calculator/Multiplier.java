package com.calculator;

/**
 * Created by keyarash on 06.01.17.
 */
public class Multiplier extends CalculateBase implements MathProcessing {
    public Multiplier() {};
    public Multiplier(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }
    @Override
    public void calculate() {
        double value = getLeftVal() * getRightVal();
        setResult(value);
    }

    @Override
    public String getKeyword() {
        return "multiply";
    }

    @Override
    public char getSymbol() {
        return '*';
    }

    @Override
    public double doCalculate(double leftVal, double rightVal) {
       setLeftVal(leftVal);
       setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
