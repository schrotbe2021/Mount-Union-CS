/*
Ben Schroth
PA3 CSC 220
Dr. Weber
10/23/2018
*/

package phone_list_model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Model
{
    
    public static ObservableList<String> readPhoneList(){
        
        List<String> list = new ArrayList<String>();
        ObservableList<String> contacts = FXCollections.observableList(list);
        
        try(Scanner s = new Scanner(new File("phone_list.txt"))){
            while(s.hasNextLine()){
                
                String name = s.nextLine();
                
                contacts.add(name);
            
            }
        } catch(FileNotFoundException fe){
            System.out.println("phone_list.txt not found");
        }
        
        return contacts;
    }
}
