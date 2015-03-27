package daejeon.design.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Result implements ActionListener {
	JTextField text ;
	
	public Result(JTextField text) {
		// TODO Auto-generated constructor stub
		this.text = text ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String num = text.getText() ;
		int result = 0 ;
		
		switch(Calculator.op)	//���� switch�� �ȿ��� ����/���ڿ� �� �� �� �ִµ� char�� ���������� ������ �νĵǹǷ� ok
		{
		case '+' :
			result = Integer.parseInt(Calculator.temp) + Integer.parseInt(num) ;
			text.setText(Integer.toString(result));	//int->String����
			break ;
		case '-' :
			result = Integer.parseInt(Calculator.temp) - Integer.parseInt(num) ;
			text.setText(Integer.toString(result));		
			break ;
		case '*' :
			result = Integer.parseInt(Calculator.temp) * Integer.parseInt(num) ;
			text.setText(Integer.toString(result));		
			break ;
		case '/' :
			result = Integer.parseInt(Calculator.temp) / Integer.parseInt(num) ;
			text.setText(Integer.toString(result));		
			break ;
		}
		

	}

}
