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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class DB_roundChart {

	String url = "jdbc:mysql://localhost:3306/wallet";
	String user = "root";
	String pass = "1234";
	Connection con = null;
	PreparedStatement ps;
	ResultSet rs;
	String monthS[] = { "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911",
			"1912" };
	double salary[] = new double[12];

	public DB_roundChart() {
		JFrame f = new JFrame();
		f.setTitle("Welcome!");
		f.setSize(752, 645);
		JFreeChart roundChart = ChartFactory.createPieChart3D("Month Spend Chart", (PieDataset) createDataset(), true, true,
				false);
//				("chartTitle", "Month", "Spend / 1000", createDataset(),PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(roundChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367)); // 크기설정
		f.getContentPane().add(chartPanel);

		// 메뉴생성
		JMenuBar menuBar = new JMenuBar();
		JMenu SI = new JMenu("지출/수입");
		JMenu chart = new JMenu("차트");
		JMenu lookup = new JMenu("조회");

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
		JMenuItem menuItem_5 = new JMenuItem("세대별 지출 차트");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_roundChart chart = new DB_roundChart();
			}
		});
		chart.add(menuItem_5);

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

		menuBar.add(SI);
		menuBar.add(chart);
		menuBar.add(lookup);

		f.setJMenuBar(menuBar);
		// 메뉴 생성 종료

		JPanel buttonP = new JPanel();
		f.getContentPane().add(buttonP, BorderLayout.SOUTH);
		f.setVisible(true);

	}

	private PieDataset createDataset() {
		final DefaultPieDataset dataset = new DefaultPieDataset();

		for (int i = 0; i < 12; i++) {
			try {
				String driver = "com.mysql.jdbc.Driver";
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, pass);
				System.out.println("연결성공");
				
				String sql = "SELECT * FROM spend WHERE date like ? and id = ?";

				ps = con.prepareStatement(sql); // 전송객체를 생성해 준다.
				ps.setString(1, monthS[i] + "%");  // % -> 뒤에 오는걸 신경X
				ps.setString(2, Login.myId);
				rs = ps.executeQuery(); // 전송
				
				while (rs.next()) {
					System.out.println(rs.getString("Date"));
					String d1 = rs.getString("Date").substring(2, 4);
					System.out.println(d1);
					System.out.println(rs.getInt("spend"));
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
					
					
					for (int j = 0; j < 12; j++) {
						dataset.setValue(monthS[j].substring(2, 4), salary[j]);  // 이름 + 값
					}

				}

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
		

		return dataset;
	}

}

