package com.calculator;
/* Created by keyarash on 06.01.17.
    the MathEquation Class has 4 fields and one (execute) method.
*/
public class MathEquation {
// fields may contain the information about the state of the system, typically you want to keep them private
    private char opCode = 'a'; // so at at least we get 0+0 = 0 //
    public void setOpCode(char opCode) { this.opCode = opCode; }
    public char getOpCode() { return opCode; }



    // fields contain the information about the state of the system, typically you want to keep them private
    private double leftVal;
    private double rightVal;
    private double result;

// setters - can be kept private so we can change business logic if needed - no other method should be able to change how the fields are set,
    public void setLeftVal(double leftVal) { this.leftVal = leftVal; }
    public  void setRightVal(double rightVal) { this.rightVal = rightVal; }
// getters - can be made public so other methods can access the values
    public double getLeftVal() { return leftVal; }
    public double getRightVal() { return rightVal; }
    public double getResult() { return result; }
    // one you made one constructor, you are also responsible for ALL constructors
    //this constructor is used if no parameters are passed on to the class
    public MathEquation() {};

    // this constructor is to be used if only opCode is passed on to the class
    public MathEquation(char opCode){
        this.opCode = opCode;
    }

    // this constructor is to be used when all three parameters are passed on to the class
    public MathEquation (char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    // an overload version of the execute method
    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }
    // a method in the Mathequation class which performs some operation INSIDE the class declaration
    public void execute() {
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = leftVal != 0 ? leftVal / rightVal : 0.0;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                result = 0;
        }
    }
}
