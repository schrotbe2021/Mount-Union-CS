/*
Ben Schroth
CSC 220
Dr. Weber
10/2/2018
PA2
*/

package client;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import utility_customer_hierarchy.ElectricCustomer;
import utility_customer_hierarchy.GasCustomer;
import utility_customer_hierarchy.UtilityCustomer;

public class ClientController implements Initializable {

    private ArrayList<UtilityCustomer> customerList;
   
    class CustomerCompare implements Comparator<UtilityCustomer>{
        
        @Override
        public int compare(UtilityCustomer uc1, UtilityCustomer uc2)
        {
            return Double.compare(uc1.calculateBill(), uc2.calculateBill());
        } // end of compare UtilityCustomers
    } // end of comparator
    
    @FXML
    private void runTestButtonAction(ActionEvent event) {
        
        customerList.sort(new CustomerCompare());
            
        for (UtilityCustomer c : customerList)
        { 
            DecimalFormat d = new DecimalFormat("'$'0.00");
            System.out.println(c.getType() + " customer owes " + d.format(c.calculateBill()) + ".");
        } // end of printing customers to console
    
    } // end of runTestButtonAction

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        customerList = new ArrayList<>();
       
        
        String myLine = "";
        try (Scanner s = new Scanner(new File("customers.txt")))
        {
            
            while(s.hasNext()){
                
                myLine = s.nextLine();
                Scanner line = new Scanner(myLine);
                
                Integer accountNumber = line.nextInt();
                String type = line.next();
                Double consumption = line.nextDouble();
                
                if(type.equals("gas"))
                {
                    customerList.add(new GasCustomer(accountNumber, type, consumption));
                } 
                else if (type.equals("electric"))
                {
                    customerList.add(new ElectricCustomer(accountNumber, type, consumption));
                } // end of if statments to check Gas or Electric
                
            } // end of while loop
            
        } // end of try (scanner object)
        
        catch (IOException ioe)
        {
                System.out.println("Houston we have a problem.");
        } // end of ioe exception
        catch (InputMismatchException ime){
            System.out.println("still dont work cuzzo" + myLine);
        } // end of ime exception
        
    } // end of initialize
    
} // end of client controller
