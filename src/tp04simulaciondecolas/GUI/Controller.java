package tp04simulaciondecolas.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tp04simulaciondecolas.Supermarket;

public class Controller extends Application {

    private Stage primaryStage;
    private BorderPane mainLayaut;
    private Supermarket supermarket;
    private int simulationLength;
    private int n;
    private int ms;
    public Controller(Supermarket supermarket, int simulationLength, int n, int ms){
        this.supermarket = supermarket;
        this.simulationLength = simulationLength;
        this.n = n;
        this.ms = ms;
    }

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