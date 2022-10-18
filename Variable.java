/**
 * Variable.java
 *
 * A class for variables
 *
 * @author Karington Kim
 * Wheaton College, CSCI235, Fall 2021
 * Project 7
 * 10 December 2021
 */

public class Variable implements ExprNode {

    /**
     * Constructor for Variable class
     */
    public Variable () {
    }

    /**
     * Evaluates variable x
     * @param x The variable x
     * @return The value of the expression when x is plugged in
     */
    public double evaluate(double x) {
	return x;
    }
}
