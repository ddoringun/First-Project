package projectP;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SpendWrite {
	private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tf3;

	public SpendWrite() {

		String[] category = { "식       비", "교 통 비", "주거/통신비", "생활용품", "의복/미용", "건강/문화", "교육/육아", "경조사/회비", "세금/이자",
				"용돈/기타", "미 분 류" };

		JFrame f = new JFrame("지출 내역 입력");
		f.getContentPane().setFont(new Font("굴림", Font.PLAIN, 25));
		f.getContentPane().setLayout(new BorderLayout(0, 0));

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

		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel img = new JLabel("");
		ImageIcon icon = new ImageIcon("spend.jpg");
		img.setIcon(icon);
		panel.add(img);

		JPanel panel_1 = new JPanel();
		f.getContentPane().add(panel_1, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("날    짜 :");
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));

		tf1 = new JTextField();
		panel_1.add(tf1);
		tf1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));
		tf1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("지 출 액 :");
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));

		tf2 = new JTextField();
		panel_1.add(tf2);
		tf2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));
		tf2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("카 테 고 리 :");
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));

		JComboBox combo = new JComboBox(category);
		panel_1.add(combo);
		combo.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));

		JLabel lblNewLabel_3 = new JLabel("메    모 :");
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));

		tf3 = new JTextField();
		panel_1.add(tf3);
		tf3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));
		tf3.setColumns(10);
		String test = combo.getSelectedItem().toString();

		JButton btn = new JButton("등록");
		f.getContentPane().add(btn, BorderLayout.SOUTH);
		btn.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 27));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpendDAO dao = new SpendDAO();
				String InputDate = tf1.getText();
				String InputMemo = tf3.getText();
				String InputCategory = test;
				int InputSpend = Integer.parseInt(tf2.getText());

				try {
					dao.insert(InputMemo, InputDate, InputSpend, InputCategory);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		f.setSize(523, 790);
		f.setVisible(true);
	}

}
