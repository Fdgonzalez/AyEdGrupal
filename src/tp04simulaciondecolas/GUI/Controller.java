package tp04simulaciondecolas.GUI;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;
import tp04simulaciondecolas.Cashier;
import tp04simulaciondecolas.IO;
import tp04simulaciondecolas.Supermarket;

import java.io.IOException;

public class Controller {
    private final int totalIterations;
    private final int iterationsPerCycle;
    private final int ms;
    private int currentIteration;
    private Supermarket supermarket;
    private BarChart<Number,String> bc;
    private IO io;

    public Controller(Supermarket supermarket,int totalIterations, int iterationsPerCycle, int ms, IO io){
        this.supermarket = supermarket;
        this.totalIterations = totalIterations;
        this.iterationsPerCycle = iterationsPerCycle;
        this.ms = ms;
        this.io = io;
        currentIteration = 0;
    }
    public void init(Stage stage){
         final NumberAxis xAxis = new NumberAxis();
         final CategoryAxis yAxis = new CategoryAxis();
         bc = new BarChart<>(xAxis, yAxis);
         bc.setLegendVisible(false);
         bc.setTitle("Queue Simulation");
         xAxis.setLabel("People");
         xAxis.setTickLabelRotation(90);
         yAxis.setLabel("Rows");
         Cashier[] cashiers = supermarket.getCashiers();
         XYChart.Series<Number,String>[] cashierSeries = new XYChart.Series[cashiers.length];
        for(int i=0;i<cashiers.length;i++){
            cashierSeries[i] = new XYChart.Series<>();
            cashierSeries[i].setName("Cashier " + i);
            cashierSeries[i].getData().add(new XYChart.Data<>(cashiers[i].getQueueLength(),"Cashier "+i));
            bc.getData().add(cashierSeries[i]);
        }
        //Create a timeline in which the supermarket is updated the number of iterations per cycle
        // each (ms) milliseconds
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(ms), actionEvent -> {
            for(int i=0;i<iterationsPerCycle;i++){
                supermarket.update(currentIteration++);
            }
           for(int i=0;i<cashiers.length;i++){
                //There is only one Data in each series so it will be in index 0
                cashierSeries[i].getData().get(0).setXValue(cashiers[i].getQueueLength());
            }
           }
        ));
        //set the timeline to repeat the number of total iterations (taking into account that
        // each cycle we do a number of iterations)
        timeline.setCycleCount(totalIterations/iterationsPerCycle);
        timeline.play();
        //When the simulation is finished write the result to a file
        timeline.setOnFinished(actionevent ->{
            supermarket.finish(); // finalize supermarket (calculate final values)
            try {
                io.write(supermarket.toString());
            } catch (IOException e) {
                System.out.println("ERROR WRITING TO FILE");
                System.exit(1);
            }
        });
        Scene scene = new Scene(bc, 800, 800);
        stage.setScene(scene);
    }

}
