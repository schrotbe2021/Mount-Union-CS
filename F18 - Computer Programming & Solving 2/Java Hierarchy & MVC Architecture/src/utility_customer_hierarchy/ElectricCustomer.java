/*
 Ben Schroth - PA1
Class for Electric Customer
Dr. Weber
 */
package utility_customer_hierarchy;

/**
 *
 * @author schrotbe2021
 */
public class ElectricCustomer extends UtilityCustomer {

    private Integer kWattHoursUsed = 10;
    private static Double pricePerKwHour = 2.5;
    private static Integer deliveryFee = 30;
    private Integer ID;
    
    public ElectricCustomer(Integer kW, Integer iD){
        super(iD);
        kWattHoursUsed = kW;
    }
    
    
    public void setKWattHoursUsed(Integer kW){
        kWattHoursUsed = kW;
    }
    
    public Integer getKWattHoursUsed(){
        return kWattHoursUsed;
    }
    
    @Override
    public Double calculateBill() {
        Double bill = (kWattHoursUsed * pricePerKwHour) + deliveryFee;
        return bill;
    }
    
    public String toString(){ return super.toString(); }
    
}
