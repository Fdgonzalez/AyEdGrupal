package tp04simulaciondecolas.GUI;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import tp04simulaciondecolas.Cashier;
import tp04simulaciondecolas.IO;
import tp04simulaciondecolas.Supermarket;

import java.io.IOException;

class Controller {
    private final int totalIterations;
    private final int iterationsPerCycle;
    private final int ms;
    private int currentIteration;
    private Supermarket supermarket;
    private IO io;
    private final Paint IDLE = Paint.valueOf("#00FF00");
    private final Paint BUSY = Paint.valueOf("#FF0000");

    Controller(Supermarket supermarket, int totalIterations, int iterationsPerCycle, int ms, IO io) {
        this.supermarket = supermarket;
        this.totalIterations = totalIterations;
        this.iterationsPerCycle = iterationsPerCycle;
        this.ms = ms;
        this.io = io;
        currentIteration = 0;
    }

    void init(Stage stage) {
        Text currentIter = new Text("Iteración actual: 0");
        int currentUpperBound = 10;
        final NumberAxis xAxis = new NumberAxis(0,currentUpperBound,1);
        final CategoryAxis yAxis = new CategoryAxis();
        BarChart<Number, String> bc = new BarChart<>(xAxis, yAxis);
        bc.setLegendVisible(false);
        bc.setTitle("Queue Simulation");
        xAxis.setLabel("People");
        yAxis.setLabel("Queues");
        Cashier[] cashiers = supermarket.getCashiers();
        XYChart.Series<Number, String>[] cashierSeries = new XYChart.Series[cashiers.length];
        for (int i = 0; i < cashiers.length; i++) {
            cashierSeries[i] = new XYChart.Series<>();
            cashierSeries[i].setName("Cashier " + i);
            cashierSeries[i].getData().add(new XYChart.Data<>(cashiers[i].getQueueLength(), "Cashier " + i));
            bc.getData().add(cashierSeries[i]);
        }

        //Create a gridpane with all cashier's status (busy / free)
        GridPane cashiersGP = new GridPane();
        Rectangle[] cashierState = new Rectangle[cashiers.length];
        for (int i = 0; i < cashiers.length; i++) {
            Text name = new Text("Cashier " + i + " ");
            cashierState[i] = new Rectangle();
            cashierState[i].setWidth(40);
            cashierState[i].setHeight(40);
            cashierState[i].setFill(IDLE);
            GridPane.setConstraints(name, i, 0);
            GridPane.setConstraints(cashierState[i], i, 1);
            cashiersGP.getChildren().addAll(name, cashierState[i]);
        }

        //Create a timeline in which the supermarket is updated the number of iterations per cycle
        // each (ms) milliseconds
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(ms), actionEvent -> {
            for (int i = 0; i < iterationsPerCycle; i++) {
                supermarket.update(currentIteration++);
            }
            currentIter.setText("Iteración actual: " + currentIteration);
            for (int i = 0; i < cashiers.length; i++) {
                if(cashiers[i].getQueueLength() > xAxis.getUpperBound()){
                    //less annoying than the default auto-ranging
                    xAxis.setUpperBound(xAxis.getUpperBound()*2);
                }
                //There is only one Data in each series so it will be in index 0
                cashierSeries[i].getData().get(0).setXValue(cashiers[i].getQueueLength());
                if (cashiers[i].isIdle()) {
                    cashierState[i].setFill(IDLE);
                } else {
                    cashierState[i].setFill(BUSY);
                }
            }
        }
        ));
        //set the timeline to repeat the number of total iterations (taking into account that
        // each cycle we do a number of iterations)
        timeline.setCycleCount(totalIterations / iterationsPerCycle);
        timeline.play();
        //When the simulation is finished write the result to a file
        timeline.setOnFinished(actionevent -> {
            supermarket.finish(); // finalize supermarket (calculate final values)
            try {
                io.write(supermarket.toString());
            } catch (IOException e) {
                System.out.println("ERROR WRITING TO FILE");
                System.exit(1);
            }
        });
        GridPane all = new GridPane();
        GridPane.setConstraints(bc, 0, 0);
        GridPane.setConstraints(currentIter, 0, 1);
        ScrollPane scrolly = new ScrollPane();
        GridPane.setConstraints(scrolly,0,2);
        scrolly.setContent(cashiersGP);
        scrolly.setPrefViewportHeight(100);
        all.getChildren().addAll(bc, currentIter, scrolly);
        Scene scene = new Scene(all, 800, 800);
        stage.setScene(scene);
    }

}
