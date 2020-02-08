/*
Ben Schroth
Dr. Weber
CSC 220
10/2/2018
PA2
*/
package utility_customer_hierarchy;

public class ElectricCustomer extends UtilityCustomer {
    
    private static Double priceForElectric = 2.5;
    
    public ElectricCustomer(Integer aN, String aT, Double c){
        super();
        accountNumber = aN;
        accountType = aT;
        consumption = c;
    } // end of constructor
    
    @Override
    public double calculateBill(){
        double bill = consumption * priceForElectric;
        return bill;
    }
    
}
