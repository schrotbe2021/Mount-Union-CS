/*
Ben Schroth
2/26/2018
Description: Draws the background and a sun object that rises and sets with a button.

*/
import java.awt.Color;
import java.awt.Graphics;

public class Sun {
    
    
    
    private final Integer TOP_EDGE = 50;
    private final Integer BOTTOM_EDGE = 500;
    
    
    private Integer anchorX;
    private Integer anchorY;
    private Integer size = 75;
    private Boolean dayNight;
    private Integer verticalStepSize = -25;
    
    public Sun(Integer x, Integer y, Boolean dN) {
        dayNight = dN;
        anchorX = x;
        anchorY = y;
    } // end of constructor
    
     public void draw(Graphics g) {
               
         if (dayNight == true){
             g.setColor(new Color(135, 206, 235));
             g.fillRect(0, 0, 600, 500);
             
             g.setColor(Color.yellow);
             g.fillOval(anchorX, anchorY, size, size);
         }
         else{
             g.setColor(Color.BLACK);
             g.fillRect(0, 0, 600, 500);
             
             g.setColor(Color.WHITE);
             g.fillOval(anchorX, anchorY, size, size);
             g.setColor(Color.LIGHT_GRAY);
             g.fillOval(anchorX + 15, anchorY + 10, size/4, size/4);
             g.fillOval(anchorX + 35, anchorY + 15, size/10, size/10);
             g.fillOval(anchorX + 25, anchorY + 30, size/8, size/8);
             g.fillOval(anchorX + 20, anchorY + 35, size/6, size/6);
         }
         
         
         
     } // end of draw method
     
     public void moveVertically(){
            if ((anchorY + verticalStepSize <= TOP_EDGE) || (anchorY + verticalStepSize >= BOTTOM_EDGE)){
                verticalStepSize = -1 * verticalStepSize;
            }
            
           anchorY += verticalStepSize;
    } // end of MoveVertically
     
    public void changeTime() {
        dayNight =! dayNight;
    }// end of changeTime
    
   public void growSun(){
        if (verticalStepSize > 1){
            size += 2;
           
            anchorX -= 1;
                   
        }
        else{
            size -= 2;
            anchorX += 1;
        }
    } 
    
} // end of sun class
