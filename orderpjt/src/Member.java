import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Member extends JFrame implements ActionListener{
	OrderMain om ;	
	MainMenu mm ;

	JButton member;
	JButton nomember;
	JButton signup;
	JPanel jp;
	
	public Member(OrderMain om) {		
		this.om = om ;
		
		design();
		
		//창 닫기
		addWindowListener(new WindowAdapter() {	
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});
	}
		
	public void design() {
		
		Container ct = this.getContentPane(); 
		
		member = new JButton("회원 주문");
		nomember = new JButton("비회원 주문");
		signup = new JButton("회원 가입");
		jp = new JPanel();
		
		jp.setLayout(new GridLayout(1, 3));
		
		jp.add(member);
		jp.add(nomember);
		jp.add(signup);
		
		ct.add(jp, BorderLayout.CENTER);
		
		member.addActionListener(new Login(this));
		nomember.addActionListener(new Menu(this));
		signup.addActionListener(new SignUp(this));
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		this.setBounds(300, 300, 400, 300);
		this.setVisible(true);	
		om.setVisible(false);		
	}

}
