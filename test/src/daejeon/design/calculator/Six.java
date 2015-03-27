package daejeon.design.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Six implements ActionListener {
	JTextField text ;
	
	public Six(JTextField text) {
		// TODO Auto-generated constructor stub
		this.text = text ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		text.setText(text.getText()+"6") ;
	}

}
