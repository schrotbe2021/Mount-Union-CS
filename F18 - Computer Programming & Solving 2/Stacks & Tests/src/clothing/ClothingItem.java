/*
    Ben Schroth
    PA5 - Dr. Weber CSC 220
    12/7/2018
    ClothingItem class
*/

package clothing;

import javafx.scene.paint.Color;

public class ClothingItem 
{
    private String name;
    private Color color;
    private Boolean wash;
    
    public ClothingItem(String n, Color c, Boolean w)
    {
        name = n;
        color = c;
        wash = w;
    } // end of constructor
    
    // Accessors for ClothingItem class.
        public String getName( ) { return name; }
        public Color getColor( ) { return color; }
        public Boolean getWash( ) { return wash; }
    
    // Mutators for ClothingItem class.
        public void setName( String n ) { name = n; }
        public void setColor( Color c ) { color = c; }
        public void setWash( Boolean w ) { wash = w; }
        
    @Override
    public String toString( ) 
    {
        return ("Name : " + name + " " + "Color: " + color); 
    } // end of toString
} // end of ClothingItem class
