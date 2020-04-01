/*
	Way Cool Systems, Inc.
	Prototype Connect4 Board Class
	Last updated:  1/7/20

      NEEDS TO BE MODIFIED TO WORK PROPERLY!	
*/

///////////////////////////////////////////////////////////////

import java.awt.*;
import java.util.*;

public class Connect4Board {
    
    private final static Integer NUM_ROWS = 8;
    private final static Integer NUM_COLUMNS = 9;
    
    private Integer selectedRow, selectedColumn;
    private Connect4Square[][] board;
    
    public Connect4Board() {
        board = new Connect4Square[NUM_ROWS][NUM_COLUMNS];
        
        for (int i = 0; i < NUM_ROWS; i++)
        {
            for (int j = 0; j < NUM_COLUMNS; j++)
            {
                board[i][j] = new Connect4Square(0, i, j);
            }
        }
        
        selectedRow = -1;
        selectedColumn = -1;
    } // end of Constructor
    
    public void setValue(int r, int c, int value) {
        if (r >= 0 && r <= 7 && c >= 0 && c <= 8 && value >= 0 && value <= 2)
        {
            board[r][c].setValue(value);
        }
    } // end of setValue()

    public void setSelected( int value ) {
        this.setValue(selectedRow, selectedColumn, value);
    } // end of setSelected()

    public void setSelectedRow(int r) {
         if (r >= 0 && r <= 7)
         {
             selectedRow = r;
         }
    } // end of setSelectedRow()
    
    public void setSelectedColumn(int c) {
        if (c >= 0 && c <= 8)
        {
            selectedColumn = c;
        }
    } // end of setSelectedColumn()
    
    public int getSelectedRow() { return selectedRow; }
    public int getSelectedColumn() { return selectedColumn; }
    
    public int getValue(int r, int c) {
        if (r >= 0 && r <= 7 && c >= 0 && c <= 8)
        {
            return board[r][c].getValue();
        }
        
        return -1;
    }
    
    public int getRowOfLowestEmptySquareInSelectedColumn() {
        int row = 7;
        while (row >= 0 && board[row][selectedColumn].getValue() != Connect4Square.EMPTY) {
            row -= 1;
        }
        return row;
    }

    public int checkForAWinner() {
        
        // Checks rows for a winner
        for (int i = 0; i < NUM_ROWS; i++) {
            if(checkRowsRedWinner(  i) == 1)
                return Connect4Square.RED;
            
            if(checkRowsGreenWinner(i) == 2)
                return Connect4Square.GREEN;
        }
        //*****************************************
        //Checks columns for a winner
        for (int i = 0; i < NUM_COLUMNS; i++) {
            if (checkColumnRedWinner(i) == 1)
                return Connect4Square.RED;
            if (checkColumnGreenWinner(i) == 2)
                return Connect4Square.GREEN;
        }
        //*****************************************
        //Checks right diagonals for a red winner
        for (int row = 0; row < NUM_ROWS; row++){
            if (checkDownToRightDiagonalForRedWin(row, 0) == 1)
                return Connect4Square.RED;
        } // Runs through the bottom half of the matrix
        for(int col = 0; col < NUM_COLUMNS; col++) {
            if (checkDownToRightDiagonalForRedWin(0, col) == 1)
                return Connect4Square.RED;
        } //Runs through the top half of the matrix
        //*****************************************
        //Checks right diagonals for a green winner
        for(int row = 0; row < NUM_ROWS; row++){
            if (checkDownToRightDiagonalForGreenWin(row, 0) == 2)
                return Connect4Square.GREEN;
        }
        for (int col = 0; col < NUM_COLUMNS; col++){
            if (checkDownToRightDiagonalForGreenWin(0, col) == 2)
                return Connect4Square.GREEN;
        }
        //*****************************************
        //Checks left diagnonals for a red winner
        for(int row = 0; row < NUM_ROWS; row++){
            if(checkDownToLeftDiagonalForRedWin(row, 8) == 1)
                return Connect4Square.RED;
        }
        for(int col = 0; col < NUM_COLUMNS; col++){
            if(checkDownToLeftDiagonalForRedWin(0, col) == 1)
                return Connect4Square.RED;
        }
        //*****************************************
        //Checks left diagnonals for a green winner
        for(int row = 0; row < NUM_ROWS; row++){
            if (checkDownToLeftDiagonalForGreenWin(row, 0) == 2)
                return Connect4Square.GREEN;
        }
        for(int col = 0; col < NUM_COLUMNS; col++){
            if (checkDownToLeftDiagonalForGreenWin(0, col) == 2)
                return Connect4Square.GREEN;
        }
        
        // Last case, no winner
        return Connect4Square.EMPTY;
    }
    
    /**************Methods to check winner************************************/
    public int checkRowsRedWinner(Integer row){
            
            Integer redPiecesRow = 0;
            Integer columnNum = 0;
            
        while(columnNum < 9) {
            if (board[row][columnNum].getValue() == Connect4Square.RED){
                redPiecesRow++;
                if(redPiecesRow >= 4){
                    return Connect4Square.RED;
                }
            } else {
                redPiecesRow = 0;
            }
            columnNum += 1;
        }
        return Connect4Square.EMPTY;
    } // end of checkRowsRedWinner()
    
    public int checkRowsGreenWinner(Integer row){
            
            Integer greenPiecesRow = 0;
            Integer columnNum = 0;
            
        while(columnNum < 9) {
            if (board[row][columnNum].getValue() == Connect4Square.GREEN){
                greenPiecesRow++;
                if(greenPiecesRow >= 4){
                    return Connect4Square.GREEN;
                }
            } else {
                greenPiecesRow = 0;
            }
            columnNum += 1;
        }
        return Connect4Square.EMPTY;
    } // end of checkRowsRedWinner()
    
