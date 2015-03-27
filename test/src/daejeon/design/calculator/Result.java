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
		
		switch(Calculator.op)	//원래 switch문 안에는 정수/문자열 만 들어갈 수 있는데 char는 내부적으로 정수로 인식되므로 ok
		{
		case '+' :
			result = Integer.parseInt(Calculator.temp) + Integer.parseInt(num) ;
			text.setText(Integer.toString(result));	//int->String으로
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
