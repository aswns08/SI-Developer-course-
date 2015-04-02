import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	JPanel jpPhone, jpPwd, jpButton ;
	JLabel phone, pwd;
	JTextField phoneNum ;
	JPasswordField password;
	Member mb ;

	JButton login;
	JButton signUp ;

	public Login(Member mb) {
		this.mb = mb ;
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

		jpPhone = new JPanel();
		jpPwd = new JPanel();
		jpButton = new JPanel() ;

		phone = new JLabel("핸드폰 번호");
		pwd = new JLabel("비밀번호");

		phoneNum = new JTextField(20);
		password = new JPasswordField(20);
		password.setEchoChar('*');   //비밀번호 입력되면 *으로 뜨도록

		login = new JButton("로그인");
		signUp = new JButton("회원 가입") ;

		jpPhone.add(phone, BorderLayout.WEST);
		jpPhone.add(phoneNum, BorderLayout.EAST);

		jpPwd.add(pwd, BorderLayout.WEST);
		jpPwd.add(password, BorderLayout.EAST);

		jpButton.add(login, BorderLayout.WEST) ;
		jpButton.add(signUp, BorderLayout.EAST);

		ct.add(jpPhone, BorderLayout.NORTH);
		ct.add(jpPwd, BorderLayout.CENTER);
		ct.add(jpButton, BorderLayout.SOUTH);

		login.addActionListener(new Menu(this));
		signUp.addActionListener(new SignUp(this));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		this.setBounds(300, 300, 500, 300);
		this.setVisible(true);      
		this.setTitle("로그인");
		mb.setVisible(false);

	}

}