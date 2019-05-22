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
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RecommendDAO2 {

	String url = "jdbc:mysql://localhost:3306/wallet";
	String user = "root";
	String password = "1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	JFrame f = new JFrame();
	String pic[] = { "a.jpg", "b.png", "cb.jpg", "e.png", "ed.jpeg", "h.jpg", "hc.jpg", "hg.jpg", "hp.png", "t.png",
			"etc.png" };

	public RecommendDAO2() {
		f.setSize(760, 650);
		SpendDTO dto = new SpendDTO();

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
		f.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		f.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.SOUTH);

		// 세번째 추천
		JLabel reco3 = new JLabel("");
		ImageIcon icon3 = new ImageIcon();

		panel_5.add(reco3);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.NORTH);

		// 첫번째 추천
		JLabel reco1 = new JLabel("");
		ImageIcon icon1 = new ImageIcon();

		panel_4.add(reco1);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.NORTH);

		// 두번째 추천
		JLabel reco2 = new JLabel("");
		ImageIcon icon2 = new ImageIcon();

		panel_6.add(reco2);

		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.SOUTH);

		// 네번째 추천
		JLabel reco4 = new JLabel("");
		ImageIcon icon4 = new ImageIcon();

		panel_7.add(reco4);

		JPanel panel_1 = new JPanel();
		f.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("이전");
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("이후");
		panel_1.add(btnNewButton_1);
		// 메뉴 생성 종료

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("연결 성공");

			con = DriverManager.getConnection(url, user, password);
			System.out.println("드라이버 매니저 초기화 성공");

			String sql = "select * from spend where spend >= 10000";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				int spend = rs.getInt(3);
				String category = rs.getString(4);
				char[] chs = category.toCharArray();

				if ((chs[0] == 'A') && (spend >= 10000)) {
					icon1 = new ImageIcon("a.jpg");
					reco1.setIcon(icon1);
					System.out.println(spend + category);
				} else if ((chs[0] == 'B') && (spend >= 10000)) {
					icon1 = new ImageIcon("b.png");
					reco1.setIcon(icon1);
				} else if ((chs[0] == 'C') && (spend >= 10000)) {
					icon1 = new ImageIcon("cb.jpg");
					reco1.setIcon(icon1);
				} else if ((chs[0] == 'E') && (spend >= 10000)) {
					icon1 = new ImageIcon("e.png");
					reco1.setIcon(icon1);
				} else if ((chs[0] == 'E') && (chs[1] == 'D') && (spend >= 10000)) {
					icon1 = new ImageIcon("ed.jpeg");
					reco1.setIcon(icon1);
				} else if ((chs[0] == 'H') && (spend >= 10000)) {
					icon1 = new ImageIcon("h.jpg");
					reco1.setIcon(icon1);
				} else if ((chs[0] == 'H') && (chs[1] == 'C') && (spend >= 10000)) {
					icon1 = new ImageIcon("hc.jpg");
					reco1.setIcon(icon1);
				} else if ((chs[0] == 'H') && (chs[1] == 'G') && (spend >= 10000)) {
					icon1 = new ImageIcon("hg.jpg");
					reco1.setIcon(icon1);
				} else if ((chs[0] == 'H') && (chs[1] == 'P') && (spend >= 10000)) {
					icon1 = new ImageIcon("hp.png");
					reco1.setIcon(icon1);
				} else if ((chs[0] == 'T') && (spend >= 10000)) {
					icon1 = new ImageIcon("t.png");
					reco1.setIcon(icon1);
				} else {
					icon1 = new ImageIcon("etc.png");
					reco1.setIcon(null);
				}
			}

		} catch (Exception e) {

		}

		f.setVisible(true);

	}

}
