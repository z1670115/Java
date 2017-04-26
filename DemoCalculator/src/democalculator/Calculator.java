/*********************************************************************
Class:     CSCI 470-1
Program:   Assignment 3
Author:    Devin Lindelof
Z-number:  z1670115
Date Due:  4/25/17

Purpose: This program makes two calculators that are in one frame
*        with a menu bar. The purpose is to teach GUI elements
*        with swing.

Execution: java Hw3

NOTE: I could not figure out a way to get BorderLayout to display
*     each panel nicely. I even tried messing around with other
*     layout managers and was left very frustrated. It's not pretty
*     but it runs perfectly

*********************************************************************/

package democalculator;

import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener
{
  private JTextField xfield, yfield, resultBox;
  private JLabel result,resultArea;
  private JButton addButton;
  private JButton timesButton;
  private JButton minusButton;
  private JButton divideButton;
  private JButton clearButton;
  protected JPanel bpanel;
  protected JPanel xpanel;

  public Calculator()
  {
    //Make first panel and set grid layout
    xpanel = new JPanel();
    xpanel.setLayout(new GridLayout(3,2));

    //Make second panel and set grid layout
    bpanel = new JPanel();
    bpanel.setLayout(new GridLayout(1,5));
    
    //Initialize panel with a Jpanel and textField
    xpanel.add(new JLabel("x=", SwingConstants.RIGHT));
    xfield = new JTextField("0", 5);
    xpanel.add(xfield);

    //Initialize panel with a Jpanel and textField
    xpanel.add(new JLabel("y=", SwingConstants.RIGHT));
    yfield = new JTextField("0", 5);
    xpanel.add(yfield);

    //Initialize panel with a Jpanel and textField
    xpanel.add(new JLabel("Result = "));
    result = new JLabel("0");
    //Set foreground, background, and font
    result.setForeground(Color.red);
    result.setBackground(new Color(255, 255, 204));
    result.setOpaque(true);
    Font font = result.getFont();
    Font boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize());
    result.setFont(boldFont);
    xpanel.add(result);
    add(xpanel,BorderLayout.NORTH);
    add(bpanel,BorderLayout.CENTER);
    
    //Create button and add action listener
    addButton = new JButton("+");
    bpanel.add(addButton);
    addButton.addActionListener(this);
   
    timesButton = new JButton("*");
    bpanel.add(timesButton);
    timesButton.addActionListener(this);
    
    minusButton = new JButton("-");
    bpanel.add(minusButton);
    minusButton.addActionListener(this);
    
    divideButton = new JButton("/");
    bpanel.add(divideButton);
    divideButton.addActionListener(this);
   
    clearButton = new JButton("clear");
    bpanel.add(clearButton);
    clearButton.addActionListener(this);
    
    //Set border
    bpanel.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.red));
    
  }


  @Override
  public void actionPerformed(ActionEvent event) 
  {
    int x =0;
    int y =0;

    //If clear button is pressed, clear data
    if(event.getSource() == clearButton)
    {
      result.setText("");
      xfield.setText("0");
      yfield.setText("0");
    }
    
    try
    {
      //Grab input from textbox
      String xText = xfield.getText();
      String yText = yfield.getText();
      String strResult = "0";
    
      x = Integer.parseInt(xText);
      y = Integer.parseInt(yText);
    
      //Perform arithmatic based on button pressed
      if(event.getSource() == addButton)
      {
        strResult = (Integer.toString(x+y));
      }
   
      if(event.getSource() == timesButton)
      {
        strResult = (Integer.toString(x*y));
      }
    
      if(event.getSource() == minusButton)
      {
        strResult = Integer.toString(x-y);
      }
    
      if(event.getSource() == divideButton)
      {
        if(y == 0)
        {
          strResult = "Error: Divide by 0";
        }
        else
        {
          strResult = Integer.toString(x/y);
        }       
      }
      result.setText(strResult);
    }
    //Check for non-numeric characters
    catch (NumberFormatException e)
    {
      result.setText("Error: Non numeric");
    }
  }
}

