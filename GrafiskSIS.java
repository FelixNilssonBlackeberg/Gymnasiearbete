package gymnasiearbete;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class GrafiskSIS extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Antal dagar");
        yAxis.setLabel("Individer");

        //Creating the chart
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Coronaviruset, 2020");
        lineChart.setCreateSymbols(false); //Lite störande
        yAxis.setAutoRanging(false);
        yAxis.setUpperBound(2500000);
        yAxis.setTickUnit(100000);
        //yAxis.setUpperBound(100000);
        //yAxis.setTickUnit(10000);

        //Defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("S(t)");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("I(t)");

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Dödsfall");

        //Startvärden
        double s = 2383265;
        double i = 4;
        double n = s + i;
        double s_prim;
        double i_prim = 0;
        double blirsjuka_prim;
        double dör_prim;
        double b = 0.415;
        double y = 0.143;
        double döda = 0;

        //Populating the series with data
        //S(t)
        for (int x = 0; x <= 100; x++) //Ändra dagar
        {
            s_prim = ((-b) * i * s) / n + y * i;

            blirsjuka_prim = ((b) * i * s) / n;

            i_prim = ((double) (b * i * s)) / n - (y * i);

            dör_prim = (y * i) * 0.006;

            s = (s + s_prim - dör_prim);
            i = (i + i_prim);
            döda = döda + dör_prim;

            series.getData().add(new XYChart.Data(x, s));

            series1.getData().add(new XYChart.Data(x, i));

            series2.getData().add(new XYChart.Data(x, döda));
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(series, series1, series2);

        primaryStage.setTitle("Smittspridningmodeller");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
