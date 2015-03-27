package daejeon.design.calculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Calculator01 extends JFrame implements WindowListener {
	
	JButton one, two, three, four, five, six, seven, eight, nine, zero ;
	JButton plus, minus, mul, div, result, back, clear ;
	JPanel jp ;
	JTextField jt ;
	
	public static String temp ;	//textfield에있는 값 저장
	public static char op ; //연산자 저장
	
	public Calculator01() {
		design() ;
		addWindowListener(this);	//이 클래스에서 창을 닫을 것이기때문에 this
	}	
	
	public void design() {
		Container ct = this.getContentPane() ;
		
		jt = new JTextField() ;
		jp = new JPanel() ;
		
		jp.setLayout(new GridLayout(5, 4)); //default layout을 flowlayout -> gridlayout으로 바꿔줌
		
		//container에 textfield 추가
		ct.add(jt, BorderLayout.NORTH);
		
		jt.setEditable(false);	//textfield에 키보드 입력이 안되도록
		jt.setHorizontalAlignment(JTextField.RIGHT);
				
		//button만들기
		one = new JButton("1") ;
		two = new JButton("2") ;
		three = new JButton("3") ;
		four = new JButton("4") ;
		five = new JButton("5") ;
		six = new JButton("6") ;
		seven = new JButton("7") ;
		eight = new JButton("8") ;
		nine = new JButton("9") ;
		zero = new JButton("0") ;
		plus = new JButton("+") ;
		minus = new JButton("-") ;
		mul = new JButton("*") ;
		div = new JButton("/") ;
		result = new JButton("=") ;
		back = new JButton("<=") ;
		clear = new JButton("C") ;
		
		//panel에 button추가
		jp.add(one);
		jp.add(two);
		jp.add(three);
		jp.add(plus);
		jp.add(four);
		jp.add(five);
		jp.add(six);
		jp.add(minus);
		jp.add(seven);
		jp.add(eight);
		jp.add(nine);
		jp.add(mul);
		jp.add(zero);	
		jp.add(result);
		jp.add(back) ;
		jp.add(div);
		jp.add(clear);			
		
		//버튼이 눌리면 클래스로 이벤트를 넘겨줌
		one.addActionListener(new One(jt));
		two.addActionListener(new Two(jt));
		three.addActionListener(new Three(jt));
		four.addActionListener(new Four(jt));
		five.addActionListener(new Five(jt));
		six.addActionListener(new Six(jt));
		seven.addActionListener(new Seven(jt));
		eight.addActionListener(new Eight(jt));
		nine.addActionListener(new Nine(jt));
		zero.addActionListener(new Zero(jt));
		plus.addActionListener(new Plus(jt));
		minus.addActionListener(new Minus(jt));
		mul.addActionListener(new Mul(jt));
		div.addActionListener(new Div(jt));
		result.addActionListener(new Result(jt));
		back.addActionListener(new Back(jt));
		clear.addActionListener(new Clear(jt));		
		
		//container에 panel추가
		ct.add(jp, BorderLayout.CENTER) ;
		
		// x 누르면 창닫히도록 하기위한 소스
		
		
				
	}

	//이런 경우에는 windowListener의 메소드중 사용안하는 것도 오버라이딩해야하므로 효율적이지x
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(-1);	//어플리케이션도 종료
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
