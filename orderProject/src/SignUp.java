import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener{
   Member mb ;
   Login lg ;

   JPanel jp_Phone, jp_Pwd;
   JLabel phone, pwd;
   JTextField phoneNum ;
   JTextField password;
   
   JButton login;
   
   public SignUp(Member mb) {
      this.mb = mb ;      
      design();

      //창 종료
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(-1);
         }
      });
   }
   
   public SignUp(Login lg) {
      this.lg = lg ;      
      design();

      //창 종료
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
      password = new JTextField(20);
      
      login = new JButton("가입하기");
      
      jp_Phone.add(phone, BorderLayout.WEST);
      jp_Pwd.add(pwd, BorderLayout.WEST);
      
      jp_Phone.add(phoneNum, BorderLayout.EAST);
      jp_Pwd.add(password, BorderLayout.EAST);
      
      ct.add(jp_Phone, BorderLayout.NORTH);
      ct.add(jp_Pwd, BorderLayout.CENTER);
      ct.add(login, BorderLayout.SOUTH);
      
      login.addActionListener(this);
   }
   
   public void DBConn() {
      Connection con ;
      PreparedStatement psmt ;
      int result ;
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@203.237.154.131:1521:XE" ;
         
         con = DriverManager.getConnection(url, "human", "1234");
         String sqlStr = "insert into users values (?,?,human_seq.NEXTVAL)" ;
         
         psmt = con.prepareStatement(sqlStr);
         //psmt.setString(1, phoneNum.getText());
         psmt.setString(1, phoneNum.getText());
         psmt.setString(2, password.getText());
         result = psmt.executeUpdate() ;
         
         if(result==1){   //입력된 핸드폰번호가 있는 경우
            JOptionPane.showMessageDialog(this,  "가입 성공", "회원가입", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);   
         }
         else {
            JOptionPane.showMessageDialog(this,  "가입 실패", "회원가입", JOptionPane.ERROR_MESSAGE);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub

         //Member.java 에서 회원가입 클릭된 경우
         if ( e.getActionCommand().equals("회원 가입")) {
            this.setBounds(300, 300, 500, 300);
            this.setTitle("회원가입");
            this.setVisible(true);
         }

         //SignUp.java 에서 가입하기 클릭된 경우
         else if(e.getActionCommand().equals("가입하기")) {

            if(this.phoneNum.getText().equals("")) {
               JOptionPane.showMessageDialog(this,  "핸드폰번호를 입력하지않았습니다", "로그인", JOptionPane.ERROR_MESSAGE);
            }
            else if(this.password.getText().equals("")) {
               JOptionPane.showMessageDialog(this,  "비밀번호를 입력하지않았습니다", "로그인", JOptionPane.ERROR_MESSAGE);
            }
            else {
               this.DBConn();
            }
         }
   }
}