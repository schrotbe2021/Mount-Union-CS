/* CSC 120
    Ben Schroth
    PA3
    2/26/2018

Description: Program that draws a house and sun. The sun rises and the lights are able to be turned
on or off in the house. Also, you can change the sky from day to night and vice versa.
*/



import java.awt.*;
import javax.swing.*;

public class MUPanel extends JPanel {

    // 1. Declare private objects here:
    
        private Sun sun;
        private House house;
        
    

    // constructor method
    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(600, 500));
        setName("Mount Union Java Program");
        setUp();
        setBackground(Color.WHITE);

        // 2. Instantiate objects here by calling "new":
       
        sun = new Sun(450, 450, true);
        house = new House(true);
        
        
        
    } // end of constructor
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // This line must be first in this method!

        // 3. Call methods of objects here:
        
        sun.draw(g);
        g.setColor(new Color(96, 128, 56));
        g.fillRect(0, 450, 600, 50);
        house.draw(g);
     
               
		
		
    } // end of paintComponent()
    
    public void changeLights(){
        house.changeLights();
    }
    
    public void moveSun(){
        sun.moveVertically();
        sun.growSun();
    }
    public void changeTime(){
        sun.changeTime();
    }
    
    
    
    
       
    
    
    
    /***********************************************
     * Do NOT change or delete anything below here!
     ***********************************************/
    public void setUp() {
        for (Component c: getComponents())
            c.setSize(c.getPreferredSize());
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(false);    
    }

    public static void main(String args[]){new MUPanel();}

} // end of class MUPanel
