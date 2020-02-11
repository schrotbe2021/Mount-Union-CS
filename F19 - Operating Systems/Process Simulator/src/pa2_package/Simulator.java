/*
    This class parses all the information. Acts as a controller class and then called
    in JFrame to be used with input data.
 */
package pa2_package;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class Simulator implements Runnable {
    
    /*
        Variables:
                inputArea = input for data
                outputArea = output for processes
                ArrayList<Process> = Lists for moving processes
                timeQuantum = time for running in RR algorithm
                clock = time program has ran
                running = boolean for thread 
                tickValue = burst time for process
                throughput = variable for calculating final throughput
    */
    private final javax.swing.JTextArea inputArea;
    private final javax.swing.JTextArea outputArea;
    
    private final ArrayList<Process> newList = new ArrayList();
    private final ArrayList<Process> readyList = new ArrayList();
    private final ArrayList<Process> runningList = new ArrayList();
    private final ArrayList<Process> waitingList = new ArrayList();
    private final ArrayList<Process> terminatedList = new ArrayList();    
    private final ArrayList<Process> processList = new ArrayList();
    
    private Integer timeQuantum, clock;
    private Boolean running;
    private Thread thread;
    private Integer tickValue;
    private Double throughput;

    // Decimal format for output
    DecimalFormat df = new DecimalFormat("#.##");
    
    /*
        Constructor. Takes in two text areas for I/O. Initializes the clock to zero
        running to false.
    */
    public Simulator(javax.swing.JTextArea input, javax.swing.JTextArea output)
    {
        this.inputArea = input;
        this.outputArea = output;
        clock = -1;
        running = false;
    }
    /*
        Checks validity of the input.
        Checks for:
            If input is divisible by three + 1.
            If time quantum of input is an Integer.
            Makes sure no spaces are in the first line.
            Checks if trace tape starts with CPU instruction.
            Catches NumberFormatExceptions if input is not Integer.
    */
    public void validityCheck()
    {
        outputArea.append("\t\tread button pressed\n");
        
        try {
            String data = inputArea.getText();
            String[] dataArray = data.split("\n");
        
            if (dataArray.length % 3 != 1)
            {
                System.out.println("Number of lines does not meet requirement for parsing.");
            }
        
            Integer.parseInt(dataArray[0]);
       
        
            for (int i = 1; i < dataArray.length; i += 3)
            {
                if (dataArray[i].contains(" "))
                {
                    System.out.println("First line of data must be a string with no spaces.");
                }
 
                Integer.parseInt(dataArray[i+1] ); 
            
                if (dataArray[i+2].startsWith("C") == false)
                {
                    System.out.println("String of data must start with CPU instruction");
                }
            }
            
        } 
        catch (NumberFormatException nfe) { outputArea.append("First or second line per "
                    + "set of data must be an integer.\n"); }
        catch (Exception e ){ outputArea.append("Something went wrong!\n"); }
        
        outputArea.append("data is valid\n");
    }
    /*
        Fills the array and hecks each process for the sum of the first CPU burst 
        and IO burst for the first response calculation.
    */
    public void fillArray()
    {
            String processName = "";
            Integer creationTime = 0;
            String processType = "";
            Integer ticks = -1;
            //Local Variables
            
        String data = inputArea.getText();
        String[] dataArray = data.split("\n");
        //Splitting data into each part.

        timeQuantum = Integer.parseInt(dataArray[0]);
        // Time quantum is first line before loop.
        
        for (int i = 1; i < dataArray.length; i += 3)
        {
            processName = dataArray[i]; 
            creationTime = Integer.parseInt(dataArray[i+1]);
            
            String[] traceTape = dataArray[i+2].split(" ");
           
            ArrayList<ProcessString> processStringList = new ArrayList<>();
            for (int j = 0; j < traceTape.length; j += 2)
            {
                
                String behavior = traceTape[j];
                Integer time = Integer.parseInt(traceTape[j + 1]);
                processStringList.add(new ProcessString(behavior, time));
            }
            
            Process tmpProcess = new Process(processName, creationTime, processStringList);
            processList.add(tmpProcess);
            System.out.println("process added");
        } // Iterates over the data. Skipping every three lines.
        
        outputArea.append("simulator is ready\n");
        outputArea.append("==================================================\n");
        
        // Find the burst cycle of the first response in each process.
        for (Process p : processList)
        {
            ArrayList<ProcessString> tape = p.getTraceTape();
            ProcessString cpuBurst = tape.get(0);
            ProcessString ioBurst = tape.get(1);
            //Find the first and second burst times
            
            Integer cpuTime = cpuBurst.getStateBurst();
            Integer ioTime = ioBurst.getStateBurst();
            
            Integer firstResponse = cpuTime + ioTime;
            p.setFirstResponse(firstResponse);
        }
    }
    /*
        Displays current statistics
            Clock, Time Quantum, All Processes, newLsit, readyList
    */
    public void statsButton()
    {
        outputArea.append("\t\tstats button pressed\n\n");
        
        Process[] tmpArray = new Process[processList.size()];
        processList.toArray(tmpArray);
                
        outputArea.append("clock: " + clock + "\n");
        outputArea.append("timeQuantum: " + timeQuantum + "\n");
        outputArea.append("allProcessesList.size(): " + processList.size() + "\n");
        
        //Prints each process
        for (int i = 0; i < tmpArray.length; i++)
        {
            outputArea.append("  process: ( " + i + " )  ");
            outputArea.append(tmpArray[i].toString() + "\n");
        }
        
        //Prints the processes in newList
        outputArea.append("newList.size(): " + newList.size() + "\n");
        for (Process p : newList)
        {
            outputArea.append("   " + p.toString() + "\n");
        }
        
        //Prints the processes in readyList
        outputArea.append("readyList.size(): " + readyList.size() + "\n");
        for (Process p : readyList)
        {
            outputArea.append("     " + p.toString() + "\n");
        }
        
        //Prints the processes in runningList
        outputArea.append("runningList.size(): " + runningList.size() + "\n");
        for (Process p : runningList)
        {
            outputArea.append("\t" + p.toString() + "\n\n");
        }
        
        //Prints the calculations.
        cpuUtilization();
        outputArea.append("Throughput: " + throughput + " per 30 seconds.\n");
        waitingTime();
        firstResponse();
        turnaroundTime();
    }
    
    /*
        Each tick represents +1 to clock. Displays some statistics when clicked.
    */
    public void tickButton()
    {
        outputArea.append("\t\ttick button pressed.\n");
        
        clock += 1;
        
        // Methods that updates the lists.
        newList(); 
        runningList();
        readyList();
        waitingList();
        
        
        outputArea.append("clock: " + clock + "\n");
        outputArea.append("time quantum: " + timeQuantum + "\n");
        
        //newList 
        outputArea.append("newList.size(): " + newList.size() + "\n");
            for (Process p : newList)
            {
                outputArea.append("     " + p.toString() + "\n");
                p.incrementNew();;
                
            }
        
        //readyList
        outputArea.append("readyList.size(): " + readyList.size() + "\n");
            for (Process p : readyList)
            {
                outputArea.append("     " + p.toString() + "\n");
                p.incrementReady();
            }
        //runningList
        outputArea.append("runningList.size(): " + runningList.size() + "\t" + timeQuantum + "\n");
            for (Process p : runningList)
            {
                outputArea.append("\t" + p.toString() + "\n");
                p.incrementRunning();
            }
        //waitingList
        outputArea.append("waitingList.size(): " + waitingList.size() + "\n");
            for ( Process p : waitingList )
            {
                outputArea.append("\t" + p.toString() + "\n");
                p.incrementWaiting();
            }
        //terminatedList
        outputArea.append("terminatedList.size(): " + terminatedList.size() + "\n");
            for ( Process p : terminatedList )
            {
                outputArea.append("\t" + p.toString() + "\n");
                p.incrementTerminated();
            }   
            
          //Code that calculates throughput at time 30
          if (clock == 30)
          {
              if (terminatedList.isEmpty())
              {
                  throughput = 0.0;
              } else {
                  throughput = (double)terminatedList.size() / 30;
                  System.out.println(throughput);
              }
          }
        
    }
    
    public void newList()
    {
        for (Process p : processList)
        {
        
            if (p.getCreationTime() == clock)
            {
                newList.add(p);
            }
        }
    } // Adds data to newList if creation time is equal to clock.
    
    public void readyList()
    {
        Iterator<Process> iter = newList.iterator();
        
        while (iter.hasNext())
        {
            Process tmpProcess = iter.next();
            
            if (tmpProcess.getCreationTime() < clock && readyList.size() < 3)
            {
                iter.remove();
                readyList.add(tmpProcess);
            }
        }
    } // Iterator class is used to iterate over newList and if process is greater
      // than clock and readyList.size() is less than 3 then it is added to readyList
    
    public void runningList()
    {
        // Manipulates process if runningList is not empty
        if ( !runningList.isEmpty())
        {
            Process topOfRunning = runningList.get(0);
            
            ArrayList<ProcessString> statesArrayList = topOfRunning.getTraceTape();
            ProcessString[] states = new ProcessString[statesArrayList.size()];
            statesArrayList.toArray(states);
            Integer stateBurst = states[0].getStateBurst();
                
            // If statements that checks where to move process.
                if (timeQuantum > 0 && stateBurst != 0)
                { //Decrements time in process in RR algorithm
                    states[0].timePassed();
                    timeQuantum--;
                    
                } else if ( timeQuantum == 0 && stateBurst != 0)
                { // Moves to ready because process isn't done with it's burst.
                    readyList.add(topOfRunning);
                    runningList.remove(topOfRunning);
                    timeQuantum = 4;
                } else if (stateBurst == 0 && statesArrayList.size() == 1)
                { // Moves to terminated because it is last in the list and burst is done.
                    runningList.remove(topOfRunning);
                    terminatedList.add(topOfRunning);
                    statesArrayList.remove(0);
                    timeQuantum = 4;
                } else if ( stateBurst == 0 )
                { //Adds to waiting list for I/O
                    statesArrayList.remove(0);
                    waitingList.add(topOfRunning);
                    runningList.remove(topOfRunning);
                    timeQuantum = 4;
                }
            
            
        } else if ( !readyList.isEmpty() ) // Moves process to running if one is available in running.
        {
            Process tmpProcess = readyList.get(0);
            runningList.add(tmpProcess);
            readyList.remove(0);
            tmpProcess.incrementLatency();
        }
       
    }
    
    // Decrements processes in waitingList.
    public void waitingList()
    {
        if (!waitingList.isEmpty())
        {
            //For each process in waiting list the process in the first 
            //spot of the array is decremented
            for (int i = 0; i < waitingList.size(); i ++)
            {
                Process tmp = waitingList.get(i);
                ArrayList<ProcessString> statesArrayList = waitingList.get(i).getTraceTape();
                ProcessString[] states = new ProcessString[statesArrayList.size()];
                statesArrayList.toArray(states);
                
                if ( states[0].getStateBurst() != 0 )
                {
                    states[0].timePassed();
                }
                else if (states[0].getStateBurst() == 0)
                {
                    readyList.add(tmp);
                    waitingList.remove(tmp);
                    statesArrayList.remove(0);
                    i--; //Fixes Concurrent error and resets i for next element in case of a move.
                }
            }
        }
    }
    
    // Claculates CPU Utilization
    public void cpuUtilization()
    {
        Double runningTime = 0.0;
        Double result = 0.0;
        for (Process p : processList)
        {
            runningTime += p.getRunningTime();
        }
        
       result = runningTime / clock; 
       outputArea.append("CPU Utilization: " + df.format(result) + "\n");
    }
    
    //Calculates waiting time.
    public void waitingTime()
    {
        
        String averageWaitTime = "";
        Double totalWaitTime = 0.0;
        outputArea.append("Average wait time: ");
       
        for ( Process p : processList ) 
        {
            totalWaitTime += p.getWaitTime();
            outputArea.append(" [" + p.getName() + " " + p.getWaitTime() + "]");
        }
        
        averageWaitTime = df.format((double)totalWaitTime / processList.size());
        outputArea.append(" Average: " + averageWaitTime + "\n");
    }
    
    // Claculates firstResponse. Goes through each process if the process first response
    // is greater than the clock it sets the dispatch latency at that time and adds
    // them to find total time.
    public void firstResponse()
    {
        outputArea.append("First Response: ");
        Integer dispatchLatency = 0;
        for (Process p : processList)
        {
            if (clock > p.getFirstResponse())
            {
                dispatchLatency = p.getLatency();
            }
            Integer firstResponse = p.getFirstResponse() + dispatchLatency;
            if (clock > firstResponse)
            {
                outputArea.append("[" + p.getName() + " " + firstResponse + "] ");
            }
        }
        outputArea.append("\n");
    }
    
    // Finds the time the process finished running through all bursts.
    public void turnaroundTime()
    {
         outputArea.append("Turnaround Time: ");
         for (Process p : processList)
         {
             if(p.getTraceTape().isEmpty() && p.getTimeToTerminate() == 0)
             {
                 p.setTimeToTerminate(clock);
             }
             if(p.getTraceTape().isEmpty() && p.getTimeToTerminate() != 0)
             {
                 outputArea.append("[" + p.getName() + " " + p.getTimeToTerminate() + "] ");
             }
         }
         outputArea.append("\n");
    }
    
    public void runPauseButton(javax.swing.JSlider slider)
    {
        if(running == true)
        {
            outputArea.append("\t\tpaused\n");
            running = false;
        } else {
            outputArea.append("\t\trunning\n");
            running = true;
        }
        
        tickValue = slider.getValue();
        System.out.println("Waiting for " + tickValue + " ms.");
        
        thread = new Thread(this);
        thread.start();        
    } // Starts a thread that iterates over tickValue in slider.
  
    @Override
    public void run() {
        while (true){
            if (running == true) 
            {
                tickButton();
            }
            
            try { Thread.sleep(tickValue); } catch (Exception e) {}
        } 
    } // Method inherited from runnable interface. Starts when thread.start() is ran in runPauseButton()
    
} // End of simulator
