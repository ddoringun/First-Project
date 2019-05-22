package projectP;

import java.awt.Font;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.statistics.StatisticalCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class BarChart extends ApplicationFrame {

    public BarChart(final String title) {

        super(title);
        final StatisticalCategoryDataset dataset = createDataset();

        final CategoryAxis xAxis = new CategoryAxis("Type");
        xAxis.setLowerMargin(0.01d); // percentage of space before first bar
        xAxis.setUpperMargin(0.01d); // percentage of space after last bar
        xAxis.setCategoryMargin(0.05d); // percentage of space between categories
        final ValueAxis yAxis = new NumberAxis("Value");

        // define the plot
        final CategoryItemRenderer renderer = new StatisticalBarRenderer();
        final CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);

        final JFreeChart chart = new JFreeChart("Statistical Bar Chart Demo",
                                          new Font("Helvetica", Font.BOLD, 14),
                                          plot,
                                          true);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }


    private StatisticalCategoryDataset createDataset() {

        final DefaultStatisticalCategoryDataset result = new DefaultStatisticalCategoryDataset();

        result.add(32.5, 17.9, "Series 1", "Type 1");
        result.add(27.8, 11.4, "Series 1", "Type 2");
        result.add(29.3, 14.4, "Series 1", "Type 3");
        result.add(37.9, 10.3, "Series 1", "Type 4");

        result.add(22.9,  7.9, "Series 2", "Type 1");
        result.add(21.8, 18.4, "Series 2", "Type 2");
        result.add(19.3, 12.4, "Series 2", "Type 3");
        result.add(30.3, 20.7, "Series 2", "Type 4");

        result.add(12.5, 10.9, "Series 3", "Type 1");
        result.add(24.8,  7.4, "Series 3", "Type 2");
        result.add(19.3, 13.4, "Series 3", "Type 3");
        result.add(17.1, 10.6, "Series 3", "Type 4");

        return result;

    }


    public static void main(final String[] args) {

        final BarChart demo = new BarChart("Statistical Bar Chart Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}

