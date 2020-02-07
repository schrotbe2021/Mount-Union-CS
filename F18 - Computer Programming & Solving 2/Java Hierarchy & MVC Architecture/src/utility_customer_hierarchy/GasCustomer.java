/*
    Ben Schroth
    PA1
    Dr. Ken Weber
*/
package utility_customer_hierarchy;

import java.util.Random;


public class GasCustomer extends UtilityCustomer {
    
    
    private Integer cubicMetersUsed = 10;
    private static Double gasPerCubicMeter = 3.0;
    private Integer ID;
    
    // Constructor for gas that uses gas used and their ID.
    public GasCustomer(Integer cM, Integer iD){
        super(iD);
        cubicMetersUsed = cM;
    }
    
    // Sets cubic meters used.
    public void setCubicMetersUsed(Integer g){
        cubicMetersUsed = g;
    }
    
    // retrieves cubic meters used.
    public Integer getCubicMetersUsed(){
        return cubicMetersUsed;
    }
    
    // calculate bill
    @Override
    public Double calculateBill() {
       Double bill = cubicMetersUsed * gasPerCubicMeter;
       return bill;
    }
    
    public String toString(){ return super.toString(); }
   
}
