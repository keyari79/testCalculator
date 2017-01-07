package com.calculator;
/**
 * Created by keyarash on 06.01.17.
 */
public class Main {
    public static void main(String[] args) {
        // useMathEquation();
        // useCalculateBase();
        String[] statements = {
                "add 25.0d 92.0d",
                "multiply 11.0d 3.0d"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[]{new Multiplier(), new Adder()});
        for (String statement : statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }
    }
}
        /*    static void use_CalculateHelper () {
        CalculateHelper helper = new CalculateHelper();
        for (String statement : statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("... Original exeception was..." + e.getCause().getMessage());
                }
            }
        }
    /*
    public void useMathEquation() {
        MathEquation[] equations = new MathEquation[4];
        // since we have already created the constructor with 3 arguments, we can simply create instance of the equation objects.
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);
        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("Your result is   " + equation.getResult());
        }
        System.out.println("\nUsing Overload\n");
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        // here we create an instance of the Mathequation with no paramters, but the opCode field is already set as "a"
        MathEquation equationOverload = new MathEquation();
        equationOverload.execute(leftDouble, rightDouble); // so here we would just add the two numbers
        System.out.println(equationOverload.getResult());
    }
    public void useCalculateBase() {
        System.out.println("\nUsing inheritance now...\n");
        CalculateBase[] calculators = {
                new Adder(25.0d, 92.0d),
                new Divider(100.0d, 50.0d),
                new Substracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };
        for (CalculateBase calculator : calculators) {
            calculator.calculate();
            System.out.println("result = " + calculator.getResult());
        }
    }
    */
