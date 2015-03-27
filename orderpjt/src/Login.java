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
import javax.swing.JOptionPane;
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
		
		//login.addActionListener(new MainMenu(this, phoneNum, password));
		login.addActionListener(new Menu(this, phoneNum, password));
	}
	
	public void DBConn() {
		Connection con ;
		PreparedStatement psmt ;
		ResultSet rs ;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
			
			con = DriverManager.getConnection(url, "human", "1234");
			String sqlStr = "select * from users where phone  = ?";
			
			psmt = con.prepareStatement(sqlStr);
			psmt.setString(1, phoneNum.getText());
			rs = psmt.executeQuery();
			/*
			if(rs.next()){	//입력한 아이디를 갖고있는 사람이 있음
				if(textPW.getText().equals(rs.getString("pass"))) {
					this.setVisible(false);	//화면에서 창 사라짐
					System.out.println("성공");
					//ChatClient cc = new ChatClient(textID.getText(), "127.0.0.1", 20000);
				}else{
					JOptionPane.showMessageDialog(this,  "패스워드 틀렸음", "로그인", JOptionPane.ERROR_MESSAGE);
				}
					
			}else {
				JOptionPane.showMessageDialog(this,  "회원 아님", "로그인", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
			if(rs.next()){
				System.out.println("성공");
			}else{}
		}catch(Exception e) {
				e.printStackTrace();
			}
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.setBounds(500, 500, 500, 300);
		this.setVisible(true);		
		mb.setVisible(false);
		
	}

}
