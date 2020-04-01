/*
    CSC 320
    Lab 3
    
    File:  MUPanel.java
  
    Maze Generation and user movement
*/

import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MUPanel extends JPanel {

    private Maze theMaze;
    private NorthFirstMazeSolver northAI;
    private Thread northFirstThread;
    private RandomMazeSolver randomSolver;
    private Thread randomThread;

    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setName("CSC 320 Lab # 3 -- Fun with Mazes!");
        setBackground(Color.BLACK);

        theMaze = new Maze(25, 35, 10, 400);
        
        
        setFocusable(true);
        //addKeyListener(this);

        
    } // end of MUPanel constructor
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // This line must be first in this method!

        theMaze.draw( g );
        
        if (northFirstThread == null) {
            northAI = new NorthFirstMazeSolver(theMaze, getGraphics());
            northFirstThread = new Thread(northAI);
            northFirstThread.start();
        }
        
        if (randomThread == null)
        {
            randomSolver = new RandomMazeSolver(theMaze, getGraphics());
            randomThread = new Thread(randomSolver);
            randomThread.start();
        }
        
        g.setColor(Color.white);
        String msg = "Use the arrow keys to move your light blue square...";
        if (northAI.haveNotReachedEndingSquare()) {
            msg = "Congratulations North First you've solved the maze!";
        }
        if (randomSolver.haveNotReachedEndingSquare()) {
            msg = "Congratulations random you've solved the maze!";
        }
        g.drawString(msg, 10, 550);
        
        

    } // end of method paintComponent
    

	
    public void keyReleased(KeyEvent event){
        //System.out.println(event);		
    } // end of keyReleased()
	
    public void keyTyped(KeyEvent event){
        //System.out.println(event);		
    } // end of keyTyped()
    
    /***********************************************
     * Do NOT change or delete anything below here!
     ***********************************************/
    public void frame()
    {
        for (Component c: getComponents())
            c.setSize(c.getPreferredSize());
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);    
    }

    public static void main(String args[]){new MUPanel().frame();}

} // end of class MUPanel
