/*
Ben Schroth
Dr. Weber
CSC 220
10/2/2018
PA2
*/

package utility_customer_hierarchy;

public abstract class UtilityCustomer{
    
    protected Integer accountNumber;
    protected String accountType;
    protected Double consumption;
    
    public UtilityCustomer(){}
    
    public String getType(){
        return accountType;
    }
    
    public Integer getNumber(){
        return accountNumber;
    }
    
    public abstract double calculateBill();
    
} // end of UtilityCustomer