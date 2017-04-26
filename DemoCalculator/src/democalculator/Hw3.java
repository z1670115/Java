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

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Hw3 implements ActionListener
{
  public static void main(String[] args) 
    {
      //Make the frame and set layout manager and starting location
      JFrame frame2;
      
      frame2= new JFrame("Calculator");
      frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame2.setLayout(new BorderLayout());
      frame2.setLocation(400, 300);
      
      //Make first calculator and add panels to frame
      Calculator a = new Calculator();
      frame2.add(a.xpanel, BorderLayout.NORTH);
      frame2.add(a.bpanel, BorderLayout.WEST);
      
      //Make second calculator and add panels to frame
      Calculator2 b = new Calculator2();
      frame2.add(b.bpanel, BorderLayout.EAST);
      frame2.add(b.xpanel, BorderLayout.SOUTH);
      
      //Make menubar with menu and menuItems
      JMenuBar bar = new JMenuBar();
      
      JMenu aboutMenu = new JMenu("About");
      
      JMenuItem peopleItem = new JMenuItem("People");
      aboutMenu.add(peopleItem);
      //ActionPerformed for when menuItem is pressed
      peopleItem.addActionListener(new ActionListener() 
      {
        @Override
        public void actionPerformed(ActionEvent event)
        {
           JOptionPane.showMessageDialog(frame2,
            "\"Hey wow I made this!\" - Devin Lindelof",
            "About", JOptionPane.PLAIN_MESSAGE);
        }
       }
      );

      JMenuItem projectItem = new JMenuItem("Project");
      aboutMenu.add(projectItem);
      //ActionPerformed for when menuItem is pressed
      projectItem.addActionListener(new ActionListener()
      {
        
        @Override
        public void actionPerformed(ActionEvent event)
        {
           JOptionPane.showMessageDialog(frame2,
            "This program teaches the fundamentalsof swing in\njava along"
                    + "with basic GUI elements by making a calculator.",
            "About", JOptionPane.PLAIN_MESSAGE);
        }
       }
      );
      
      //Add menubar to frame
      bar.add(aboutMenu);
      frame2.setJMenuBar(bar);
      
      //Pack frame and set to visible
      frame2.pack();
      frame2.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
    }
    
}

