import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SignUp extends JFrame implements ActionListener{
	Member mb ;

	JPanel jp_Phone, jp_Pwd;
	JLabel phone, pwd;
	JTextField phoneNum ;
	JTextField password;
	
	JButton login;
	
	public SignUp(Member mb) {
		this.mb = mb ;		
		design();

		//â ����
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
		
		phone = new JLabel("�ڵ��� ��ȣ");
		pwd = new JLabel("��й�ȣ");

		phoneNum = new JTextField(20);
		password = new JTextField(20);
		
		login = new JButton("�����ϱ�");
		
		jp_Phone.add(phone, BorderLayout.WEST);
		jp_Pwd.add(pwd, BorderLayout.WEST);
		
		jp_Phone.add(phoneNum, BorderLayout.EAST);
		jp_Pwd.add(password, BorderLayout.EAST);
		
		ct.add(jp_Phone, BorderLayout.NORTH);
		ct.add(jp_Pwd, BorderLayout.CENTER);
		ct.add(login, BorderLayout.SOUTH);
		
		login.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if ( e.getActionCommand().equals("ȸ�� ����")) {
			this.setBounds(500, 500, 500, 300);
			this.setVisible(true);
		}

		else if(e.getActionCommand().equals("�����ϱ�")) {
		
			this.setVisible(false);
			
		}

	}

}
