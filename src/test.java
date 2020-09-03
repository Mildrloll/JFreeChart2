import javafx.embed.swing.SwingNode;
import javafx.scene.layout.AnchorPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class test {
    private AnchorPane root;
    private final TimeSeriesCollection tempCollection = new TimeSeriesCollection();
    private final TimeSeries tempData = new TimeSeries("Temperatur");
    private final TimeSeriesCollection humidCollection = new TimeSeriesCollection();
    private final TimeSeries humidData = new TimeSeries("Luftfugtighed");
    private final JFreeChart chart = ChartFactory.createTimeSeriesChart("Temperatur of luftfugtighed", "Tid", "Temperatur ()", tempCollection);
    private final SwingNode swingNode = new SwingNode();

    public void read() {
        ChartPanel chartPanel = new ChartPanel(chart);
        swingNode.setContent(chartPanel);
        root.getChildren().add(swingNode);
        AnchorPane.setLeftAnchor(swingNode, 16.0);
        AnchorPane.setRightAnchor(swingNode, 16.0);
        tempCollection.addSeries(tempData);
        humidCollection.addSeries(humidData);
        chart.getXYPlot().getRangeAxis(0).setRange(0, 50);
        final XYPlot plot = chart.getXYPlot();
        final NumberAxis numberAxis2 = new NumberAxis("Liftfugtighed (%)");
        numberAxis2.setRange(0, 100);
        plot.setRangeAxis(1, numberAxis2);
        plot.setDataset(1, humidCollection);
        plot.setRenderer(new XYLineAndShapeRenderer());
    }
}
