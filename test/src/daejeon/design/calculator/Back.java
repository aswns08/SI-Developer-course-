package daejeon.design.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Back implements ActionListener {
	JTextField text ;
	
	public Back(JTextField text) {
		// TODO Auto-generated constructor stub
		this.text = text ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = text.getText() ;
		text.setText(s.substring(0, s.length()-1)) ;
	}

}
