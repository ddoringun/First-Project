package projectP;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login {
	private static JTextField IDText;
	static String myId;
	
	public static void main(String[] args) {
		
		
		
		WalletMemDTO dto = null;

		JFrame f = new JFrame("Wallet Login");
		f.getContentPane().setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		JLabel img = new JLabel();
		img.setHorizontalAlignment(SwingConstants.CENTER);

		f.setSize(589, 762);
		f.getContentPane().add(img);

		JLabel IDL = new JLabel("ID");
		IDL.setFont(new Font("Dialog", Font.PLAIN, 24));
		f.getContentPane().add(IDL);

		IDText = new JTextField();
		IDText.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		f.getContentPane().add(IDText);
		IDText.setColumns(10);

		JLabel PWL = new JLabel("PW");
		PWL.setFont(new Font("Dialog", Font.PLAIN, 24));
		f.getContentPane().add(PWL);

		JPasswordField PwText = new JPasswordField();
		PwText.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		PwText.setColumns(10);

		f.getContentPane().add(PwText);

		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WalletMemDAO dao = new WalletMemDAO();

				String InputId = IDText.getText();
				String InputPw = PwText.getText();
				
				try {
					if (dao.LoginCheck(InputId, InputPw)) {
						WelcomePhase name = new WelcomePhase();
						myId = InputId;
						System.out.println(myId);
						
					} else {
						JOptionPane.showMessageDialog(null, "※회원정보를 확인해주세요※", "회원정보 오류", JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		login.setFont(new Font("Consolas", Font.PLAIN, 31));
		f.getContentPane().add(login);

		JButton signup = new JButton("Sign Up");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp sign = new SignUp();

			}
		});
		signup.setFont(new Font("Consolas", Font.PLAIN, 31));
		f.getContentPane().add(signup);
		ImageIcon icon = new ImageIcon("wallet.png");
		img.setIcon(icon);

		FlowLayout flow = new FlowLayout();
		f.getContentPane().setLayout(flow);
		
		
		
		f.setVisible(true);

	}

}
