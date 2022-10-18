/**
 * GraphCalc.java
 *
 * Graphing calculator program (class with main method)
 *
 * @author Karington Kim
 * CSCI 235, Wheaton College, Fall 2021
 * Project 7
 * 10 December 2021
 */


import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;

public class GraphCalc {

    /**
     * The textfields for function, minimum x and y values, and maximum x and y values
     */
    private JTextField funcField, xminField, yminField, xmaxField, ymaxField;

    /**
     * The textfield to display error message
     */
    private JTextField error;

    /**
     * Constructor for GraphCalc class
     */
    public GraphCalc() {
	// Create a new window titled "Graphing calculator"
	JFrame window = new JFrame("Graphing calculator");
	window.setLayout(new FlowLayout());
	window.setSize(350, 600);
        
	// Create a new PaintPanel
	PaintPanel graphPanel = new PaintPanel(350, 350);

	// Create new textfield with size 25
	funcField = new JTextField(25);
	// Create new textfield with size 5
	xminField = new JTextField(5);
	// Create new textfield with size 5
	yminField = new JTextField(5);
	// Create new textfield with size 5
	xmaxField = new JTextField(5);
	// Create new textfield with size 5
	ymaxField = new JTextField(5);


	xminField.setText("-10");
	yminField.setText("-10");
	xmaxField.setText("10");
	ymaxField.setText("10");
			      
	// Create new button called "Go"
	JButton go = new JButton("Go");

	// Create new label for function
	JLabel func = new JLabel("f(x) = ");

	// Create new label for x min
	JLabel xmin = new JLabel("x min:");

	// Create new label for y min
	JLabel ymin = new JLabel("y min:");
	
	// Create new label for x max
	JLabel xmax = new JLabel("x max:");

	// Create new label for y max
	JLabel ymax = new JLabel("y max:");

	// Set error to new textfield sized 20
	error = new JTextField(20);

	// Create new GoListener object goButton and add action listener
	GoListener goButton = new GoListener(error, this, graphPanel);
	go.addActionListener(goButton);
	
	window.add(graphPanel);
	// Create new panel
	JPanel panel2 = new JPanel();
	panel2.setLayout(new FlowLayout());
	window.add(func);
	window.add(funcField);
	window.add(xmin);
	window.add(xminField);
	window.add(ymin);
	window.add(yminField);
	window.add(xmax);
	window.add(xmaxField);
	window.add(ymax);
	window.add(ymaxField);
	panel2.add(go);
	window.add(panel2);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setVisible(true);
    }

    /**
     * Retrieve text inputs in each textfield
     */
    public String getTf(String tf) {
	error.setText("");
	if(tf.equals("minx")) {
	    return xminField.getText();
	}else if(tf.equals("maxx")) {
	    return xmaxField.getText();
	}else if(tf.equals("miny")) {
	    return yminField.getText();
	}else if(tf.equals("maxy")) {
	    return ymaxField.getText();
	}else if(tf.equals("fx")) {
	    return funcField.getText();
	}else {
	    return "";
	}
    }

    /**
     * Main method to create new GraphCalc object
     */
    public static void main(String[] args) {
	// new GraphCalc object (using constructor)
	GraphCalc theWindow = new GraphCalc();
    }
}
