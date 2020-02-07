//Client Main Method for program

package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
    
    //  This starts the View part of this MVC application.
    //  The Model is started in ClientController.
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("ClientView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    //  This launches the entire Application.
    public static void main(String[] args) {
        launch(args);
    }
    
}
