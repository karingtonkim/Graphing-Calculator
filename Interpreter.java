/**
 * Interpreter.java
 *
 * Class to generate ExprNode trees based on a given
 * input.
 *
 * @author Karington Kim
 * CSCI 235, Wheaton College, Fall 2021
 * Project 7
 * 10 December 2021
 */

public class Interpreter {

    /**
     * Turn a string into an ExprNode tree.
     *
     * @param input The string to parse
     * @return The root of the ExprNode tree
     */
    public static ExprNode parse(String input) {
	// Creating new string array list to slice
        String[] nodes = ExprStringSlicer.slice(input);
	// Setting a temp ExprNode variable to null
	ExprNode temp = null;

	if (nodes.length == 1) {
	    if (nodes[0].equals("x")) {
		temp = new Variable();
	    }else{
		temp = new Number(nodes[0]);
	    }
	}else{
	    // Value to the left of the operator
	    ExprNode expr1 = parse(nodes[0]);
	    // Value to the right of the operator
	    ExprNode expr2 = parse(nodes[2]);
	    temp = new Operation(nodes[1], expr1, expr2);
	}

	return temp;

    }

    /**
     * For testing project 7 (Part A).
     */
    public static void main(String[] args) {
        ExprNode tree = parse(args[0]);
        System.out.println(tree.evaluate(Double.parseDouble(args[1])));
    }


}