    public int checkColumnRedWinner(int columnNum) {
        
            Integer redPiecesRow = 0;
            Integer rowNum = 0;
            
        while (rowNum < 8) {
            if (board[rowNum][columnNum].getValue() == Connect4Square.RED){
                redPiecesRow++;
                if(redPiecesRow >= 4) {
                    return Connect4Square.RED;
                }
            } else {
                redPiecesRow = 0;
            }
            rowNum++;
        }
        return Connect4Square.EMPTY;
    } // end checkColumnForRedWin()
	
    public int checkColumnGreenWinner(int columnNum) {
            
            Integer greenPiecesRow = 0;
            Integer rowNum = 0;
            
        while (rowNum < 8) {
            if (board[rowNum][columnNum].getValue() == Connect4Square.GREEN){
                greenPiecesRow++;
                if(greenPiecesRow >= 4) {
                    return Connect4Square.GREEN;
                }
            } else {
                greenPiecesRow = 0;
            }
            rowNum++;
        }
        return Connect4Square.EMPTY;
    } // end checkColumnForGreenWin()	
    
    public int checkDownToRightDiagonalForRedWin(int rowNum, int columnNum) {
            
            Integer redPiecesRow = 0;
           
        while(rowNum < 8 && columnNum < 9) {
           if (board[rowNum][columnNum].getValue() == Connect4Square.RED) {
                redPiecesRow++;
                if (redPiecesRow >= 4)
                    return Connect4Square.RED;
            } else {
                redPiecesRow = 0;
            }
            rowNum += 1;
            columnNum +=1;
        }
       return Connect4Square.EMPTY;
    } // end checkDownToRightDiagonalForRedWin()
	
    
    public int checkDownToRightDiagonalForGreenWin(int rowNum, int columnNum) {
            
            Integer greenInRow = 0;
            
        while (rowNum < 8 && columnNum < 9) {
            if (board[rowNum][columnNum].getValue() == 2){
                greenInRow++;
                if(greenInRow >= 4)
                    return Connect4Square.GREEN;
            } else {
                greenInRow = 0;
            }
            rowNum++;
            columnNum++;
        }
        return Connect4Square.EMPTY;
    } // end checkDownToRightDiagonalForGreenWin()
	
        
    
    public int checkDownToLeftDiagonalForRedWin(int rowNum, int columnNum) {
            
            Integer redInRow = 0;
         
        while(rowNum < 8 && columnNum >= 0) {
            if (board[rowNum][columnNum].getValue() == 1){
                redInRow++;
                if(redInRow >= 4)
                    return Connect4Square.RED;
            } else {
                redInRow = 0;
            }
            rowNum++;
            columnNum--;
        }
        
        return Connect4Square.EMPTY;
    } // end checkDownToLeftDiagonalForRedWin()
	
    
    public int checkDownToLeftDiagonalForGreenWin(int rowNum, int columnNum) {
        
            Integer greenInRow = 0;
        
        while (rowNum < 8 && columnNum >= 0){
            if (board[rowNum][columnNum].getValue() == 2){
                greenInRow++;
                if(greenInRow >= 4)
                    return Connect4Square.GREEN;
            } else {
                greenInRow = 0;
            }
            rowNum++;
            columnNum--;
        }
        return Connect4Square.EMPTY;
    } // end checkDownToLeftDiagonalForGreenWin()
    
    /************************************************************************/
    
    public int initializeBoard(String input) {
        int returnValue = 0;    
        String[] inputLine = input.split("\n");
        String firstMoveColor = inputLine[0].substring(0, inputLine[0].indexOf(" "));
        if (firstMoveColor.equals("GREEN")) 
            returnValue = Connect4Square.GREEN;
        else if (firstMoveColor.equals("RED"))
            returnValue = Connect4Square.RED;
        
        for (int i = 1; i < inputLine.length; i++) {
            int r = i-1;
            String[] pieceColor = inputLine[i].split(",");
            for (int c = 0; c < pieceColor.length; c++) {
                if (pieceColor[c].trim().equals("0"))
                    board[r][c].setValue(Connect4Square.EMPTY);
                else if (pieceColor[c].trim().equals("1"))
                    board[r][c].setValue(Connect4Square.RED);
                else if (pieceColor[c].trim().equals("2"))
                    board[r][c].setValue(Connect4Square.GREEN);
            }
        }
        selectedRow = selectedColumn = -1;
        return returnValue;
    } // end of initializeBoard()
    
    
    public void drawBoard(Graphics g) {
        g.setColor(Color.lightGray);
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 9; c++) {
                g.drawRect(c*50 + 130, r*50 + 30, 50, 50);
            }
        }
        
        g.setColor(Color.black);
        g.drawRect(130, 30, 450, 400);
        g.drawRect(129, 29, 452, 402);

        g.setFont(new Font("Helvetica", Font.BOLD, 18));
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 9; c++) {
                switch (board[r][c].getValue()) {
                    case Connect4Square.EMPTY: g.setColor(Color.WHITE); break;
                    case Connect4Square.RED:   g.setColor(Color.RED);   break;
                    case Connect4Square.GREEN: g.setColor(Color.GREEN); break;
                } // end if
                g.fillOval(c*50 + 131, r*50 + 31, 48, 48);
                if (selectedRow == r && selectedColumn == c) {
                    g.setColor(Color.red.darker());
                    g.drawRect(c*50 + 130, r*50 + 30, 50, 50);
                    g.drawRect(c*50 + 131, r*50 + 31, 48, 48);
                }
            }
        }

    } // end of drawBoard()
    
} // end of class Connect4Board