/* CSC 120 PA1
 * Ben Schroth
 * 1/25/2018
 *
 * Project Description:
 *  Golf logo with my intials, BES. 
 * Enhancements: Masters Green color, custom red color, and polygons in logo class for golf club.
 */
import java.awt.*;
import javax.swing.*;

public class MUPanel extends JPanel {
    
    //Declare
    private Logo golfClub, secondLogo;
    private Initial initials, bes2;
    
    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(1080, 720));
        setName("Java Master's");
        setUp();
        setBackground(new Color(7, 102, 82));
        
        //Instantiate
        golfClub = new Logo(100, 100, "19");
        secondLogo = new Logo(600, 400, "1");
        initials = new Initial(500, 100, "BES 1", new Color(187, 167, 149), new Color(178, 76, 88));
        bes2 = new Initial(250, 400, "BES 2", new Color(178, 76, 88), new Color(187, 167, 149));
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Drawing
        golfClub.draw(g);
        secondLogo.draw(g);
        initials.draw(g);
        bes2.draw(g);
		
		
    } // end of paintComponent()
    
    
    
       
    
    
    
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
        f.setVisible(true);    
    }

    public static void main(String args[]){new MUPanel();}

    private void Logo(int i, int i0, String test) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} // end of class MUPanel
