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
		Calculator.temp = text.getText() ;	//Calculator�� �ִ� temp������ textfield�� �ִ� �� ����
		Calculator.op = '+' ;
		text.setText("");	//ȭ�鿡�� �� ����� ��
		}

}
