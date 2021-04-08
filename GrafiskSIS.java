package gymnasiearbete;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class GrafiskSIS extends Application {

    @Override public void start(Stage primaryStage) {
        
        //Defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("Antal dagar");
        
        //Creating the chart
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        
        lineChart.setTitle("Coronaviruset, 2020");
        lineChart.setCreateSymbols(false); //Lite störande
        yAxis.setAutoRanging(false);
        yAxis.setUpperBound(2500000);
        yAxis.setTickUnit(100000);
        
        //Defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("S(t)");
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("I(t)");
        
        //Startvärden
        double s = 2500000;
        double i = 4;
        double n = s + i;
        double s_prim;
        double i_prim = 0;
        double b = 0.28125;
        double y = 0.125;
        
        //Populating the series with data
        //S(t)
        for(int x = 0; x < 170; x++) //Ändra dagar
        {
            s_prim = ((-b) * i * s)/n;
            i_prim = ((double)(b * i * s)/n - (y * i));
            
            s = s + s_prim;
            i = i + i_prim;
            
            series.getData().add(new XYChart.Data(x, s));

            series1.getData().add(new XYChart.Data(x, i));
            
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(series, series1);

        primaryStage.setTitle("Smittspridningmodeller");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
