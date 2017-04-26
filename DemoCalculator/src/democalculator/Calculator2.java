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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class Calculator2 implements ActionListener
{
  private JTextField xfield, yfield, resultBox;
  private JLabel result,resultArea;
  
  private JButton addButton;
  private JButton timesButton;
  private JButton minusButton;
  private JButton divideButton;
  private JButton clearButton;
  
  private JRadioButton addRadio;
  private JRadioButton minusRadio;
  private JRadioButton timesRadio;
  private JRadioButton divideRadio;
  private JRadioButton clearRadio;
  
  private final ButtonGroup group;
  
  private JCheckBox floatBox;
  
  protected JPanel bpanel;
  protected JPanel xpanel;
  private boolean flag = false;
  
  public Calculator2()
  {
    //Make first panel and set grid layout
    xpanel = new JPanel();
    xpanel.setLayout(new GridLayout(3,2));
    xpanel.setBackground(new Color(244, 201, 122));

    //Make second panel and set grid layout
    bpanel = new JPanel();
    bpanel.setLayout(new GridLayout(1,6));
    
    //Initialize panel with labels and set font
    xpanel.add(new JLabel("x=", SwingConstants.RIGHT));
    xfield = new JTextField("0", 5);
    Font MONOSPACED = null;
    xfield.setFont(MONOSPACED);
    xpanel.add(xfield);

    //Initialize panel with labels and set font
    xpanel.add(new JLabel("y=", SwingConstants.RIGHT));
    yfield = new JTextField("0", 5);
    xfield.setFont(MONOSPACED);
    xpanel.add(yfield);

    //Initialize panel with labels and set foreground
    //and background colors. Set font. Set bold. Set layout.
    xpanel.add(new JLabel("Result = "));
    result = new JLabel("0");
    result.setForeground(Color.red);
    result.setBackground(new Color(255, 255, 204));
    result.setOpaque(true);
    Font font = result.getFont();
    Font boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize());
    result.setFont(boldFont);
    xpanel.add(result);
    add(xpanel, BorderLayout.NORTH);
    add(bpanel, BorderLayout.CENTER);

    //Create buttons and add actionListener
    addRadio = new JRadioButton("+");
    bpanel.add(addRadio);
    addRadio.addActionListener(this);
   
    timesRadio = new JRadioButton("*");
    bpanel.add(timesRadio);
    timesRadio.addActionListener(this);
    
    minusRadio = new JRadioButton("-");
    bpanel.add(minusRadio);
    minusRadio.addActionListener(this);
    
    divideRadio = new JRadioButton("/");
    bpanel.add(divideRadio);
    divideRadio.addActionListener(this);
   
    clearRadio = new JRadioButton("clear");
    bpanel.add(clearRadio);
    clearRadio.addActionListener(this);
    
    floatBox = new JCheckBox("Float");
    bpanel.add(floatBox);
    floatBox.addActionListener(this);
    
    //Set border
    bpanel.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.red));
  
    //Create button group and add all buttons to group
    group = new ButtonGroup();
    group.add(addRadio);
    group.add(minusRadio);
    group.add(timesRadio);
    group.add(divideRadio);
    group.add(clearRadio);
  
  }

  @Override
  public void actionPerformed(ActionEvent event) 
  {
    int x = 0;
    int y = 0;
    double res = 0;
      
    try
    {
      //Grab input from textFields
      String xText = xfield.getText();
      String yText = yfield.getText();
      String strResult = "0";
      x = Integer.parseInt(xText);
      y = Integer.parseInt(yText);
      
      //If float box is checked, change result to floating point
      if(event.getSource() == floatBox)
      {
        if(flag == false)
        flag = true;
      }
    
      //If clear button is pressed, clear data
      if(event.getSource() == clearRadio)
      {
        result.setText("");
        xfield.setText("0");
        yfield.setText("0");
      }
    
      //Perform arithmatic based on button pressed    
      if(event.getSource() == addRadio)
      {
        res = x + y;
      }
      
      if(event.getSource() == timesRadio)
      {
        res = x * y;
      }
    
      if(event.getSource() == minusRadio)
      {
        res = x - y;
      }
    
      if(event.getSource() == divideRadio)
      {
        if(y == 0)
        {
          strResult = "Error: Divide by 0";
        }
        else
        {
          res = x / (double)y;
        }       
      }
      
      if(flag)
      {
        strResult = Double.toString(res);
      }
      else
      {
        strResult = Integer.toString((int) res);
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

