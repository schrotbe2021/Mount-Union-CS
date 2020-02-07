/*
Ben Schroth 
Client controller that initializes Utility Customer objects and calculates
their bill.
*/

package client;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import utility_customer_hierarchy.ElectricCustomer;
import utility_customer_hierarchy.GasCustomer;
import utility_customer_hierarchy.UtilityCustomer;

public class ClientController implements Initializable {

    
    private Integer gasCustomer = 5;
    private Integer electricCustomer = 5;
    
    private ArrayList<UtilityCustomer> customerList;
    
    //Prints the bill and ID number in the console.
    @FXML
    private void runTestButtonAction(ActionEvent event) {
        for (UtilityCustomer c : customerList){
            System.out.println(c.toString() + "\nTotal Bill: $" + c.calculateBill());
        }
    }

    // Initialized the Gas and Electric Customers.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customerList = new ArrayList<>();
        
        Random rand = new Random();
        for (int i = 0; i < gasCustomer; i++){
            customerList.add(new GasCustomer(rand.nextInt(20), i));
        }
        for (int i = 0; i < gasCustomer; i++){
            customerList.add(new ElectricCustomer(rand.nextInt(20), (i) + 5));
        }
    }

}
