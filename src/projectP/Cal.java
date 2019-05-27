package projectP;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cal extends JFrame implements ActionListener {
	JTextField T1, T2;
	int j = 0;
	int prevnum, temp, result;
	String tempFun, tempInput = "";
	boolean finish = false;
	JButton Button[] = new JButton[16];

	@Override
	public void actionPerformed(ActionEvent e) {

		String input = e.getActionCommand();

		if (input.equals("+")) {
			prevnum = temp;
			tempFun = "+";
			tempInput = "";
			T2.setText("덧셈");
		} else if (input.equals("-")) {
			prevnum = temp;
			tempFun = "-";
			tempInput = "";
			T2.setText("뺄셈");
		} else if (input.equals("*")) {
			prevnum = temp;
			tempFun = "*";
			tempInput = "";
			T2.setText("곱셈");
		} else if (input.equals("/")) {
			prevnum = temp;
			tempFun = "/";
			tempInput = "";
			T2.setText("나눗셈");
		} else if (input.equals("C")) {
			tempInput = "";
			temp = 0;
			prevnum = 0;
			T1.setText("");
			T2.setText("지움");
		} else if (input.equals("=")) {
			if (tempFun.equals("+")) {
				result = prevnum + temp;
				T1.setText(String.valueOf(result));
				finish = true;
			} else if (tempFun.equals("-")) {
				result = prevnum - temp;
				T1.setText(String.valueOf(result));
				finish = true;
			} else if (tempFun.equals("*")) {
				result = prevnum * temp;
				T1.setText(String.valueOf(result));
				finish = true;
			} else if (tempFun.equals("/")) {
				result = prevnum / temp;
				T1.setText(String.valueOf(result));
				finish = true;
			}

		} else {
			if (finish == true) {
				T1.setText("0");
				finish = false;
				temp = 0;
				prevnum = 0;
				tempInput = "";
			}
			tempInput += e.getActionCommand();
			System.out.println(tempInput);
			T1.setText(tempInput);
			temp = Integer.parseInt(tempInput);
		}
	}

	public Cal() {

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

		setJMenuBar(menuBar);
		// 메뉴 생성 종료

		getContentPane().setLayout(new BorderLayout());
		setSize(545, 636);
		T1 = new JTextField("", 20);
		T1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		T2 = new JTextField("", 5);
		T2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
		T2.setForeground(Color.BLACK);
		T2.setEnabled(false);

		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();
		P1.add(T1);
		P1.add(T2);
		P2.setLayout(new GridLayout(4, 4, 10, 10));
		String btnVal[] = { "1", "2", "3", "*", "4", "5", "6", "/", "7", "8", "9", "+", "C", "0", "=", "-", };

		for (int i = 0; i <= 15; i++) {
			Button[i] = new JButton(btnVal[i]);
			P2.add(Button[i]);
			Button[i].addActionListener(this);
			Button[i].setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 35));
			Button[i].setForeground(Color.black);
		}

		getContentPane().add(P1, BorderLayout.NORTH);
		getContentPane().add(P2, BorderLayout.CENTER);
		setVisible(true);
	}

}