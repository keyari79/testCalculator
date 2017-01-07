package com.calculator;


/**
 * Created by keyarash on 07.01.17.
 */
public class CalculateHelper {

    private static final char ADD_SYMBOL = '+';
    private static final char SUBS_SYMBOL = '-';
    private static final char MULT_SYMBOL = '*';
    private static final char DIV_SYMBOL = '/' ;

    MathCommand command;
    double leftVal;
    double rightVal;
    double result;

    public void process(String statement) throws InvalidStatementException {
        String[] parts = statement.split(" ");


        if(parts.length != 3) {
            throw new InvalidStatementException("incorrect number of fields", statement);
        }

        String commandString = parts[0];

        try {
            leftVal = Double.parseDouble(parts[1]);
            rightVal = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e ) {
            throw new InvalidStatementException("non-numeric input data", statement,e);
        }

        setCommandFromString(commandString);
        if (command == null)
                throw new InvalidStatementException("Invalid command", statement);

        // we now have all the necessary parameters to call the calculatebase and it's derived classed
        CalculateBase calculator = null; // create an instance of the abstract class
        switch (command) {
            case Add: calculator = new Adder(leftVal,rightVal); break;
            case Subtract: calculator = new Substracter(leftVal,rightVal); break;
            case Multiply: calculator = new Multiplier(leftVal,rightVal); break;
            case Divide: calculator = new Divider(leftVal,rightVal); break;
        }
        // the calculator object is instantiated with the correct operation (+, -, ...)
        calculator.calculate(); // this will perform the actual calculation
        // depending on the concrete class which was called in the above switch statement
        result = calculator.getResult();
      //  System.out.println("your result is: .... " + result);
    }

    // this  method is used to read the input text, compare it with enum types using string comparison
    private void setCommandFromString(String commandString){
        // we convert the enumeration type to a string
        // we compare the converted enum with the commandString string using equalIgnorecase method
        if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command = MathCommand.Subtract;
        else if (commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command = MathCommand.Add;
        else if ( commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;
    }

    @Override
    public String toString() {
        char symbol = ' ';
        switch (command) {
            case Add: symbol = ADD_SYMBOL;break;
            case Subtract: symbol = SUBS_SYMBOL ; break;
            case Multiply:symbol = MULT_SYMBOL; break;
            case Divide:symbol = DIV_SYMBOL; break;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(' ');
        sb.append(ADD_SYMBOL);
        sb.append(' ');
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);
        return sb.toString();
    }

}
