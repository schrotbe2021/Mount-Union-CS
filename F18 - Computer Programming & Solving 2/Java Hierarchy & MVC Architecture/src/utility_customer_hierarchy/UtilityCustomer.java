/**   UtilityCustomer
*     Schroth, Ben
*     CSC220 Dr. Weber
*     Represents a generic utility customer account
*/

package utility_customer_hierarchy;


import java.util.Random;



public abstract class UtilityCustomer {
   
    private Integer accountNumber = 0;
    private static Integer nextAccountNumber = 0;

    public abstract Double calculateBill();
    
    // Constructor for UtilityCustomer with their ID.
    public UtilityCustomer(Integer iD){
        accountNumber = iD;
    }
    
    //mutator for account
    public Integer setAccountNum(Integer aN){
        this.accountNumber = aN;
        return aN;
    }
    
    //accessor for account
    public Integer getAccountNumber(){
        
        return accountNumber;
    }
    
    // toString
    @Override
    public String toString(){ return "Account Number ==> " + accountNumber; }
    
}