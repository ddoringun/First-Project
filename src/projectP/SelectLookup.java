package projectP;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class SelectLookup {

	public SelectLookup() {

		JFrame f = new JFrame("수입/지출 조회창");
		f.setSize(486, 681);
		f.getContentPane().setLayout(new BorderLayout(0, 0));

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

		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel img = new JLabel("");
		ImageIcon icon = new ImageIcon("look.jpg");
		img.setIcon(icon);
		panel.add(img);

		JPanel panel_1 = new JPanel();
		f.getContentPane().add(panel_1, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("메뉴를 선택하세요.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 50));

		JButton btnNewButton = new JButton("수입");
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 35));

		JButton btnNewButton_1 = new JButton("지출");
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 35));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookupUserSpend look = new LookupUserSpend();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookupUserIncom lookup = new LookupUserIncom();
			}
		});

		f.setVisible(true);
	}

}
