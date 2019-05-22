package projectP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LookupUser {

	String url = "jdbc:mysql://localhost:3306/wallet";
	String user = "root";
	String password = "1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public LookupUser() {

		String title[] = { "Date", "Income", "Category", "Memo" };
		JFrame f = new JFrame("수입 조회");
		DefaultTableModel model = new DefaultTableModel(title, 0);
		JTable table = new JTable(model);
		String arr[] = { "Date", "Income", "Category", "Memo" };
		model.addRow(arr);

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

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("연결 성공");

			con = DriverManager.getConnection(url, user, password);
			System.out.println("드라이버 매니저 초기화 성공");

			String sql = "select * from income where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Login.myId);

			rs = ps.executeQuery();
			while (rs.next()) {
				String date = rs.getString(2);
				int income = rs.getInt(3);
				String category = rs.getString(4);
				String memo = rs.getString(5);

				arr[0] = date;
				arr[1] = Integer.toString(income);
				arr[2] = category;
				arr[3] = memo;
				model.addRow(arr);
			}

		} catch (Exception e) {

		}
		f.add(table);
		f.setBounds(0, 0, 900, 310);
		f.setVisible(true);
	}

}