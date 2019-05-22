package projectP;

import javax.swing.JFrame;


import java.awt.BorderLayout;
import javax.swing.JPanel;

public class LookUp {

	
	
	
	public static void main(String[] args) {
		
		LookUp name = new LookUp();
		
	}
	
	
	
	public LookUp() {

		JFrame f = new JFrame();
		f.setSize(500,500);
		f.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		
		f.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		f.setVisible(true);
	}
}


