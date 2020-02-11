/*
    This class will be like the RaceCar class in lab2. Simulator class will build the process class.
 */
package pa2_package;

import java.util.ArrayList;

public class Process {
    private String processName; // Name of process
    private Integer creationTime; // Time it goes into newList
    private ArrayList<ProcessString> traceTape; // CPU and I/O bursts
    
    private Integer timeNew, timeReady, timeRunning, 
                timeWaiting, timeTerminated, firstResponseTime, dispatchLatency,
                timeToTerminate;
    private Double averageWaitTime;
    /*
        Data members:
            timeNew = total time process is in new
            timeReady = total time process is in ready
            timeRunning = total time process is in running
            timeWaiting = total time process is in waiting
            timeTerminated = total time process is in terminated
            dispatchLatency = total time process spent switching from ready to running
            timeToTerminate = how long the process took to terminate
            averageWaitTime = calulation of average wait time for the procees
    */
    public Process(String n, Integer t, ArrayList<ProcessString> tape)
    {
        processName = n;
        creationTime = t;
        traceTape = tape;
        timeNew = 0;
        timeReady = 0;
        timeRunning = 0; 
        timeWaiting = 0;
        timeTerminated = 0;
        dispatchLatency = 0;
        timeToTerminate = 0;
        averageWaitTime = 0.0;
    }

    //Methods for incrementing time in each list.
    public void incrementNew() { timeNew++; }
    public void incrementReady() { timeReady++; }
    public void incrementRunning() { timeRunning++; }
    public void incrementWaiting() { timeWaiting++; }
    public void incrementTerminated() { timeTerminated++; }
    public void incrementLatency() { dispatchLatency++; }
    
    //Methods to retrieve times, name, and trace tape.
    public Integer getRunningTime() { return timeRunning; }
    public Integer getWaitTime() { return timeWaiting; }
    public Integer getLatency() { return dispatchLatency; }
    public Integer getTimeToTerminate() { return timeToTerminate; }
    public Integer getFirstResponse() { return firstResponseTime; }
    public String getName() { return processName; }
    public Integer getCreationTime() { return creationTime; }
    public ArrayList<ProcessString> getTraceTape() { return traceTape; }
    public Double getAverageWait() { return averageWaitTime; }
    
    // Sets the timeToterminate and firstResponse variables.
    public void setTimeToTerminate(Integer t) { timeToTerminate = t; }
    public void setFirstResponse(Integer f) { firstResponseTime = f; }
    public void setAverageWait(Double w) { averageWaitTime = w; }
    
    // Returns string of the trace tape.
    public String traceToString() {
        String result = "";
        for ( ProcessString p : traceTape )
        {
            result += p.toString();
        }
        return result;
    }
    
    @Override
    public String toString()
    {
        return processName + " :: " + creationTime + " :: " + traceToString()
            + " \n\t" + timeNew + " " + timeReady + " " + timeRunning + " " 
                + timeWaiting + " " + timeTerminated + "    " + dispatchLatency; 
        
    }
}
