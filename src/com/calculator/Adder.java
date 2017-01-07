package com.calculator;

/**
 * Created by keyarash on 06.01.17.
 */
// this class extends the abstract class calculateabse
public class Adder extends CalculateBase implements MathProcessing {


    // constructors
    public Adder(){}
    public Adder(double lVal,double rVal) {
        // this very constructor is used to MAP the fields of the abstract term with the fields of the concrete term
        // For the mapping, the constructor (called 'CalculateBase') in the abstract method with TWO fields is used
        // i.e. lVal = leftVal and rVal=rightVal
        super(lVal, rVal);
    }
    // here is a concrete calculation taking place, for this concrete class it is addition
    @Override
    public void calculate() {
        // since the mapping is now place, we can also access the getters and setters of the abstract method.
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }

// the following overrides are coming from the MathProcessing interface. We need to do define the associated work to be done with these methods
/* this is the content of the interface, just as a reminder:

    String SEPARTOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculate(double leftVal, double rightVal);

*/
// we now define what the adder class has to do by conforming to the interface - i.e., introduce the logic of addition
    @Override
    public String getKeyword() { return "add"; }

    @Override
    public char getSymbol() { return '+'; }

    @Override
    public double doCalculate(double leftVal, double rightVal) {

        setLeftVal(leftVal); // this setter is from the abstract class
        setRightVal(rightVal); // this setter is from the abstract class
        calculate(); // this is overriden by the calculate method in the adder class (see above!)
        return getResult(); // this is taken from the abstract class

    }
}
