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

	JPanel jp_Phone, jp_Pwd;
	JLabel phone, pwd;
	JTextField phoneNum ;
	JPasswordField password;
	Member mb ;
	
	JButton login;
	
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
		
		jp_Phone = new JPanel();
		jp_Pwd = new JPanel();
		
		phone = new JLabel("핸드폰 번호");
		pwd = new JLabel("비밀번호");

		phoneNum = new JTextField(20);
		password = new JPasswordField(20);
		password.setEchoChar('*');	//비밀번호 입력되면 *으로 뜨도록
		
		login = new JButton("로그인");
		
		jp_Phone.add(phone, BorderLayout.WEST);
		jp_Pwd.add(pwd, BorderLayout.WEST);
		
		jp_Phone.add(phoneNum, BorderLayout.EAST);
		jp_Pwd.add(password, BorderLayout.EAST);
		
		ct.add(jp_Phone, BorderLayout.NORTH);
		ct.add(jp_Pwd, BorderLayout.CENTER);
		ct.add(login, BorderLayout.SOUTH);
		
		login.addActionListener(new MainMenu(this, phoneNum, password));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.setBounds(500, 500, 500, 300);
		this.setVisible(true);		
		mb.setVisible(false);
		
	}

}
