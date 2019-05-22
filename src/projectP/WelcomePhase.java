package projectP;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import projectP.SelectMenu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class WelcomePhase {

	JLabel l;

	public WelcomePhase() {
		JFrame f = new JFrame("메인화면");
		f.setTitle("Welcome Phase");
		f.getContentPane().setLayout(new BorderLayout(0, 0));

		// 메뉴생성
		JMenuBar menuBar = new JMenuBar();
		JMenu SI = new JMenu("지출/수입");
		JMenu chart = new JMenu("지출 차트");
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

		JMenuItem menuItem_5 = new JMenuItem("월별 지출 차트");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_roundChart chart = new DB_roundChart();
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

		menuBar.add(SI);
		menuBar.add(chart);
		menuBar.add(lookup);
		menuBar.add(reco);

		f.setJMenuBar(menuBar);
		// 메뉴 생성 종료

		ImageIcon icon = new ImageIcon("pig.jpg");
		JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(icon);
		f.getContentPane().add(label, BorderLayout.CENTER);

		JPanel buttonP = new JPanel();
		f.getContentPane().add(buttonP, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("수입/지출 등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectMenu select = new SelectMenu();
			}

		});
		buttonP.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("수입/지출 조회");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectLookup select = new SelectLookup();
			}
		});
		buttonP.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("지출 차트");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_Chart chart = new DB_Chart();
			}
		});
		buttonP.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("추천");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecommendDAO name = new RecommendDAO();
			}
		});
		buttonP.add(btnNewButton_3);

		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.NORTH);

		l = new JLabel();
		l.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		panel.add(l);

		(new time()).start();
		f.setSize(760, 650);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	class time extends Thread {
		@Override
		public void run() {
			while (true) {
				Calendar cal = Calendar.getInstance();
				l.setText(cal.getTime() + "");

			}
		}

	}
}
