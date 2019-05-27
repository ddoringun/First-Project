package projectP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class RecommendDAO {

	String url = "jdbc:mysql://localhost:3306/wallet";
	String user = "root";
	String password = "1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	JFrame f = new JFrame();
	String[] pic = { "a.jpg", "b.png", "cb.jpg", "e.jpg", "ed.jpeg", "h.png", "hc.jpeg", "hg.jpg", "hp.jpg", "t.png",
			"etc.png" };
	JLabel linkL = new JLabel("");
	String U;

	public void goWeb(JLabel l, String u) {
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(u));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public RecommendDAO() {
		f.setSize(760, 650);
		SpendDTO dto = new SpendDTO();

		// 메뉴생성
		JMenuBar menuBar = new JMenuBar();
		JMenu SI = new JMenu("등록");
		JMenu chart = new JMenu("차트");
		JMenu lookup = new JMenu("조회");
		JMenu reco = new JMenu("추천");
		JMenu cal = new JMenu("기타");

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

		JMenu incomeC = new JMenu("수입");
		chart.add(incomeC);

		JMenuItem menuItem_7 = new JMenuItem("수입 막대차트");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_ChartIncome chart = new DB_ChartIncome();
			}
		});
		incomeC.add(menuItem_7);

		JMenuItem menuItem_10 = new JMenuItem("수입 원차트");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_roundChartIncome chart = new DB_roundChartIncome();
			}
		});
		incomeC.add(menuItem_10);

		JMenu spendC = new JMenu("치출");
		chart.add(spendC);
		JMenuItem menuItem_2 = new JMenuItem("지출 막대차트");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_ChartSpend chart = new DB_ChartSpend();
			}
		});
		spendC.add(menuItem_2);

		JMenuItem menuItem_9 = new JMenuItem("지출 원차트");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_roundChartSpend chart = new DB_roundChartSpend();
			}
		});
		spendC.add(menuItem_9);

		JMenuItem menuItem_3 = new JMenuItem("수입 조회");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookupUserIncom lookup = new LookupUserIncom();
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

		JMenuItem menuItem_5 = new JMenuItem("월별 지출 차트");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_roundChartSpend chart = new DB_roundChartSpend();
			}
		});
		chart.add(menuItem_5);

		JMenuItem menuItem_6 = new JMenuItem("맞춤추천");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecommendDAO reco = new RecommendDAO();
			}
		});
		reco.add(menuItem_6);

		JMenuItem menuItem_8 = new JMenuItem("계산기");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cal cal = new Cal();
			}
		});
		cal.add(menuItem_8);

		menuBar.add(SI);
		menuBar.add(chart);
		menuBar.add(lookup);
		menuBar.add(reco);
		menuBar.add(cal);

		f.setJMenuBar(menuBar);
		// 메뉴 생성 종료
		
		f.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		f.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel img = new JLabel("");
		ImageIcon icon = new ImageIcon("reco.jpg");
		img.setIcon(icon);
		img.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label = new JLabel("추천 받으실 메뉴를 선택하세요.");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 45));
		panel.add(label, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);

		JButton ee = new JButton("식비");
		ee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[3]);
				img.setIcon(icon);
				linkL.setText("<html> WebSite :  <a href =\"\">http://www.kurly.com/shop/main/index.php/</a></html>");
				U = "http://www.kurly.com/shop/main/index.php";
				linkL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goWeb(linkL, U);
			}
		});
		panel_2.add(ee);
		ee.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));

		JButton btnNewButton_3 = new JButton("교통비");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[1]);
				img.setIcon(icon);
				linkL.setText("<html> WebSite :  <a href =\"\">https://www.kakaocorp.com/service/KakaoBus/</a></html>");
				U = "https://www.kakaocorp.com/service/KakaoBus";
				linkL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goWeb(linkL, U);
			}
		});
		panel_2.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));

		JButton btnNewButton_5 = new JButton("주거/통신비");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[8]);
				img.setIcon(icon);
				linkL.setText(
						"<html> WebSite :  <a href =\"\">http://card-gorilla.com/sub.php?contents=submenu03&load=menu03_02_02_sk/</a></html>");
				U = "http://card-gorilla.com/sub.php?contents=submenu03&load=menu03_02_02_sk";
				linkL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goWeb(linkL, U);
			}
		});
		panel_2.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));

		JButton btnNewButton_6 = new JButton("생활용품");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[7]);
				img.setIcon(icon);
				linkL.setText("<html> WebSite :  <a href =\"\">http://www.ssg.com/</a></html>");
				U = "http://www.ssg.com";
				linkL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goWeb(linkL, U);
			}
		});
		panel_2.add(btnNewButton_6);
		btnNewButton_6.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));

		JButton btnNewButton_7 = new JButton("의복/미용");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[2]);
				img.setIcon(icon);
				linkL.setText("<html> WebSite :  <a href =\"\">https://store.musinsa.com/app/</a></html>");
				U = "https://store.musinsa.com/app";
				linkL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goWeb(linkL, U);
			}
		});
		panel_2.add(btnNewButton_7);
		btnNewButton_7.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));

		panel_3.add(img);
		linkL.setFont(new Font("Consolas", Font.PLAIN, 15));
		linkL.setHorizontalAlignment(SwingConstants.CENTER);

		panel_3.add(linkL, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		f.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton button = new JButton("건강/문화");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[6]);
				img.setIcon(icon);
				linkL.setText(
						"<html> WebSite :  <a href =\"\">http://www.g-health.kr/portal/cts/view.do?cNo=200656&menuNo=200656/</a></html>");
				U = "http://www.g-health.kr/portal/cts/view.do?cNo=200656&menuNo=200656";
				linkL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goWeb(linkL, U);
			}
		});
		panel_1.add(button);
		button.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));

		JButton button_1 = new JButton("교육");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[4]);
				img.setIcon(icon);
				linkL.setText("<html> WebSite :  <a href =\"\">http://www.itbank.so/</a></html>");
				U = "http://www.itbank.so";
				linkL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goWeb(linkL, U);
			}
		});
		panel_1.add(button_1);
		button_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));

		JButton button_2 = new JButton("경조사/회비");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[5]);
				img.setIcon(icon);
				linkL.setText(
						"<html> WebSite :  <a href =\"\">https://www.kbanknow.com/ib20/mnu/PBKMAN000000/</a></html>");
				U = "https://www.kbanknow.com/ib20/mnu/PBKMAN000000";
				linkL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goWeb(linkL, U);
			}
		});
		panel_1.add(button_2);
		button_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));

		JButton button_3 = new JButton("세금/이자");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[9]);
				img.setIcon(icon);
				linkL.setText(
						"<html> WebSite :  <a href =\"\">https://www.hometax.go.kr/ui/pp/agitx_index.html/</a></html>");
				U = "https://www.hometax.go.kr/ui/pp/agitx_index.html";
				linkL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goWeb(linkL, U);
			}
		});
		panel_1.add(button_3);
		button_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));

		JButton button_4 = new JButton("용돈/기타");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[0]);
				img.setIcon(icon);
				linkL.setText("<html> WebSite :  <a href =\"\">https://www.kakaobank.com/</a></html>");
				U = "https://www.kakaobank.com";
				linkL.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goWeb(linkL, U);
			}
		});
		panel_1.add(button_4);
		button_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));

		JButton btnEtc = new JButton("etc");
		btnEtc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(pic[10]);
				img.setIcon(icon);
				linkL.setText(null);
			}
		});
		panel_1.add(btnEtc);
		btnEtc.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		// 메뉴 생성 종료

		f.setVisible(true);

	}

}
