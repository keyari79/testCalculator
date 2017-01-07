package com.calculator;

/**
 * Created by keyarash on 06.01.17.
 */
public abstract class CalculateBase {
    // we keep these private, so no other method can change them
    private double leftVal;
    private double rightVal;
    private double result;

// setters - can be kept private so we can change business logic if needed - no other method should be able to change how the fields are set,
    public void setLeftVal(double leftVal) { this.leftVal = leftVal; }
    public void setRightVal(double rightVal) { this.rightVal = rightVal; }
    public void setResult(double result) { this.result = result; }

// getters - can be made public so other methods can access the values
    public double getLeftVal() { return leftVal; }
    public double getRightVal() { return rightVal; }
    public double getResult() {return result;}

   // our empty constructor...
    public CalculateBase(){}
    // the abstraction used for this constructor is that a calculation always takes two values, left and right
    public CalculateBase(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }
    // abstract method of calculate... to be overriden in a concrete class which inherits from this abstract class
    public abstract void calculate ();

}

