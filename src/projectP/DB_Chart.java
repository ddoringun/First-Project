package projectP;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class DB_Chart {

	String url = "jdbc:mysql://localhost:3306/wallet";
	String user = "root";
	String pass = "1234";
	Connection con = null;
	PreparedStatement ps;
	ResultSet rs;
	int salary[] = new int[12];
	String month[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", };

	public DB_Chart() {
		JFrame f = new JFrame();
		f.setTitle("Welcome!");
		f.setSize(735, 603);
		JFreeChart barChart = ChartFactory.createBarChart("Spend Chart", "Month", "Spend / 1000", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367)); // 크기설정
		f.getContentPane().add(chartPanel);
//		setContentPane(chartPanel);

		// 메뉴생성
		JMenuBar menuBar = new JMenuBar();
		JMenu SI = new JMenu("지출/수입");
		JMenu chart = new JMenu("차트");
		JMenu lookup = new JMenu("조회");
		JMenu reco = new JMenu("추천");
		

		JMenuItem menuItem = new JMenuItem("지출 입력");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpendWrite spend = new SpendWrite();
			}
		});
		SI.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("수입 입력");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncomeWrite income = new IncomeWrite();
			}
		});
		SI.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("지출 차트");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_Chart chart = new DB_Chart();
			}
		});
		chart.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("수입 조회");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookupUser lookup = new LookupUser();
			}
		});
		lookup.add(menuItem_3);
		JMenuItem menuItem_4 = new JMenuItem("지출 조회");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookupUserSpend lookup = new LookupUserSpend();
			}
		});
		lookup.add(menuItem_4);
		
		JMenuItem menuItem_6 = new JMenuItem("맞춤추천");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecommendDAO reco = new RecommendDAO();
			}
		});
		reco.add(menuItem_6);

		menuBar.add(SI);
		menuBar.add(chart);
		menuBar.add(lookup);
		menuBar.add(reco);

		f.setJMenuBar(menuBar);
		// 메뉴 생성 종료

		JPanel buttonP = new JPanel();
		f.getContentPane().add(buttonP, BorderLayout.SOUTH);
		f.setVisible(true);

	}

	private CategoryDataset createDataset() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결성공");
			String sql = "SELECT * FROM spend WHERE id = ?";

			ps = con.prepareStatement(sql); // 전송객체를 생성해 준다.
			ps.setString(1, Login.myId);

			rs = ps.executeQuery(); // 전송
			while (rs.next()) {
				
				String d1 = rs.getString("Date").substring(2, 4);
				int spend = rs.getInt("spend");

				if (d1.equals("01")) {
					salary[0] += spend;
				} else if (d1.equals("02")) {
					salary[1] += spend;
				} else if (d1.equals("03")) {
					salary[2] += spend;
				} else if (d1.equals("04")) {
					salary[3] += spend;
				} else if (d1.equals("05")) {
					salary[4] += spend;
				} else if (d1.equals("06")) {
					salary[5] += spend;
				} else if (d1.equals("07")) {
					salary[6] += spend;
				} else if (d1.equals("08")) {
					salary[7] += spend;
				} else if (d1.equals("09")) {
					salary[8] += spend;
				} else if (d1.equals("10")) {
					salary[9] += spend;
				} else if (d1.equals("11")) {
					salary[10] += spend;
				} else if (d1.equals("12")) {
					salary[11] += spend;
				}

				for (int i = 0; i < 12; i++) {
					dataset.addValue(salary[i] * 0.001, "TotalSpend", month[i]);
				}

			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

		return dataset;
	}

}
