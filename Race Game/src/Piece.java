
import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
import java.util.Random;

public class Piece {
    
    private Integer anchorX, anchorY, size;
    private Color chipColor;
    private Integer arcLength, arc;
    private String name;
    private Boolean endGame;
    private Integer x;
    public MUPanel muPanel;
    Random randGen = new Random();
   
    
    
    public Piece(Integer x, Integer y, Color c, String n){
        anchorX = x;
        anchorY = y;
        size = 25;
        arcLength = 45;
        arc = 0;
        chipColor = c;
        name = n;
        
    } // end of constructor
    
    
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(anchorX, anchorY, size, size);
        
        g.setColor(chipColor);
        for(int i = 0; i < 5; i++){
           g.fillArc(anchorX, anchorY, size, size, arc, arcLength);
           arc += 90;
        } // end of spiral for loop
        g.setColor(Color.WHITE);
        g.fillOval(anchorX + 5, anchorY + 5, size - 10, size - 10);
        
        g.setColor(Color.BLACK);
        g.drawString(name, anchorX + 10, anchorY + 18);
    } // end of graphics
    
    
    public Integer getDown(){
        return anchorY;
    }
    public Integer getOver(){
        return anchorX;
    }
    public void setDown(Integer y){
        anchorY = y;
    }
    public Integer returnStep(){
        return x;
    }
    
    public Integer getRandomStep(){
        
                
        return x;
    }
    
    public void moveHorizontally(){
       
        if( !getEndGame() )  { 
        x = randGen.nextInt(40) + 10;
            anchorX += x;
        }
    }
    
    public Boolean getEndGame(){
        if (anchorX >= 600){
            endGame = true;
        }else{
            endGame = false;
        }
        return endGame;
   }
    
    
    
    
    
   
    
            
} // end of piece


