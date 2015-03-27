package daejeon.chatting;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;

public class ChatLogin extends JFrame implements ActionListener {
	private static final long serialVersionUID = -3691645975904838952L;
	
	JLabel id, pw ;	
	JButton buttonOK ;
	JTextField textID, textPW ;
	JPanel jp1 ;
	JPanel jp2 ;
	
	public ChatLogin() {
		design() ;
		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});
	}

	public void design() {
		Container ct = this.getContentPane() ;	//â �������ϱ����� �ʿ��Ѱ�
		
		jp1 = new JPanel() ;
		jp1.setLayout(new FlowLayout());
		
		jp2 = new JPanel() ;
		jp2.setLayout(new FlowLayout());
		
		id = new JLabel(" �� �� �� ") ;
		pw = new JLabel("��й�ȣ");
		
		buttonOK = new JButton("�α���") ;
		buttonOK.addActionListener(this);
		
		textID = new JTextField(15) ;
		textPW = new JTextField(15) ;
		
		jp1.add(id);
		jp1.add(textID);
		
		jp2.add(pw);
		jp2.add(textPW);
		
		ct.add(jp1, BorderLayout.NORTH) ;
		ct.add(jp2, BorderLayout.CENTER) ;
		ct.add(buttonOK, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		Connection con ;
		PreparedStatement psmt ;
		ResultSet rs ;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
			
			con = DriverManager.getConnection(url, "hr", "1234");
			String sqlStr = "select pass from login where id = ?";
			
			psmt = con.prepareStatement(sqlStr);
			psmt.setString(1, textID.getText());
			rs = psmt.executeQuery();
			
			if(rs.next()){	//�Է��� ���̵� �����ִ� ����� ����
				if(textPW.getText().equals(rs.getString("pass"))) {
					this.setVisible(false);	//ȭ�鿡�� â �����
					System.out.println("����");
					//ChatClient cc = new ChatClient(textID.getText(), "127.0.0.1", 20000);
				}else{
					JOptionPane.showMessageDialog(this,  "�н����� Ʋ����", "�α���", JOptionPane.ERROR_MESSAGE);
				}
					
			}else {
				JOptionPane.showMessageDialog(this,  "ȸ�� �ƴ�", "�α���", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
