package daejeon.design.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Plus implements ActionListener {
	JTextField text ;
	
	public Plus(JTextField text) {
		// TODO Auto-generated constructor stub
		this.text = text ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Calculator.temp = text.getText() ;	//Calculator에 있는 temp변수에 textfield에 있는 값 저장
		Calculator.op = '+' ;
		text.setText("");	//화면에서 값 지우는 것
		}

}
