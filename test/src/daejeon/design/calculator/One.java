package daejeon.design.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class One implements ActionListener{
	JTextField text ;
	
	public One(JTextField text) {
		System.out.println("1생성");
		// TODO Auto-generated constructor stub
		this.text = text ;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		text.setText(text.getText()+"1") ;
		//text.setText(text.getText()+1) ; 문자+숫쟈=>문자가 되므로 써도 에러는x	
	}

}
