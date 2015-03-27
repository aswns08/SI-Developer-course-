package daejeon.design.calculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Calculator extends JFrame {
	
	JButton one, two, three, four, five, six, seven, eight, nine, zero ;
	JButton plus, minus, mul, div, result, back, clear ;
	JPanel jp ;
	JTextField jt ;
	
	public static String temp ;	//textfield���ִ� �� ����
	public static char op ; //������ ����
	
	public Calculator() {
		design() ;
		addWindowListener(new WindowAdapter() {	//�͸�Ŭ����  
			//WindowListener�� implements�� WindowAdapter�� �͸�Ŭ������ ����
			//WindowListener�� interface�̹Ƿ� ��� method�� overriding�ؾ��ϹǷ� ȿ��x
			//WindowAdapter�� WindowListener�� ��� method�� overriding�س� Ŭ�����̹Ƿ� �츮�� ��Ŭ�����߿��� �ʿ��� method������Ҽ�o
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});
		/*
		addWindowListener(new WindowListener() { //�͸�Ŭ����
			//WindowListener�� �������̽��� �������̽��ɼ� ������(�޸𸮿� �ö� �� ������), ��� �Լ��� �������̵��ؼ� �������̽�ȭ�� 
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});*/	
	}	
	
	public void design() {
		Container ct = this.getContentPane() ;
		
		jt = new JTextField() ;
		jp = new JPanel() ;
		
		jp.setLayout(new GridLayout(5, 4)); //default layout�� flowlayout -> gridlayout���� �ٲ���
		
		//container�� textfield �߰�
		ct.add(jt, BorderLayout.NORTH);
		
		jt.setEditable(false);	//textfield�� Ű���� �Է��� �ȵǵ���
		jt.setHorizontalAlignment(JTextField.RIGHT);
				
		//button�����
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
		
		//panel�� button�߰�
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
		
		//��ư�� ������ Ŭ������ �̺�Ʈ�� �Ѱ���
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
		
		//container�� panel�߰�
		ct.add(jp, BorderLayout.CENTER) ;
		
		// x ������ â�������� �ϱ����� �ҽ� (�͸�Ŭ����)
		
		
				
	}
	

}
