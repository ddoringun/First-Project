package projectP;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;


public class ChartT {
public static void main(String[] args) {
		
		ChartT demo = new ChartT();
		JFreeChart chart = demo.getChart();
		ChartFrame f1 = new ChartFrame("Bar chart", chart);
		f1.setSize(800, 400);
		f1.setVisible(true);
	}
	
	
	public JFreeChart getChart() {
		//데이터 생성 부분
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); //bar char1
		
		//데이터 입력(값, 범례, 카테고리)
		dataset1.addValue(8.0, "S1", "1월");
		dataset1.addValue(3.5, "S1", "2월");
		dataset1.addValue(3.0, "S1", "3월");
		dataset1.addValue(5.0, "S1", "4월");
		dataset1.addValue(7.0, "S1", "5월");
		dataset1.addValue(7.0, "S1", "6월");
		dataset1.addValue(8.0, "S1", "7월");
		dataset1.addValue(0, "S1", "8월");
		dataset1.addValue(0, "S1", "9월");
		dataset1.addValue(0, "S1", "10월");
		dataset1.addValue(0, "S1", "11월");
		dataset1.addValue(0, "S1", "12월");
		
		//렌더링 생성 및 세팅
		//rendering create
		final BarRenderer renderer = new BarRenderer();
		final BarRenderer renderer2 = new BarRenderer();
		final LineAndShapeRenderer renderer3 = new LineAndShapeRenderer();
		
		//공통 옵션 정의
		final StandardCategoryItemLabelGenerator gene = new StandardCategoryItemLabelGenerator();
		final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		final ItemLabelPosition P_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6,TextAnchor.TOP_LEFT);
		Font f = new Font("Gulim", Font.BOLD, 14);
		Font axisF = new Font("Gulim", Font.PLAIN, 14);
		
		
		//렌더링 세팅
		//그래프1 
		renderer.setBaseItemLabelGenerator((org.jfree.chart.labels.CategoryItemLabelGenerator) gene);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBasePositiveItemLabelPosition(p_center);
		renderer.setBaseItemLabelFont(f);
		renderer.setSeriesPaint(0, new Color(0,162,255));
		
		
		//plot 생성
		final CategoryPlot plot = new CategoryPlot();
		
		//plot에 데이터 적재
		plot.setDataset(dataset1);
		plot.setRenderer(renderer);
		
		
		//plot 기본 설정
		plot.setOrientation(PlotOrientation.VERTICAL); //그래프의 표시방향
		plot.setRangeGridlinesVisible(true); //x축 가이드라인 표시
		plot.setDomainGridlinesVisible(true); //y축 가이드라인 표시
		
		
		//렌더링 순서 정의 : dataset 등록 순서대로 렌더링 (먼저 넣은게 아래로)
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
		
		//x축 세팅
		plot.setDomainAxis(new CategoryAxis()); //x축 종류 설정
		plot.getDomainAxis().setTickLabelFont(axisF); // x축 눈금 라벨 폰트 조정
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
		//카테고리 라벨 위치 조정
		
		//y축 세팅
		plot.setRangeAxis(new NumberAxis()); //y축 종류 설정
		plot.getRangeAxis().setTickLabelFont(axisF); //y축 눈금 라벨 폰트 조정
		
		//세팅된 plot를 바탕으로 chart생성
		final JFreeChart chart = new JFreeChart(plot);
		
		
		
		return chart;
	}

}
