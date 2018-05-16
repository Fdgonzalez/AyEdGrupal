package tp04simulaciondecolas.GUI;


import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tp04simulaciondecolas.Cashier;
import tp04simulaciondecolas.IO;
import tp04simulaciondecolas.Supermarket;
import tp04simulaciondecolas.exceptions.InvalidDataInFile;

import java.io.IOException;


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
