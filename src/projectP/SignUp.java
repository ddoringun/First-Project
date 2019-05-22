package projectP;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SignUp {
	private static JTextField IdT;
	private static JTextField PwT;
	private static JTextField NameT;
	private static JTextField EmailT;
	private static JTextField HomeT;
	private static JTextField GenderT;
	private static JTextField AgeT;

	public SignUp() {
		JFrame f = new JFrame();
		f.setSize(461, 851);

		JButton btnNewButton = new JButton("회원등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WalletMemDAO dao = new WalletMemDAO();
				WalletMemDTO dto = new WalletMemDTO();
				String id = IdT.getText();
				String pw = PwT.getText();
				String name = NameT.getText();
				String email = EmailT.getText();
				String home = HomeT.getText();
				String gender = GenderT.getText();
				int age = Integer.parseInt(AgeT.getText());

				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setEmail(email);
				dto.setHome(home);
				dto.setGender(gender);
				dto.setAge(age);

				dao.insert(dto);
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
			}
		});
		f.getContentPane().setLayout(new BorderLayout(0, 0));
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 25));
		f.getContentPane().add(btnNewButton, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		f.getContentPane().add(panel_1, BorderLayout.NORTH);

		JLabel img = new JLabel("");
		ImageIcon icon = new ImageIcon("member.jpg");
		img.setIcon(icon);
		panel_1.add(img);
		JPanel panel = new JPanel();

		f.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("                                                                                                                                                             ");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 10));
		panel.add(lblNewLabel);
		JLabel lblId = new JLabel("ID");
		panel.add(lblId);
		lblId.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));

		IdT = new JTextField();
		panel.add(IdT);
		IdT.setFont(new Font("Dialog", Font.PLAIN, 23));
		IdT.setColumns(20);

		JLabel lblPw = new JLabel("PW");
		panel.add(lblPw);
		lblPw.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));

		PwT = new JTextField();
		panel.add(PwT);
		PwT.setFont(new Font("Dialog", Font.PLAIN, 23));
		PwT.setColumns(20);

		JLabel lblName = new JLabel("이름");
		panel.add(lblName);
		lblName.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));

		NameT = new JTextField();
		panel.add(NameT);
		NameT.setFont(new Font("Dialog", Font.PLAIN, 23));
		NameT.setColumns(20);

		JLabel lblEmail = new JLabel("E-mail");
		panel.add(lblEmail);
		lblEmail.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));

		EmailT = new JTextField();
		panel.add(EmailT);
		EmailT.setFont(new Font("Dialog", Font.PLAIN, 23));
		EmailT.setColumns(18);

		JLabel lblHome = new JLabel("주소");
		panel.add(lblHome);
		lblHome.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));

		HomeT = new JTextField();
		panel.add(HomeT);
		HomeT.setFont(new Font("Dialog", Font.PLAIN, 23));
		HomeT.setColumns(20);

		JLabel label_4 = new JLabel("성별");
		panel.add(label_4);
		label_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));

		GenderT = new JTextField();
		panel.add(GenderT);
		GenderT.setFont(new Font("Dialog", Font.PLAIN, 23));
		GenderT.setColumns(20);

		JLabel label_5 = new JLabel("나이");
		panel.add(label_5);
		label_5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));

		AgeT = new JTextField();
		panel.add(AgeT);
		AgeT.setFont(new Font("Dialog", Font.PLAIN, 23));
		AgeT.setColumns(20);

		f.setVisible(true);

	}
}
