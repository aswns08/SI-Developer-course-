package daejeon.design.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class One implements ActionListener{
	JTextField text ;
	
	public One(JTextField text) {
		System.out.println("1����");
		// TODO Auto-generated constructor stub
		this.text = text ;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		text.setText(text.getText()+"1") ;
		//text.setText(text.getText()+1) ; ����+����=>���ڰ� �ǹǷ� �ᵵ ������x	
	}

}
