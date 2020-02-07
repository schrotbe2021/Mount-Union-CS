/**
 *
 * File:  Logo.java
 * 
 * Author: Ben Schroth
 * 
 * Description:
 *  Draws a golf club with a golf ball, pin, and pin number.
 * 
 */

import java.awt.*;

public class Logo {
    private Polygon grip, shaft, clubHead, endShaft, flag;
    private Integer anchorX;
    private Integer anchorY;
    private String  name;
    private Integer width;
    private Integer height;
    
    
    
    public Logo(Integer x, Integer y, String n) {
        anchorX = x;
        anchorY = y;
        name = n;
        width = 100;
        height = 100;
      
         //golf club
        shaft = new Polygon();
            shaft.addPoint(anchorX + 2, anchorY);
            shaft.addPoint(anchorX + 7, anchorY - 3);
            shaft.addPoint(anchorX + 105, anchorY + 197);
            shaft.addPoint(anchorX + 100, anchorY + 200);
        grip = new Polygon();
            grip.addPoint(anchorX, anchorY);
            grip.addPoint(anchorX + 9, anchorY - 5);
            grip.addPoint(anchorX + 24, anchorY + 25);
            grip.addPoint(anchorX + 15, anchorY + 30);
        clubHead = new Polygon();
            clubHead.addPoint(anchorX + 95, anchorY + 190);
            clubHead.addPoint(anchorX + 135, anchorY + 185);
            clubHead.addPoint(anchorX + 130, anchorY + 205);
            clubHead.addPoint(anchorX + 105, anchorY + 210);
        endShaft = new Polygon();
            endShaft.addPoint(anchorX + 92, anchorY + 183);
            endShaft.addPoint(anchorX + 97, anchorY + 180);
            endShaft.addPoint(anchorX + 102, anchorY + 190);
            endShaft.addPoint(anchorX + 96, anchorY + 193);
        flag = new Polygon();
            flag.addPoint(anchorX + 180, anchorY - 15);
            flag.addPoint(anchorX + 232, anchorY - 35);
            flag.addPoint(anchorX + 232, anchorY - 5);
        
            
         
    } // end of constructor
    
    
    public void draw( Graphics g ) {
               
        //Shaft
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(shaft);
        //Grip
        g.setColor(Color.BLACK);
        g.fillPolygon(grip);
        //Clubhead
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(clubHead);
        //Grooves
        g.setColor(Color.BLACK);
        g.drawLine(anchorX + 104, anchorY + 192, anchorX + 130, anchorY + 189);
        g.drawLine(anchorX + 105, anchorY + 195, anchorX + 129, anchorY + 192);
        g.drawLine(anchorX + 106, anchorY + 198, anchorX + 128, anchorY + 195);
        g.drawLine(anchorX + 107, anchorY + 201, anchorX + 127, anchorY + 198);
        g.drawLine(anchorX + 108, anchorY + 204, anchorX + 126, anchorY + 201);
        //End Shaft
        g.setColor(Color.DARK_GRAY);
        g.fillPolygon(endShaft);
        //Golf Ball
        g.setColor(Color.BLACK);
        g.drawOval(anchorX + 200, anchorY + 165, 10, 10);
        g.setColor(Color.WHITE);
        g.fillOval(anchorX + 200, anchorY + 165, 10, 10);
        //Top of Flag
        g.setColor(Color.BLACK);
        g.fillOval(anchorX + 225, anchorY + 150, 15, 10);
        //Flag Pole
        g.setColor(Color.yellow);
        g.fillRect(anchorX + 231, anchorY - 40, 3, 200);
        g.fillOval(anchorX + 228, anchorY - 45, 8, 8);
        //Flag
        g.setColor(Color.yellow);
        g.fillPolygon(flag);
        //Hole Number on flag
        g.setColor(new Color(178, 76, 88));
        g.drawString(name, anchorX + 210, anchorY - 15);
        
        
    } // end of draw()
    
    
    @Override
    public String toString() {
        return "My name is " + name + " and I am a Logo that is "
                + width + " wide and " + height + " high";
    } // end of toString()

    private Polygon newPolygon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
} // end of class Logo
