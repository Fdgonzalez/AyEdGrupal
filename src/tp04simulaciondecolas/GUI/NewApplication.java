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


public class NewApplication extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number, String> bc =
                new BarChart<>(xAxis, yAxis);
        bc.setTitle("Cashier Simulation");
        xAxis.setLabel("People");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Rows");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Cashier 1");
        series1.getData().add(new XYChart.Data(4, "Row 1"));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Cashier 2");
        series2.getData().add(new XYChart.Data(3, "Row 2"));


        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Cashier 3");
        series3.getData().add(new XYChart.Data(-1, "Row 3"));


        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
