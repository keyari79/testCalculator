package com.calculator;


/**
 * Created by keyarash on 07.01.17.
 */
public class DynamicHelper {
    private MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers) {
        this.handlers = handlers;
    }

    public String process(String statement) {
        String[] parts = statement.split(MathProcessing.SEPARTOR);
        String keyword = parts[0];
        MathProcessing theHandler = null;
        for(MathProcessing handler: handlers) {
            if(keyword.equalsIgnoreCase(handler.getKeyword())) {
                // if the keyword of the statement  = keyword of one of the handlers, we have a match for the handler
                theHandler = handler;
                break;
            }
        }
        // now that we have identified our handler, we can go in and do the rest of the opertion - according to the interface
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        double result = theHandler.doCalculate(leftVal,rightVal); // note that this is using the method defined in the interface,
        // this works, since adder class implements the MathProcessing interface.

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);
        return sb.toString();


    }

}
