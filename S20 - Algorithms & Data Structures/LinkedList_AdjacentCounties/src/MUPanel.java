/*
    CSC 320
    Program # 3

    Author: Ben Schroth

    Date: 2/22/2020
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
    private TextArea theArea;
    private JButton  browseCountyButton, browseBorderButton,
                     openCountyButton, openBorderButton,
                     processButton;
    private JTextField countyFileNameField, borderFileNameField;
    private Choice   firstCountyChoice, secondCountyChoice;
    
    /*
        @Label: Label to display count name
        @String[]: Array for list of counties in X_counties.txt
        @LinkedList[]: LinkedList array of bordering counties in X_starter_borders.txt
    */
    private Label countyLabel;
    private String[] countyArray;
    private LinkedList[] countyLinkedList;
    
    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setName("CSC 320 Program # 3 - Bordering Counties");
        setBackground(new Color(0xa0, 0xb7, 0x45));

        setUpGUI();
        
    } // end of MUPanel constructor
    
    public void readCountyNamesFromFile(BufferedReader inFile) throws IOException {
        int lineNum = -1;
        theArea.setText(""); // erases previous displayed output
        
        // Diplays name of states above text area with countyLabel. Found at bottom of setupGUI()
        String labelCounty = inFile.readLine();
        countyLabel.setText(labelCounty);
        
        /*
         Reads number of counties and instantiates array for list of counties
         Also instantiates Linked List of counties
        */
        Integer numCounties = Integer.parseInt(inFile.readLine());
        countyArray = new String[numCounties];
        countyLinkedList = new LinkedList[numCounties];
        
        /*
            Sets default drop down to toggle a choice.
        */
        firstCountyChoice.add("Choose county...");
        secondCountyChoice.add("Choose county...");
        
        /*
            Reads first line.
            While there are lines to read, add one to nextLine for countyArray, 
            store the input into countyArray, add the input to the dropdown 
            menus, and go to the next line.
        */
        String line = inFile.readLine();
        while (line != null) {
            lineNum++;
            countyArray[lineNum] = line;
            firstCountyChoice.add(line);
            secondCountyChoice.add(line);

            line = inFile.readLine();
        } // end while
    } // end of readCountyNamesFromFile
    
    // Builds linked list of adjacent counties into countyLinkedList
    public void buildAdjacencyLists(BufferedReader inFile) throws IOException {
        /*
            @lineNum: Current variable to add to LinkedList for countyArray.
            @currentCountyNumber: Finds current county in countyArray to build LinkedList of county being read
        */
        int lineNum = 0;
        int currCountyNumber = -1;
        
        theArea.setText(""); // erases previous displayed output
        
        // @line: Reads first line of input
        String line = inFile.readLine();
        
        // while loop if input line is not empty
        while (line != null) {
            
            /*
            Adds one to lineNum for array control.
        
            @colon: Finds index of colon in input for substring
            @county: Takes substring of the input for name of the county to add linked list
        
            for loop iterating through countyArray:
                Checks if @county is in the array countyArray and stores
                it as the index to build LinkedList of adjacent counties.
            */
            lineNum++;
            Integer colon = line.indexOf(":");
            String county = line.substring(0, colon);
            for(int i = 0; i < countyArray.length; i++) {
                if (countyArray[i].equals(county))
                    currCountyNumber = i;
            } // end for loop
            
            /*
            @countyLinkedList[currCountyNumber]: instantiates new linked list in index of county
            @adjCountiesString: Substring of the input of adjacent counties
            @adjCounties: String array of adjacent counties split by a comma.
            @addLinkPos: Position of adjacent county to add in countyArray
            */
            countyLinkedList[currCountyNumber] = new LinkedList();
            String adjCountiesString = line.substring(colon + 1);
            String[] adjCounties = adjCountiesString.split(",");
            Integer addLinkPos = -1;
            
            /*
            for loop iterating adjCounties input:
                Trims white space of input
            
                for loop iterating through countyArray
                    if adjacentCounty in input is found in countyArray store
                    index to be added to countyLinkedList of currentCounty
            */
            for (int i = 0; i < adjCounties.length; i++) {
                
                line.trim();
                for (int j = 0; j < countyArray.length; j++) {
                    if (countyArray[j].equals(adjCounties[i]))
                        addLinkPos = j;
                } //end for loop
                
                countyLinkedList[currCountyNumber].insertFirst(addLinkPos);
            } // end for loop
            
            line = inFile.readLine();
        } // end while
    } // end of buildAdjacencyLists


    public void checkForAdjacentCounties() {
        
        /*
            @firstInput: takes input of first dropdown menu
            @secondInput: takes input of first dropdown menu
        */
        String firstInput = firstCountyChoice.getSelectedItem();
        String secondInput = secondCountyChoice.getSelectedItem();
        
        /*
            @firstInputPosition: Position of input in countyArray
            @secondInputPosition: Position of input in countyArray
        */
        Integer firstInputPosition = -1;
        Integer secondInputPosition = -1;
        
        /*
            for loop iterating through county array
                if statements finds the posiiton of each input and stores
                into first and second position
        */
        for (int i = 0; i < countyArray.length; i++) {
            if (firstInput.equals(countyArray[i]))
                firstInputPosition = i;
            if (secondInput.equals(countyArray[i]))
                secondInputPosition = i;
        } // end for loop
        
        /*
        @current: takes first link of countyLinkedList in first input position
        @found: check for if the county is found in loop for text area output
        */
        Link current = countyLinkedList[firstInputPosition].getFirst();
        Boolean found = false;
       
        /*
        while loop iterates through links
            if position of second input is in the first input
                print they are adjacent to area
                set found to true
            move to the next link
        */
        while(current != null) {
            if (current.data == secondInputPosition) {
                theArea.append(firstInput + " is adjacent to " + secondInput + ".\n\n");
                found = true;
            }
            current = current.next;
        } // end of while
        
        /*
        if second input is not in first input
            print they are not adjacent
        */
        if (found == false) {
            theArea.append(firstInput + " is not adjacent to " + secondInput + ".\n\n");
        } // end if
        
    } // end checkForAdjacenctCounties

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(processButton)) {
            checkForAdjacentCounties();
        } // end of processButton handler
        
        if (source.equals(browseCountyButton)) {
            JFileChooser fc = new JFileChooser(".\\");
            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                countyFileNameField.setText( file.getName() );
            }            
            openCountyButton.setEnabled(true);
        } // end of browseCountyButton handler
        
        if (source.equals(browseBorderButton)) {
            JFileChooser fc = new JFileChooser(".\\");
            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                borderFileNameField.setText( file.getName() );
            }         
            openBorderButton.setEnabled(true);

        } // end of browseBorderButton handler
        
        if (source.equals(openCountyButton)) {
	    String filename = countyFileNameField.getText();
            
	    try {
	        FileReader fr = new FileReader( filename );
	        BufferedReader inFile = new BufferedReader( fr );
	        
                readCountyNamesFromFile(inFile);
	        
	        inFile.close();

                theArea.append("^^^^^^^^^^^^^^^^\n" +
                        "The file " + filename + 
                              " was successfully read\n");
                
                browseBorderButton.setEnabled(true);
                firstCountyChoice.setEnabled(true);
                secondCountyChoice.setEnabled(true);
	    }
	    catch (FileNotFoundException exep) {
	        theArea.append("The file \"" + filename + "\" was not found.\n");
	    }
	    catch (IOException exep) {
	        theArea.append(exep + "\n");
	    }
        } // end of openCountyButton handler
	    
        if (source.equals(openBorderButton)) {
	    String filename = borderFileNameField.getText();
            
	    try {
	        FileReader fr = new FileReader( filename );
	        BufferedReader inFile = new BufferedReader( fr );
	        
                buildAdjacencyLists(inFile);
                
	        inFile.close();

                theArea.append("^^^^^^^^^^^^^^^^\n" +
                        "The file " + filename + 
                              " was successfully read\n");
                
                processButton.setEnabled(true);
                
	    }
	    catch (FileNotFoundException exep) {
	        theArea.append("The file \"" + filename + "\" was not found.\n");
	    }
	    catch (IOException exep) {
	        theArea.append(exep + "\n");
	    }
        } // end of openBorderButton handler
	    
    } // end of actionPerformed
     
    private void setUpGUI() {     
        Font biggerFont = new Font("Serif", Font.BOLD, 14);
        
        theArea = new TextArea();
        theArea.setBounds(10, 180, 760, 360);
        theArea.setFont( new Font("Monospaced", Font.BOLD, 16) );
        add(theArea);
      
        
        
        openCountyButton = new JButton("Read County File");
        openCountyButton.setBounds(10, 130, 130, 30);
        openCountyButton.setEnabled(false);
        openCountyButton.addActionListener(this);
        add(openCountyButton);
        
        openBorderButton = new JButton("Read Border File");
        openBorderButton.setBounds(155, 130, 130, 30);
        openBorderButton.addActionListener(this);
        openBorderButton.setEnabled(false);
        add(openBorderButton);
        
        browseCountyButton = new JButton("Browse for file");
        browseCountyButton.setBounds(540, 20, 120, 30);
        browseCountyButton.addActionListener(this);
        add(browseCountyButton);
        
        Label inputLabel = new Label("County Name File:");
        inputLabel.setBounds(20, 20, 130, 30);
        inputLabel.setFont( biggerFont );
        add(inputLabel);
        
        countyFileNameField = new JTextField("Browse for a County File");
        countyFileNameField.setBounds(160, 20, 360, 30);
        countyFileNameField.setFont( new Font("SansSerif", Font.BOLD, 14) );
        add(countyFileNameField);
        
        browseBorderButton = new JButton("Browse for file");
        browseBorderButton.setBounds(540, 70, 120, 30);
        browseBorderButton.setEnabled(false);
        browseBorderButton.addActionListener(this);
        add(browseBorderButton);
        
        Label inputLabel2 = new Label("Border Name File:");
        inputLabel2.setBounds(20, 70, 130, 30);
        inputLabel2.setFont( biggerFont );
        add(inputLabel2);
        
        borderFileNameField = new JTextField("Browse for a Border File");
        borderFileNameField.setBounds(160, 70, 360, 30);
        borderFileNameField.setFont( new Font("SansSerif", Font.BOLD, 14) );
        add(borderFileNameField);
        
        Label choiceLabel1 = new Label("Choose a County:");
        choiceLabel1.setBounds(340, 115, 130, 25);
        choiceLabel1.setFont( biggerFont );
        add(choiceLabel1);
        
        firstCountyChoice = new Choice();
        firstCountyChoice.setBounds(340, 140, 130, 25);
        firstCountyChoice.setEnabled(false);
        add(firstCountyChoice);
        
        Label choiceLabel2 = new Label("Choose another:");
        choiceLabel2.setBounds(485, 115, 130, 25);
        choiceLabel2.setFont( biggerFont );
        add(choiceLabel2);
        
        secondCountyChoice = new Choice();
        secondCountyChoice.setBounds(485, 140, 130, 25);
        secondCountyChoice.setEnabled(false);
        add(secondCountyChoice);
        
        processButton = new JButton("Are they adjacent?");
        processButton.setBounds(630, 130, 140, 30);
        processButton.addActionListener(this);
        processButton.setEnabled(false);
        add(processButton);
        
        countyLabel = new Label("");
        countyLabel.setBounds(10, 155, 200, 30);
        countyLabel.setFont(biggerFont);
        add(countyLabel);
                
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
