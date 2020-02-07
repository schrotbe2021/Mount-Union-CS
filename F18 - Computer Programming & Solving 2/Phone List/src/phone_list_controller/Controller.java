/*
Ben Schroth
PA3 CSC 220
Dr. Weber
10/23/2018
*/

package phone_list_controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import phone_list_model.Model;

public class Controller implements Initializable 
{
    @FXML
    private ListView listView;
    @FXML
    private Label label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        listView.setItems(Model.readPhoneList());
        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());
    } // initialize the listView from the model
    
    @FXML
    public void addCell(ActionEvent event)
    {
        listView.getItems().add("(Name) ; (Number)");
    } // Add a cell to the listView
    
    @FXML
    public void deleteCell(ActionEvent event)
    {
        try
        {
            int x = listView.getSelectionModel().getSelectedIndex();
            listView.getItems().remove(x, x+1);
        } catch(Exception e) {
                System.out.println("You need to add account.");
        }
    } // delete cell in listView
    
    @FXML
    public void save(){    
        try(PrintWriter p = new PrintWriter(new File("phone_list.txt"))){
            
            for(Object o : listView.getItems()){
                p.println(o.toString());
            }
        } catch (FileNotFoundException fe){
            System.out.println("File not found!");
        }
    } // save the file to the phone_list.txt
}
