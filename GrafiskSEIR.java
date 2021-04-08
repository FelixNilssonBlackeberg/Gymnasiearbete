package gymnasiearbete;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class GrafiskSEIR extends Application {
    
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
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("R(t)");
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("E(t)");
        
        //Startvärden
        double s = 2500000;
        double e = 10;
        double i = 4;
        double r = 0;
        double n = s + e + i + r;
        double s_minskning;
        double i_prim;
        double r_ökning;
        double e_prim;
        double sigma = 0.2;
        double b = 0.28125;
        double y = 0.125;
        
        //Populating the series with data
        //S(t)
        for(int x = 0; x < 240; x++) //Ändra dagar
        {
            s_minskning = ((-b) * i * s)/n;
            e_prim = ((double)(b * i * s))/n - (sigma * e);
            i_prim = ((double)(sigma * e)) - (y * i);
            r_ökning = (y * i);
            
            s = s + s_minskning;
            e = e + e_prim;
            i = i + i_prim;
            r = r + r_ökning;
            
            series.getData().add(new XYChart.Data(x, s));

            series1.getData().add(new XYChart.Data(x, i));
            
            series2.getData().add(new XYChart.Data(x, r));
            
            series3.getData().add(new XYChart.Data(x, e));
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(series, series1, series2, series3);

        primaryStage.setTitle("Smittspridningmodeller");
        primaryStage.setScene(scene);
        primaryStage.show(); 
}

    public static void main(String[] args) {
        launch(args);
    }

}
