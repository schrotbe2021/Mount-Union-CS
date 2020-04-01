
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/*
    Ben Schroth
    CS320 - Algorithms & Data Structures
    Program #2
    Professor Cindric

    Description:
        Automated maze solver using stack data structure.

    TODO:
        Solve Maze
        Return to start
        Follow back to end
 */

public class RandomMazeSolver extends MazeSolver implements Runnable {

        private Graphics    myG;       // so that this solver can draw itself in the MUPanel!
        private boolean[][] visited;   // where have I been so far?
        private boolean     returningHome;
        private boolean     workerActive;

        public RandomMazeSolver ( Maze m, Graphics g ) {
            super(m);
            myG = g;
            returningHome = false;
            workerActive = false;
        } // end of constructor

    public void solveMaze() {
	
	    int totCells = theMaze.getRows()*theMaze.getCols();
	
        //  1. initialize row and col to position (0,0) -- our mazes always start in upper-left corner
            row = 0;
            col = 0;
       
        //  2. instantiate a new StackOfObjs with an initial capacity that is twice the total number
        //     of squares in theMaze
            StackOfObjs stack = new StackOfObjs(2 * totCells);

		visited = new boolean[theMaze.getRows()][theMaze.getCols()];
		visited[0][0] = true;  // [0][0] is starting square in maze

        int visitedCells = 1;
               
        //  3. while (the number of visited cells is fewer than the total number of cells in the maze, AND the result of calling the haveNotReachedEndingSquare() method is true), do the following: 
        while(visitedCells < totCells && haveNotReachedEndingSquare()) {
            //  3a. use an ArrayList of Strings to build a list of all unvisited neighbors of the current maze square, which 
            //      is position (row, col).  IMPORTANT:  this list should be built by testing the NORTH
            //      neighbor, then the WEST neighbor, then the SOUTH neighbor and finally the EAST neighbor,
            //      in that order!  Hint:  the first neighbor processing for the list is given to you here; use the same 
			//      style for the other neighbors:
			
            ArrayList<String> unvisitedList = new ArrayList<String>();
			
            if (weCanMoveToTheNorth() && !visited[row-1][col])
                unvisitedList.add("N");
            
            if (weCanMoveToTheSouth() && !visited[row+1][col])
                unvisitedList.add("S");
            
            if(weCanMoveToTheEast() && !visited[row][col+1])
                unvisitedList.add("E");
            
            if(weCanMoveToTheWest() && !visited[row][col-1])
                unvisitedList.add("W");	
			
          
            //  3b. if (there are any unvisited neighbors), then
            if(!unvisitedList.isEmpty()) {

                //  3b-1. push the current row and column numbers on the stack, in that order
                stack.push(row);
                stack.push(col);
                //  3b-2. The next cell should be the first one in the list of unvisited neighbors.
                //        Move to the next cell by changing either row or col, depending on the direction
                //        of the move (EAST means "col+1"; SOUTH means "row+1"; WEST means "col-1";
				//        NORTH means "row-1")
                Random randomSelect = new Random();
                Integer selection;
                selection = randomSelect.nextInt(unvisitedList.size());
                if (unvisitedList.get(selection).equals("N"))
                    row = row - 1;
                if(unvisitedList.get(selection).equals("S"))
                    row = row + 1;
                if(unvisitedList.get(selection).equals("E"))
                    col = col + 1;
                if(unvisitedList.get(selection).equals("W"))
                    col = col - 1;
                        

                //  3b-3. add one to the number of visited cells
                visitedCells++;

            } //  3b. end if
            else 
            {
            //  3c. else 

                //  3c-1. pop the stack twice, into col and then into row (be careful to do it in this order!)
                col = (Integer) stack.pop();
                row = (Integer) stack.pop();

            }//  3c. end else

            //  3d. mark the current cell as visited
            visited[row][col] = true;

            //  3e. call draw(myG);
            draw(myG);

            try {
                Thread.sleep(10);  // will sleep for 100 ms
            }
            catch (InterruptedException e) {}
            
            //  3f. if (we have NOT yet reached the ending square), then 
            if (haveNotReachedEndingSquare()) {
                //  3f-1. call erase(myG);
                    erase(myG);

            }//  3g. end if

        }//  4. end while
        
        returningHome = true;
        returnToStart(stack);
       
    } // end of solveMaze()
   
    public boolean haveNotReachedEndingSquare() {
        // return false if row == numRows - 1 and col == numCols - 1; return true otherwise
        if ((row == theMaze.getRows() - 1) && (col == theMaze.getCols() - 1))
            return false;
        else
            return true;
    } // end of haveNotReachedEndingSquare()
   
    public boolean weCanMoveToTheEast() {
        return !theMaze.getSquare(row, col).hasEWall() && !theMaze.getSquare(row, col).hasEBorder();
    }
   
    public boolean weCanMoveToTheWest() {
        return !theMaze.getSquare(row, col).hasWWall() && !theMaze.getSquare(row, col).hasWBorder();
    }
   
    public boolean weCanMoveToTheNorth() {
        return !theMaze.getSquare(row, col).hasNWall() && !theMaze.getSquare(row, col).hasNBorder();
    }
   
    public boolean weCanMoveToTheSouth() {
        return !theMaze.getSquare(row, col).hasSWall() && !theMaze.getSquare(row, col).hasSBorder();
    }

    public void draw( Graphics g ) {
        if (returningHome) {
            g.setColor(Color.WHITE);
        }
        else if (workerActive) {
            g.setColor(Color.GREEN);
        }
        else {
            g.setColor(Color.CYAN.darker());
        }

        MazeSquare theSq = theMaze.getSquare(row, col);

        //  fill a rectangle with upper left corner (theSq.getX()+1, theSq.getY()+1), with width
        //    and height both equal to theSq.getSize()-2
        g.fillRect(theSq.getX() + 1, theSq.getY() + 1, theSq.getSize() - 2, theSq.getSize() - 2);

    } // end of draw()

    public void erase( Graphics g ) {
        g.setColor(Color.BLACK);

        MazeSquare theSq = theMaze.getSquare(row, col);

        //  fill a rectangle that with upper left corner (theSq.getX()+1, theSq.getY()+1), with width
        //    and height both equal to theSq.getSize()-2
        g.fillRect(theSq.getX() + 1, theSq.getY() + 1, theSq.getSize() - 2, theSq.getSize() - 2);

        if (returningHome) {
            g.setColor(Color.WHITE);
        }
        else if (workerActive) {
            g.setColor(Color.GREEN);
        }
        else {
            g.setColor(Color.CYAN.darker());
        }

        //  fill a rectangle that with upper left corner (theSq.getX()+7, theSq.getY()+7), with width
        //    and height both equal to theSq.getSize()-14
        g.fillRect(theSq.getX() + 7, theSq.getY() + 7, theSq.getSize() - 14, theSq.getSize() - 14);
		
    } // end of erase()

    public void run() {
        solveMaze();
    } // end of run()

    public void returnToStart(StackOfObjs s) {
        while (! s.isEmpty() ) {
	
            // A. Pop the stack twice, first into an int variable named col and then into an int variable named row
            col = (Integer) s.pop();
            row = (Integer) s.pop();
            // B. call draw(myG);
            draw(myG);
        try {
            Thread.sleep(50);
        }
        catch (InterruptedException ex) {}
		
            // C. if (row is greater than zero or col is greater than zero)
            //        call erase(myG);
            if(row > 0 || col > 0) {
                erase(myG);
            }
        } // end while
    } // End of return to start
} // end of class NorthFirstMazeSolver
