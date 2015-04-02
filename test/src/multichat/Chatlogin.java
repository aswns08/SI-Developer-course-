package multichat;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Chatlogin extends JFrame implements ActionListener{		
	private static final long serialVersionUID = 7889485093277921289L;
	JPanel jp, jp1;
	JLabel jl, jl1;
	JTextField jt,jt1;
	JButton jb;
	Connection con;
	ResultSet rs;
	PreparedStatement psmt;

	public Chatlogin(String title){
		super(title);
		design();
	}
	public void design(){
		Container ca = this.getContentPane();
		ca.setLayout(new GridLayout(3, 1));
		jp = new JPanel();
		jl = new JLabel("아이디 : ");
		jt = new JTextField(20);
		jp.add(jl);
		jp.add(jt);

		jp1 = new JPanel();
		jl1 = new JLabel("Pass : ");
		jt1 = new JTextField(20);
		jp1.add(jl1);
		jp1.add(jt1);
		
		jb = new JButton("로그인");
		jb.addActionListener(this);
		
		ca.add(jp);
		ca.add(jp1);
		ca.add(jb);
	 }
	 
	 public void actionPerformed(ActionEvent av){
		 try{
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
			con=DriverManager.getConnection(url, "hr", "1234");
			String sqlStr = "select pass from login where id=?";
			psmt = con.prepareStatement(sqlStr);
			psmt.setString(1, jt.getText());	
			rs=psmt.executeQuery();
			if(rs.next()) {
				if(jt1.getText().equals(rs.getString("pass"))){
					this.setVisible(false);
					System.out.println("성공");
					ChatClient cc = new ChatClient(jt.getText(),"127.0.0.1", 20000);
					cc.setBounds(200, 300, 400, 400);
					cc.setVisible(true);
				}else{
					JOptionPane.showMessageDialog
					(this, "패스워드 틀맀다","로그인",JOptionPane.ERROR_MESSAGE);
				}			
			}else{
				JOptionPane.showMessageDialog
				(this, "니는 우리 회원 아니네..직이삘라","로그인",JOptionPane.ERROR_MESSAGE);
			}
		 }catch(Exception e){
			 e.printStackTrace();
		 }			
	 }
	 

}
