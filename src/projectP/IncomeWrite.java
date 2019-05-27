package projectP;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class IncomeWrite {
	private JTextField dateT;
	private JTextField incomeT;
	private JTextField memoT;

	public IncomeWrite() {

		String cate[] = { "월       급", "용       돈", "기       타", "초 기 자 본" };

		JFrame f = new JFrame("수입 작성 화면");
		f.setSize(523, 790);
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
		ImageIcon icon = new ImageIcon("income.JPG");
		img.setIcon(icon);
		panel.add(img);

		JPanel panel_1 = new JPanel();
		f.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblSkfwk = new JLabel("날    짜 :");
		panel_1.add(lblSkfwk);
		lblSkfwk.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));

		dateT = new JTextField();
		panel_1.add(dateT);
		dateT.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));
		dateT.setColumns(10);

		JLabel label = new JLabel("수 입 액 :");
		panel_1.add(label);
		label.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));

		incomeT = new JTextField();
		panel_1.add(incomeT);
		incomeT.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));
		incomeT.setColumns(10);

		JLabel label_1 = new JLabel("카 테 고 리 :");
		panel_1.add(label_1);
		label_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));

		JComboBox combobox = new JComboBox(cate);
		panel_1.add(combobox);
		combobox.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));

		JLabel label_2 = new JLabel("메    모 :");
		panel_1.add(label_2);
		label_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));

		memoT = new JTextField();
		panel_1.add(memoT);
		memoT.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));
		memoT.setColumns(10);

		JButton btnNewButton = new JButton("등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test = (String) combobox.getSelectedItem();
				IncomeDAO dao = new IncomeDAO();
				IncomeDTO dto = new IncomeDTO();
				String InputDate = dateT.getText();
				String InputMemo = memoT.getText();
				int InputIncome = Integer.parseInt(incomeT.getText());
				String InputCategory = test;
//				dto.setCategory(InputCategory);
				System.out.println(test);
				System.out.println(dto.getCategory());

				try {
					dao.insert(InputMemo, InputDate, InputIncome, InputCategory);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 27));
		f.getContentPane().add(btnNewButton, BorderLayout.SOUTH);

		f.setVisible(true);
	}

}
