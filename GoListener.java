/**
 * GoListener.java
 *
 * ActionListener class for Go Button
 *
 * @author Karington Kim
 * CSCI235, Wheaton College, Fall 2021
 * Project 7
 * 10 December 2021
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoListener implements ActionListener, Painter {

    /**
     * The values of x and y min and max
     */
    private int xMin, xMax, yMin, yMax;

    /**
     * The textfield for error message
     */
    private JTextField error;
    
    /**
     * GraphCalc object calc
     */
    private GraphCalc calc;

    /**
     * The input function as a string
     */
    private String func;

    /**
     * The PaintPanel where graph will be painted
     */
    private PaintPanel paint;


    /**
     * Constructor for GoListener
     */
    public GoListener(JTextField error, GraphCalc calc, PaintPanel paint) {
	xMin = 0;
	xMax = 0;
	yMin = 0;
	yMax = 0;
	this.error = error;
	this.calc = calc;
	func = "";
	this.paint = paint;
    }

    /**
     * Method to fire an action for an event e
     * @param e The event being performed
     */
    public void actionPerformed(ActionEvent e) {
        if (calc.getTf("fx").equals("")) {
	    error.setText("Invalid input");
	    return;
	}else{
	    func = calc.getTf("fx");
	    error.setText("");
	}

	// Try-catch block to catch exception if input is invalid
	try {
	    xMin = Integer.parseInt(calc.getTf("minx"));
	    error.setText("");
	    
	    xMax = Integer.parseInt(calc.getTf("maxx"));
	    error.setText("");

	    yMin = Integer.parseInt(calc.getTf("miny"));
	    error.setText("");

	    yMax = Integer.parseInt(calc.getTf("maxy"));
	    error.setText("");
	}
	catch (Exception er) {
	    error.setText("Invalid input");
	    System.out.println("Hi");
	}

	paint.setPainter(this);
	paint.repaint();
    }

    /**
     * Find x position on graph
     * @param x The x-coordinate
     * @return The x-value on graph
     */
    public int getxpos(double x) {
	double pixelx = 350 / (xMax + Math.abs(xMin)); // Conversion to pixels
	return (int)((x + (double)(Math.abs(xMin))) * pixelx);
    }

    /**
     * Find y position on graph
     * @param y the y-coordinate
     * @return the y-value on graph
     */
    public int getypos(double y) {
	double pixely = 350 / (yMax + Math.abs(yMin)); // Conversion to pixels
	return (int)(((double)(Math.abs(yMax) - y)) * pixely);
    }

    /**
     * Paint the graph
     * @param gr Graphics object to paint on
     */
    public void paint(Graphics gr) {
	if(xMin <= 0 && xMax >= 0) {
	    gr.drawLine(getxpos(0.0), 0, getxpos(0.0), 349);
	}if(yMin <= 0 && yMax >= 0) {
	    gr.drawLine(0, getypos(0.0), 349, getypos(0.0));
	}

	ExprNode yvalue = Interpreter.parse(func);
	double pixel;
	
	for(pixel = (double)(xMin); pixel <= (double)(xMax); pixel += 0.1) {
	    gr.fillRect(getxpos(pixel), getypos(yvalue.evaluate(pixel)), 1, 1);
	}
    }
    
}
