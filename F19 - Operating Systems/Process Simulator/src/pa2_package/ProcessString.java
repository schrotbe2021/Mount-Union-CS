/*
    The arraylist inside the arraylist class.
 */
package pa2_package;


public class ProcessString {
    
    public String behavior;
    public Integer runTime;
    
    public ProcessString(String b, Integer t)
    {
        behavior = b;
        runTime = t;
    } 
    
    public Integer timePassed() {
        runTime--; 
        return runTime;
    }
    
    public ProcessString getTraceTape() { return this; }
    
    public void setType(String t)
    {
        t = behavior;
    }
    
    public Integer getStateBurst() { return runTime; }
    
    public void setRunTime(Integer r)
    {
        r = runTime;
    }
    
    @Override
    public String toString()
    {
        return "" + behavior + " " + runTime + " ";
    }
}
