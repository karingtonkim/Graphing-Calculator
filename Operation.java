/**
 * Operation.java
 *
 * A class for operations
 *
 * @author Karington Kim
 * Wheaton College, CSCI235, Fall 2021
 * Project 7
 * 10 December 2021
 */

public class Operation implements ExprNode {
    /**
     * Operator sign
     */
    private String operator;

    /**
     * Left side of expression
     */
    private ExprNode left;

    /**
     * Right side of expression
     */
    private ExprNode right;

    /**
     * Constructor for Operation class
     * @param text The expression input in String format
     * @param leftOperator The left side of the expression
     * @param rightOperator The right side of the expression
     */
    public Operation (String text, ExprNode leftOperator, ExprNode rightOperator) {
	operator = text;
	left = leftOperator;
	right = rightOperator;
    }

    /**
     * Evaluate for whatever sign is in the string input and pass x variable along
     * @param x The value to evaluate
     * @return The output of the expression depending on the operation
     */
    public double evaluate(double x) {
	double left = this.left.evaluate(x);
	double right = this.right.evaluate(x);

	switch(operator) {
	case "+":
	    return left + right;

	case "-":
	    return left - right;
	    
	case "*":
	    return left * right;
	    
	case "^":
	    return Math.pow(left,right);
	}
	return left / right;
    }
}
