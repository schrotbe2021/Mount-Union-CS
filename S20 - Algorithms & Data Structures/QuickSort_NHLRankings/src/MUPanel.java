/*
    CSC 320
    Program # 4

    Author:  Ben Schroth

    Date:    3/23/2020
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class MUPanel extends JPanel implements ActionListener {

    //*********
    // Objects for GUI:
    //*********
    private JButton  readFileButton, processButton;
    private JComboBox  statCategoryCombo, howManyCombo;
    private Label fileLabel;
    private JLabel output;
    
    // ArrayList of PlayerRecord objects
    private ArrayList<PlayerRecord> players = new ArrayList<PlayerRecord>();

    
    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(800, 700));
        setName("CSC 320 Program # 4 - Sorting by Category");
        setBackground(new Color(86, 160, 211));
        setForeground(Color.WHITE);

        setUpGUI();
        
    } // end of MUPanel constructor
    
    /*
        QuickSort Method inspired by Prof Cindric
        
        Param:
            @list: input of PlayerRecord objects from file
            @start: beginnig index of list to be sorted
            @end: ending index of list to be sorted
    */
    public void quickSort(ArrayList<PlayerRecord> list, int start, int end)
    {
        
        if (start < end)
        {
            Integer pivot = getCategoryValue(list, ((start+end)/2));
            int left = start;
            int right = end;
            
            do
            {
                while(getCategoryValue(list, left).compareTo(pivot) < 0)
                {
                    left++;
                }
                while(getCategoryValue(list, right).compareTo(pivot) > 0)
                {
                    right--;
                }
                if (left <= right) 
                {
                    PlayerRecord temp = list.get(left);
                    list.set(left, list.get(right));
                    list.set(right, temp);
                    left++;
                    right--;
                }
                
            } while (left <= right);
            
            quickSort(list, start, right);
            quickSort(list, left, end);
        }
    }
    
    /*
        Method for quickSort() to sort by given category. Returns value of category.
    
        Param:
            @list: list of PlayerRecord objects to get value from
            @index: index of PlayerRecord to get value from
    */
    public Integer getCategoryValue(ArrayList<PlayerRecord> list, int index)
    {
        // Retrieves index of category combo box
        int statCategoryIndex = statCategoryCombo.getSelectedIndex();
            
            // Switch statement that returns the integer of the correct category at that index. 
            switch (statCategoryIndex) {
                case 0: 
                    return list.get(index).getGoals(); 
                       
                case 1: 
                    return list.get(index).getAssists(); 
                        
                case 2: 
                    return list.get(index).getPoints(); 
                     
                case 3: 
                    return list.get(index).getPenaltyMin(); 
            }
        // Returns zero if not found
        return 0;
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(processButton)) {
            int howManyIndex = howManyCombo.getSelectedIndex();
            int statCategoryIndex = statCategoryCombo.getSelectedIndex();
            
            String statCategory = "";
            switch (statCategoryIndex) {
                case 0: statCategory = "goals"; 
                        break;
                case 1: statCategory = "assists"; 
                        break;
                case 2: statCategory = "points"; 
                        break;
                case 3: statCategory = "penalty minutes"; 
                        break;
            } // end switch
            
            Integer howMany = 0;
            switch (howManyIndex) {
                case 0: howMany = 5; 
                        break;
                case 1: howMany = 10; 
                        break;
                case 2: howMany = 25; 
                        break;
            } // end switch
            
            // Call to quickSort() when Sort and Display is pressed.
            quickSort(players, 0, players.size() - 1);
            
            // Countdown variable to display in descending order
            Integer countdown = howMany;
            
            /*
                Displays the sorted list in descending order into a JLabel. I opted
                for a JLabel because I thought it would look cleaner. HTML tags are used
                because JLabel's can process HTML tags to be able to display on multiple
                lines.
            
            Ref:
                <html>: opening tag for string to be displayed
                <br>: Creates a new line (same as \n)
                </html>: closing tag for string to be displayed
                Source: https://coderanch.com/t/340178/java/multi-line-java-awt-Label
            
                PlayerRecord toString method takes a parameter of the statCategory to
                display just the value of the category to be chosen. Further doc
                in PlayerRecord.java
            */
            String result = "<html>";
            result += "     Displaying top " + howMany + " players in "
                                + statCategory + ":<br><br>";
            for (int i = players.size() - howMany; i < players.size(); i++)
            {
                result += countdown + ": " + players.get(i).toString(statCategory) + "<br>";
                countdown--;
            }
            result += "</html>";
            output.setText(result);
            
        } // end of processButton handler
        
        if (source.equals(readFileButton)) {
            JFileChooser fc = new JFileChooser(".\\");
            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                String filename = file.getName();

                try {
                    FileReader fr = new FileReader( filename );
                    BufferedReader inFile = new BufferedReader( fr );

                    String line = inFile.readLine();
                    fileLabel.setText(line);
                    
                    line = inFile.readLine();
                    while (line != null) {
                        
                        // Splits line by comma to read data
                        String[] player = line.split(",");
                       
                        // Stores data into variables for cleaner code when creating object
                        String name = player[0];
                        String team = player[1];
                        String position = player[2];
                        Integer goals = Integer.parseInt(player[3]);
                        Integer assists = Integer.parseInt(player[4]);
                        Integer points = Integer.parseInt(player[5]);
                        Integer penaltyMin = Integer.parseInt(player[6]);
                        
                        // New PlayerRecord object
                        PlayerRecord newPlayer = new PlayerRecord(name, team,
                                     position, goals, assists, points, penaltyMin);
                        
                        // Appends new PlayerRecord object to ArrayList players
                        players.add(newPlayer);

                        line = inFile.readLine();
                    } // end while
                    
                    inFile.close();
                    
                    

                    processButton.setEnabled(true);
                }
                catch (FileNotFoundException exep) {
                    fileLabel.setText("The file \"" + filename + "\" was not found.\n");
                }
                catch (IOException exep) {
                    fileLabel.setText(exep + "\n");
                }
            }            
        } // end of readInputButton handler
	    
    } // end of actionPerformed
    
    
    
    private void setUpGUI() {     
        Font biggerFont = new Font("Serif", Font.BOLD, 14);

        // Label that displays if file is read
        fileLabel = new Label("^^ Choose .txt File ^^");
        fileLabel.setBounds(10, 70, 500, 15);
        fileLabel.setFont(biggerFont);
        fileLabel.setForeground(Color.white);
        add(fileLabel);
        
        
        // Ouput label. Alligns to top left for consistency when displayed.
        output = new JLabel("Make input file selection and press Sort and Display");
        output.setHorizontalAlignment(SwingConstants.LEFT);
        output.setVerticalAlignment(SwingConstants.TOP);
        output.setBounds(10, 100, 500, 600);
        output.setFont(biggerFont);
        output.setForeground(Color.white);
        add(output);
        
        
        readFileButton = new JButton("Read Input File");
        readFileButton.setBounds(10, 30, 130, 35);
        readFileButton.addActionListener(this);
        add(readFileButton);
        
        Label choiceLabel1 = new Label("Sort by ...");
        choiceLabel1.setBounds(210, 10, 130, 25);
        choiceLabel1.setFont( biggerFont );
        add(choiceLabel1);
        
        statCategoryCombo = new JComboBox();
        statCategoryCombo.setBounds(210, 40, 130, 25);
        statCategoryCombo.addItem("Goals");
        statCategoryCombo.addItem("Assists");
        statCategoryCombo.addItem("Points");
        statCategoryCombo.addItem("Penalty Minutes");
        add(statCategoryCombo);
        
        Label choiceLabel2 = new Label("How many to display?");
        choiceLabel2.setBounds(400, 10, 150, 25);
        choiceLabel2.setFont( biggerFont );
        add(choiceLabel2);
        
        howManyCombo = new JComboBox();
        howManyCombo.setBounds(400, 40, 130, 25);
        howManyCombo.addItem("Top 5");
        howManyCombo.addItem("Top 10");
        howManyCombo.addItem("Top 25");
        add(howManyCombo);
        
        processButton = new JButton("Sort and Display");
        processButton.setBounds(630, 30, 140, 35);
        processButton.addActionListener(this);
        processButton.setEnabled(false);
        add(processButton);
                
    } // end of setUpGUI

    
    /***********************************************
     * Do NOT change or delete anything below here!
     ***********************************************/
    public void frame()
    {
//        for (Component c: getComponents())
//            c.setSize(c.getPreferredSize());
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);    
    }

    public static void main(String args[]){new MUPanel().frame();}

} // end of class MUPanel
