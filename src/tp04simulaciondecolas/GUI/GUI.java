package tp04simulaciondecolas.GUI;


import javafx.application.Application;

import javafx.stage.Stage;
import tp04simulaciondecolas.IO;
import tp04simulaciondecolas.Supermarket;

public class GUI extends Application {
    private static String[] arguments;
    private static IO io;
    private static Controller controller;
    @Override
    public void start(Stage stage) {
        controller.init(stage);
        stage.setTitle("Simulacion de colas");
        stage.getScene().getStylesheets().add("tp04simulaciondecolas/GUI/barchart.css");
        stage.show();
    }
    public static void showSimulation(Supermarket supermarket,int totalIterations, int iterationsPerCycle, int ms, IO io){
        controller = new Controller(supermarket,totalIterations,iterationsPerCycle,ms,io);
        launch();
    }
}
