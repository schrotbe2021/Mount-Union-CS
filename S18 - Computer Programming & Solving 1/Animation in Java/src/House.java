/*
Ben Schroth
2/26/2018
Description: Draws a house that you can turn the lights on or off.

*/


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class House {
    
    private Boolean lights;
    private Polygon roof;
    
    public House(Boolean lts){
        lights = lts;
        
        roof = new Polygon();
            roof.addPoint(90, 325);
            roof.addPoint(200, 250);
            roof.addPoint(310, 325);
                
    }
    
    public void draw(Graphics g){
        g.setColor(new Color(255,222,173));
        g.fillRect(100, 325, 200, 125);
        g.setColor(new Color(101, 67, 33));
        g.fillPolygon(roof);
        
        g.setColor(new Color(101, 67, 33));
        g.fillRect(190, 400, 25, 50);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(205, 420, 5, 5);
        
        
        
        if(lights == true){
            g.setColor(Color.BLACK);
            g.fillRect(230, 350, 20, 20);
            g.fillRect(255, 350, 20, 20);
            g.fillRect(230, 375, 20, 20);
            g.fillRect(255, 375, 20, 20);
            
            g.fillRect(130, 350, 20, 20);
            g.fillRect(155, 350, 20, 20);
            g.fillRect(130, 375, 20, 20);
            g.fillRect(155, 375, 20, 20);
        }
        else {
            g.setColor(Color.YELLOW);
            g.fillRect(230, 350, 20, 20);
            g.fillRect(255, 350, 20, 20);
            g.fillRect(230, 375, 20, 20);
            g.fillRect(255, 375, 20, 20);
            
            g.fillRect(130, 350, 20, 20);
            g.fillRect(155, 350, 20, 20);
            g.fillRect(130, 375, 20, 20);
            g.fillRect(155, 375, 20, 20);
        }
    } // end of draw
    
    public void changeLights(){
        lights =! lights;
    }
} // end of House class
