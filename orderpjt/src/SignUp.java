import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SignUp extends JFrame{

	JPanel jp_Phone, jp_Pwd;
	JLabel phone, pwd;
	JTextField phoneNum, password;
	
	JButton login;
	
	public SignUp() {
		
		design();
	}
	
	public void design() {
		
		Container ct = this.getContentPane();
		
		jp_Phone = new JPanel();
		jp_Pwd = new JPanel();
		
		phone = new JLabel("핸드폰 번호");
		pwd = new JLabel("비밀번호");

		phoneNum = new JTextField(20);
		password = new JTextField(20);
		
		login = new JButton("가입완료");
		
		jp_Phone.add(phone, BorderLayout.WEST);
		jp_Pwd.add(pwd, BorderLayout.WEST);
		
		jp_Phone.add(phoneNum, BorderLayout.EAST);
		jp_Pwd.add(password, BorderLayout.EAST);
		
		ct.add(jp_Phone, BorderLayout.NORTH);
		ct.add(jp_Pwd, BorderLayout.CENTER);
		ct.add(login, BorderLayout.SOUTH);
	}
	
	
	public static void main(String[] args) {
		SignUp signup = new SignUp();
		
		signup.setBounds(500, 500, 500, 500);
		signup.setVisible(true);
	}

}
