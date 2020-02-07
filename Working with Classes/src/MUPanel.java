/*
    CSC 120
    PA2
  
    Ben Schroth 

    Practice with arithmetic and muta.println using NHL players and statistics.
*/

import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;

public class MUPanel extends JPanel  {
    
        private NHLPlayer Stamkos, Crosby, McDavid, Werenski;
        private Goalie Bob;
        private MUTextArea muta;
    
   

    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setName("CSC 120 Lab # 4");
        setBackground(Color.WHITE); 
        
        muta = new MUTextArea();
        muta.setBounds(10, 10, 780, 580);
        add(muta);
        
      Stamkos = new NHLPlayer("Steven Stamkos", 53, 19, 41, true);
      Crosby = new NHLPlayer("Sidney Crosby", 54, 17, 41, true);
      McDavid = new NHLPlayer("Connor McDavid", 51, 21, 40, true);
      Werenski = new NHLPlayer("Zach Werenski", 48, 11, 11, false);
      Bob = new Goalie("Sergei Bobrovsky", 42, 1210, 1314, true);
        
       

     workWithNHLPlayer();
    } // end of MUPanel constructor

     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawString("Look in Java Console for output", 10, 50);
        
    } // end of paintComponent()

    
    public void workWithNHLPlayer() {
        DecimalFormat gpg = new DecimalFormat("#.000");
        
        muta.println(Stamkos.toString());
        muta.println(Crosby.toString());
        muta.println(McDavid.toString());
        muta.println(Werenski.toString());
        muta.println(Bob.toString());
        muta.println();
        muta.println("=============================");
        muta.println();
      
    Integer points;
    points = McDavid.getGoals() + McDavid.getAssists();
    
        muta.println(McDavid.getName() + " has a total of " + points + " points this season.");
        
    Double goalsPerGame;
    goalsPerGame = 1.0 * Crosby.getGoals() / Crosby.getgamesPlayed();
    
        muta.println(Crosby.getName() + " averages " + gpg.format(goalsPerGame) + " goals per game in the 2018 season." );
    
    Double savePercentage;
    savePercentage = 1.0 * Bob.getSaves() / Bob.getShots();
        
        muta.println("Sergei Bobrovsky has a " + gpg.format(savePercentage) + " save percentage (SV%) in " + Bob.getgamesPlayed() + " games played in 2018.");
    } // end of workWithNHLPlayer
    
    
    /***********************************************
     * Do NOT change or delete anything below here!
     ***********************************************/
    public void frame() {
        for (Component c: getComponents())
            c.setSize(c.getPreferredSize());
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);   
        
    } // end of frame()

    public static void main(String args[]){new MUPanel().frame();}

}
