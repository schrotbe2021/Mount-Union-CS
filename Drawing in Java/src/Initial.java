/**
 *
 * File:  Logo.java
 * 
 * Author: 
 * 
 * Description:
 * 
 */

import java.awt.*;

public class Initial {

    private Integer anchorX;
    private Integer anchorY;
    private Integer width;
    private Integer height;
    private String  name;
    private Color   aColor;
    private Color bColor;
    
    
    public Initial(Integer x, Integer y, String n, Color c, Color b) {
        anchorX = x;
        anchorY = y;
        width = 100;
        height = 100;
        name = n;
        aColor = c;
        bColor = b;
        
    } // end of constructor
    
    
    public void draw( Graphics g ) {
        
        // B
        g.setColor(aColor);
        g.fillRect(anchorX, anchorY, 15, 125);
        g.fillArc(anchorX - 35, anchorY - 1, 100, 60, 270, 180);
        g.fillArc(anchorX - 50, anchorY + 50, 125, 75, 270, 180);
        g.setColor(new Color(7,102,82));
        g.fillArc(anchorX - 25, anchorY + 10, 75, 40, 270, 180);
        g.fillArc(anchorX - 37, anchorY + 60, 100, 55, 270, 180);
        
        
        // E
        g.setColor(bColor);
        g.fillRect(anchorX + 85, anchorY, 10, 125);
        g.fillRect(anchorX + 85 , anchorY, 60, 10);
        g.fillRect(anchorX + 85, anchorY + 55, 50, 10);
        g.fillRect(anchorX + 85 , anchorY + 115, 60, 10);
        
        // S
        g.setColor(aColor);
        g.fillArc(anchorX + 155, anchorY, 150, 75, 90, 180);
        g.fillArc(anchorX + 100, anchorY + 50, 150, 75, 270, 180);
        g.setColor(new Color(7,102,82));
        g.fillArc(anchorX + 180, anchorY + 15, 100, 45, 90, 180);
        g.fillArc(anchorX + 125, anchorY + 70, 100, 45, 270, 180);
        g.setColor(Color.BLACK);
   
        
        
       
    } // end of draw()
    
    
    @Override
    public String toString() {
        return "My name is " + name + " and I am a Logo that is "
                + width + " wide and " + height + " high";
    } // end of toString()
    
    
} // end of class Logo
