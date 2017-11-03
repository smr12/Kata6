package kata4.view;
import java.awt.Dimension;
import javax.swing.JPanel;
import kata4.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    public Histogram <String> histogram;
    public HistogramDisplay(Histogram <String> histogram){
        super("Kata3 : Histograma");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    public void execute(){
        setVisible(true);
    }
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart =
                ChartFactory.createBarChart(
                "JfreeChart",
                "Dominios email",
                "Nº email",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return chart;        
    }
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(15, "", "ulpgc.es");
        dataSet.addValue(8, "", "ull.es");
        dataSet.addValue(2, "", "hotmail.com");
        dataSet.addValue(6, "", "gmail.com");
        
        for( String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key), "", "key");
        }
        return dataSet;
    }
}
