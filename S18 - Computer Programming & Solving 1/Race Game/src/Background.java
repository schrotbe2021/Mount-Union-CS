
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author schrotbe2021
 */
public class Background {
    private Integer anchorX, anchor2X, anchorRX;
    private Integer anchorY, anchor2Y, anchorRY;
    private Integer rows, columns;
    
    
   
   
    public Background() {
        anchorX = 0;
        anchorY = 250;
        anchor2X = 0;
        anchor2Y = 490;
        anchorRX = 800;
        anchorRY = 0;
        rows = 5;
        columns = 30;
    } // end of constructor
    void draw(Graphics g){
       
      g.setColor(Color.LIGHT_GRAY);
      g.fillRect(0, 250, 800, 240);
      
      g.setColor(new Color(144, 238, 144));
      g.fillRect(0, 0, 800, 250);
      
      g.setColor(Color.BLACK);
      
      
      
      
      g.drawLine(775, 250, 775, 490);
      
      g.drawLine(0, 250, 800, 250);
      g.drawLine(0, 290, 800, 290);
      g.drawLine(0, 330, 800, 330);
      g.drawLine(0, 370, 800, 370);
      g.drawLine(0, 410, 800, 410);
      g.drawLine(0, 450, 800, 450);
      g.drawLine(0, 490, 800, 490);
      
      
      
        
        
    } // end of draw method
} // end of Background class
