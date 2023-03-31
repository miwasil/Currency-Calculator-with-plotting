import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class Plot extends JFrame{  
  
  private static final long serialVersionUID = 1L;  
  
  public Plot(String title, DefaultCategoryDataset dataset2) {  
    super(title);       
    DefaultCategoryDataset dataset = dataset2;  
    JFreeChart chart = ChartFactory.createLineChart(  
        "Currency rates",  
        "Date",  
        "Price", 
        dataset  
        );  
  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
 
} 