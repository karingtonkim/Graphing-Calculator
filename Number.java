/**
 * Number.java
 *
 * A class for numbers
 *
 * @author Karington Kim
 * Wheaton College, CSCI235, Fall 2021
 * Project 7
 * 10 December 2021
 */

public class Number implements ExprNode {
    /**
     * value of node
     */
    private double value;

    /**
     * Constructor for Number class
     * @param text String of number
     */
    public Number (String text) {
	value = Double.parseDouble(text); // Parse the string into a double
    }

    /**
     * Evaluate the expression
     * @return value The value of expression
     */
    public double evaluate(double x) {
	return value;
    }
}
