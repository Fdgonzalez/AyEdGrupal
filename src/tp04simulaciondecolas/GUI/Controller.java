package tp04simulaciondecolas.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller extends Application {

    private Stage primaryStage;
    private BorderPane mainLayaut;


   public void start(){
       launch();
   }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        primaryStage.setTitle("Cashier Simulation");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();
    }
}