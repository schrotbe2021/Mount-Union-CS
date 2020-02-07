
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class MUPanel extends JPanel {

    // 1. Declare private objects here:
    private Background background;
    public Piece[] gamePieces;
    private Integer count, anchorX, anchorY, step;
    private Color pieceColor;
    private String name;
    public Boolean endGame;
    private Random randGen;
    
    

    // constructor method
    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setName("Mount Union Java Program");
        setUp();
        setBackground(Color.WHITE);
        
        background = new Background();
       
        gamePieces = new Piece[6];
        anchorX = 4;
        anchorY = 257;
        endGame = false;
        

        // 2. Instantiate objects here by calling "new":
         for (int i = 0; i < gamePieces.length; i++){
             
             if (i == 0){
                 name = "1";
                 pieceColor = Color.RED;
             } else if (i == 1){
                 name = "2";
                 pieceColor = Color.ORANGE;
             } else if (i == 2){
                 name = "3";
                 pieceColor = Color.YELLOW;
             } else if (i == 3){
                 name = "4";
                 pieceColor = Color.GREEN;
             } else if (i == 4){
                 name = "5";
                 pieceColor = Color.PINK;
             } else if (i == 5){
                 name = "6";
                 pieceColor = Color.magenta;
             }
             
             if(anchorX <= 775){
                 endGame = false;
             }else{
                 endGame = true;
             }
             
             
             gamePieces[i] = new Piece(anchorX, anchorY, pieceColor, name);
             
            
             
             
             
             anchorY += 40;
         }
         
        
    } // end of constructor
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // This line must be first in this method!

        // 3. Call methods of objects here:
        background.draw(g);
        
        for (int i = 0; i < gamePieces.length; i++){
            gamePieces[i].draw(g);
        }
        
        
      
		
		
    } // end of paintComponent()
    
      public void movePieces( Piece[] theArray){
         for ( int i = 0; i < gamePieces.length; i++ ){
             if (endGame == false){
                 gamePieces[i].moveHorizontally();
                 
             } 
        }  
      } // end of movePieces()
      
      
  
      
    
    
       
    
    
    
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
