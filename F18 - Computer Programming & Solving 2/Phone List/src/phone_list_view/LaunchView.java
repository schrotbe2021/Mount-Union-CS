/*
Ben Schroth
PA3 CSC 220
Dr. Weber
10/23/2018
*/

package phone_list_view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author weberk
 */
public class LaunchView extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
       
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("view.css").toString());
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
