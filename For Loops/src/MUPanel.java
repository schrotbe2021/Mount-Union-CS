/*  CSC 120 PA5
    Ben Schroth 
    3/27/2018
 *  
 *  Description: A for loop that draws an arc of 90 degree length and at each count of the loop the arc gets smaller
        and is filled on every new arc.
 * 
 */

import java.awt.*;
import javax.swing.*;

public class MUPanel extends JPanel {

    
    public Integer howMany;
    
        


    // constructor method
    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setName("Mount Union Java Program");
        setUp();
        setBackground(Color.WHITE);

        // 2. Instantiate objects here by calling "new":
        
        howMany = 1;
        

        
    } // end of constructor
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // This line must be first in this method!

        Integer x, y, width, height, arcStart, arcLength;
        
        x = 100;
        y = 20;
        width = 400;
        height = 400;
        arcStart = 0;
        arcLength = 90;
       for (Integer count = 1; count <= howMany; count++ ) {
          
           if (count % 4 == 1){    
                arcStart = 0;
                g.drawArc(x, y, width, height, arcStart, 90);
                x += 11;
                y += 11;
                width -= 22;
                height -= 22;
          } // first quadrant arc
          else if (count % 4 == 2) {
                arcStart = 90;
                g.drawArc(x, y, width, height, arcStart, 90);
                x += 11;
                y += 11;
                width -= 22;
                height -= 22;
          } // second quadrant arc
          else if (count % 4 == 3){
                arcStart = 180;
                g.drawArc(x, y, width, height, arcStart, 90);
                x += 11;
                y += 11;
                width -= 22;
                height -= 22;
          } // third quadrant arc
          else{
                arcStart = 270;
                g.drawArc(x, y, width, height, arcStart , 90);
                x += 11;
                y += 11;
                width -= 22;
                height -= 22;
          } // fourth quadrant arc
          
           
          if (count == howMany){
            g.setColor(Color.RED);
            g.fillArc(x - 11, y - 11, width + 22, height + 22, arcStart, 90);  
          } // fills the next successive arc red
       } // end for
    } // end of paintComponent()
    
    public void increaseHowMany(){
        howMany++;
    }
    
    public void resetHowMany(){
        howMany = 1;
    }
    
    public Integer getHowMany(){
        return howMany;
    }
    
    public void setLabel(Integer n){
        howMany = n;
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
