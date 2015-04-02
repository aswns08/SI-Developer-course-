import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Menu extends JFrame implements ActionListener{

   private static final long serialVersionUID = 1L;
   Login lg ;
   Member mb ;
   SignUp su ;

   String menu ="" ;
   
   static ArrayList<String> orderMenu= new ArrayList<String>(); 

   //버튼 생성   

   //******************* 메인메뉴 ********************   
   JLabel titleMain ; 

   private JButton menuChicken ;
   private JButton selectChicken ;
   private JLabel priceChicken ;

   private JButton menuPizza ;
   private JButton selectPizza ;
   private JLabel pricePizza ;

   private JButton menuPasta ;
   private JButton selectPasta ;
   private JLabel pricePasta ; 

   private JPanel jpChicken ;
   private JPanel jpPizza ;
   private JPanel jpPasta ;
   private JPanel jpTotalMain ;

   //******************* 주류 ********************
   JLabel titleDrink;

   private JButton menuSoju ;
   private JButton selectSoju;
   private JLabel priceSoju;

   private JButton menuBeer ;
   private JButton selectBeer;
   private JLabel priceBeer;

   private JButton menuBernini;
   private JButton selectBernini;
   private JLabel priceBernini;   

   private JPanel jpSoju;
   private JPanel jpBeer;
   private JPanel jpBernini;
   private JPanel jpTotalDrink ;

   //******************* 사이드메뉴 ********************
   JLabel titleSide;

   private JButton menuPotato ;
   private JButton selectPotato ;
   private JLabel pricePotato ;

   private JButton menuSalad ;
   private JButton selectSalad ;
   private JLabel priceSalad ;

   private JButton menuFruit ;
   private JButton selectFruit ;
   private JLabel priceFruit ;

   private JPanel jpPotato;
   private JPanel jpSalad ;
   private JPanel jpFruit ;
   private JPanel jpTotalSide ;

   //***********************************************   
   private JPanel jpTotal ;
   private JPanel jpFooter;
   private JButton goBill;   
   
   //******************* 추천 메뉴 ********************
   private JLabel titleBest ;
   private JTextArea bestMenu ; 
   private JPanel jpBest ;
   
   private String best[] = new String[3] ;

   private Container ca;

   //Login한 회원일 경우
   public Menu(Login lg) {
      this.lg = lg ;

      this.design() ;   

      //창 닫기
      addWindowListener(new WindowAdapter() {   
         public void windowClosing(WindowEvent e) {
            System.exit(-1);
         }
      });
   }

   //Member에서 비회원일 경우
   public Menu(Member mb) { 
      this.mb = mb ;
      this.design() ;   

      //창 닫기
      addWindowListener(new WindowAdapter() {   
         public void windowClosing(WindowEvent e) {
            System.exit(-1);
         }
      });

   }

   // 선택 된 메뉴를 ArrayList에 담는 메서드
   public static void addMenu(String menuName) {
      orderMenu.add(menuName);
   }

   public void design() {      

      jpTotal = new JPanel() ;
      goBill = new JButton("주문서보기");

      // ******************* 메인메뉴 ********************      
      titleMain = new JLabel() ;
      titleMain.setFont(titleMain.getFont().deriveFont(18.0f));   //title 사이즈조절
      titleMain.setText("    ************* 메인 메뉴 ************");

      //값 넣어주기               
      menuChicken= new JButton(" 치  킨 ");
      priceChicken = new JLabel("18000원     =====> ");
      selectChicken= new JButton("선택");
      selectChicken.putClientProperty("menu", "chicken");   //key : menu / value : chicken

      menuPizza= new JButton(" 피  자 ");
      pricePizza = new JLabel("23000원     =====> ");
      selectPizza= new JButton("선택");
      selectPizza.putClientProperty("menu", "pizza");

      menuPasta= new JButton("파스타");
      pricePasta = new JLabel("20000원     =====> ");
      selectPasta= new JButton("선택");
      selectPasta.putClientProperty("menu", "pasta");

      jpChicken = new JPanel();
      jpPizza = new JPanel();
      jpPasta = new JPanel();      
      jpTotalMain = new JPanel();

      jpFooter = new JPanel() ;

      jpChicken.add(menuChicken);
      jpChicken.add(priceChicken);
      jpChicken.add(selectChicken);

      jpPizza.add(menuPizza);
      jpPizza.add(pricePizza);
      jpPizza.add(selectPizza);

      jpPasta.add(menuPasta);
      jpPasta.add(pricePasta);
      jpPasta.add(selectPasta);

      jpTotalMain.setLayout(new GridLayout(5,1));
      jpTotalMain.add(titleMain) ;
      jpTotalMain.add(jpChicken) ;
      jpTotalMain.add(jpPizza) ;
      jpTotalMain.add(jpPasta) ;   

      //******************* 주류 ********************
      titleDrink = new JLabel("     **************** 주류  ***************");
      titleDrink.setFont(titleDrink.getFont().deriveFont(18.0f));   //title 사이즈조절

      menuSoju = new JButton(" 소  주 ");
      priceSoju = new JLabel("3500원     =====> ");
      selectSoju = new JButton("선택");
      selectSoju.putClientProperty("menu", "soju");

      menuBeer = new JButton(" 맥  주 ");
      priceBeer = new JLabel("4000원     =====> ");
      selectBeer = new JButton("선택");
      selectBeer.putClientProperty("menu", "beer");

      menuBernini = new JButton("버니니");
      priceBernini = new JLabel("7000원     =====> ");
      selectBernini = new JButton("선택");
      selectBernini.putClientProperty("menu", "bernini");

      jpSoju = new JPanel();
      jpBeer = new JPanel();
      jpBernini = new JPanel();
      jpTotalDrink = new JPanel();

      jpSoju.add(menuSoju) ;
      jpSoju.add(priceSoju) ;
      jpSoju.add(selectSoju) ;

      jpBeer.add(menuBeer) ;
      jpBeer.add(priceBeer) ;
      jpBeer.add(selectBeer) ;

      jpBernini.add(menuBernini) ;
      jpBernini.add(priceBernini) ;
      jpBernini.add(selectBernini) ;

      jpTotalDrink.setLayout(new GridLayout(5, 1));
      jpTotalDrink.add(titleDrink) ;
      jpTotalDrink.add(jpSoju);
      jpTotalDrink.add(jpBeer);
      jpTotalDrink.add(jpBernini);

      //******************* 사이드 메뉴 ********************
      titleSide = new JLabel("       ************* 사이드 메뉴  ************");
      titleSide.setFont(titleSide.getFont().deriveFont(18.0f));   //title 사이즈조절

      menuPotato = new JButton("감자칩");
      pricePotato = new JLabel("5000원     =====> ");
      selectPotato = new JButton("선택");
      selectPotato.putClientProperty("menu", "potato");   

      menuSalad = new JButton("샐러드");
      priceSalad = new JLabel("8000원     =====> ");
      selectSalad = new JButton("선택");
      selectSalad.putClientProperty("menu", "salad");

      menuFruit = new JButton(" 과  일 ");;
      priceFruit = new JLabel("12000원     =====> ");
      selectFruit = new JButton("선택");
      selectFruit.putClientProperty("menu", "fruit");


      jpPotato = new JPanel();
      jpSalad = new JPanel();
      jpFruit = new JPanel();
      jpTotalSide = new JPanel();

      jpPotato.add(menuPotato);
      jpPotato.add(pricePotato);
      jpPotato.add(selectPotato);

      jpSalad.add(menuSalad);
      jpSalad.add(priceSalad);
      jpSalad.add(selectSalad);

      jpFruit.add(menuFruit);
      jpFruit.add(priceFruit);
      jpFruit.add(selectFruit);

      jpTotalSide.setLayout(new GridLayout(5, 1));
      jpTotalSide.add(titleSide);
      jpTotalSide.add(jpPotato);
      jpTotalSide.add(jpSalad);
      jpTotalSide.add(jpFruit);
      
      
      //******************* 추천 메뉴 ********************
      titleBest = new JLabel("       ************* BEST 메뉴  ************");
      titleSide.setFont(titleBest.getFont().deriveFont(18.0f));   //title 사이즈조절
   
      bestMenu = new JTextArea() ;
      bestMenu.setEditable(false);
         
      jpBest = new JPanel();
      jpBest.setLayout(new GridLayout(3,1));
      
      jpBest.add(titleBest);
      jpBest.add(bestMenu) ;

      // ********************************************************

      jpTotal.add(jpTotalMain) ;
      jpTotal.add(jpTotalDrink) ;
      jpTotal.add(jpTotalSide) ;
      jpTotal.add(jpBest) ;

      jpFooter.add(goBill, BorderLayout.CENTER);   //주문서보기로 이동 =3

      ca = this.getContentPane();   

      //container에 넣어주기
      ca.add(jpTotal, BorderLayout.CENTER);
      ca.add(jpFooter, BorderLayout.SOUTH);   //앞으로,뒤로
      
      
      // 메뉴 눌렀을 때 이벤트 추가 -> 메뉴 정보창 뜨도록!
      menuChicken.addActionListener(this);
      menuPizza.addActionListener(this);
      menuPasta.addActionListener(this);
      
      menuSoju.addActionListener(this);
      menuBeer.addActionListener(this);
      menuBernini.addActionListener(this);
      
      menuPotato.addActionListener(this);
      menuSalad.addActionListener(this);
      menuFruit.addActionListener(this);
      

      // 메인메뉴의 선택 버튼을 눌렀을 때 이벤트 추가
      selectChicken.addActionListener(this);
      selectPizza.addActionListener(this);
      selectPasta.addActionListener(this);

      // 주류메뉴의 선택 버튼을 눌렀을 때 이벤트 추가
      selectSoju.addActionListener(this);
      selectBeer.addActionListener(this);
      selectBernini.addActionListener(this);

      // 사이드메뉴의 선택 버튼을 눌렀을 때 이벤트 추가
      selectPotato.addActionListener(this);
      selectSalad.addActionListener(this);
      selectFruit.addActionListener(this);
      
      goBill.addActionListener(new OrderBill(this));

   }

   public void DBConn() {
      Connection con ;
      PreparedStatement psmt ;
      ResultSet rs ;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@203.237.154.131:1521:XE" ;

         con = DriverManager.getConnection(url, "human", "1234");
         String sqlStr = "select pwd from users where phone = ?";

         psmt = con.prepareStatement(sqlStr);
         //psmt.setString(1, phoneNum.getText());
         psmt.setString(1, lg.phoneNum.getText());
         rs = psmt.executeQuery();

         if(rs.next()){   //입력된 핸드폰번호가 있는 경우
            if(lg.password.getText().equals(rs.getString("pwd"))) {   //비밀번호가 맞는경우
               this.setBounds(100, 100, 400, 800);         
               this.setVisible(true);   //Menu창 창 띄움
               this.setTitle("메뉴판");
               lg.setVisible(false);   //login창 닫기
               System.out.println("로그인성공");

            }else{ //비밀번호를 틀린 경우
               JOptionPane.showMessageDialog(this,  "패스워드 틀렸음", "로그인", JOptionPane.ERROR_MESSAGE);
               lg.password.setText("");
            }               
         }else { //입력된 핸드폰번호가 없는 경우

            JOptionPane.showMessageDialog(this,  "회원 아님", "로그인", JOptionPane.ERROR_MESSAGE);
            lg.phoneNum.setText("");
            lg.password.setText("");
         }
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   // 베스트 메뉴 출력하는 메서드
   public void DBBest() {
      Connection con ;
      PreparedStatement psmt ;
      ResultSet rs ;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@203.237.154.131:1521:XE" ;

         con = DriverManager.getConnection(url, "human", "1234");
         String sqlStr = "select * from orders order by quentity desc";

         psmt = con.prepareStatement(sqlStr);         
         rs = psmt.executeQuery();

         int i=0 ;
         while(rs.next())
         {
            if(i>=3)
               break ;
            best[i] = rs.getString("name") ;
            System.out.println( best[i]);
            bestMenu.append(best[i]+"\n");
            System.out.println("베스트메뉴 읽어오기");
            i++ ;
         }      
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub

      if (e.getActionCommand().equals("로그인")) {
         if(lg.phoneNum.getText().equals("")) {
            JOptionPane.showMessageDialog(this,  "핸드폰번호를 입력하지않았습니다", "로그인", JOptionPane.ERROR_MESSAGE);
         }
         else if(lg.password.getText().equals("")) {
            JOptionPane.showMessageDialog(this,  "비밀번호를 입력하지않았습니다", "로그인", JOptionPane.ERROR_MESSAGE);
         }
         else {
            this.DBConn();
            this.DBBest();
         }
      }

      else if(e.getActionCommand().equals("비회원 주문")) {
         this.setBounds(100, 100, 400, 800);         
         this.setVisible(true);
         mb.setVisible(false);
         this.DBBest();
      }
      
      else if(e.getActionCommand().equals(" 치  킨 ")) {
         JOptionPane.showMessageDialog(null, "윤기가잘잘 흐르는 바싹한 치킨", "Chicken", JOptionPane.INFORMATION_MESSAGE);
      }else if(e.getActionCommand().equals(" 피  자 ")) {
         JOptionPane.showMessageDialog(null, "피자를 피자", "Pizza", JOptionPane.INFORMATION_MESSAGE);
      }else if(e.getActionCommand().equals("파스타")) {
         JOptionPane.showMessageDialog(null, "여기가 이탈리안지 한국있지 헷갈리게하는 파스타", "Pasta", JOptionPane.INFORMATION_MESSAGE);
      }
      else if(e.getActionCommand().equals(" 소  주 ")) {
         JOptionPane.showMessageDialog(null, "너한잔 나한잔", "Soju", JOptionPane.INFORMATION_MESSAGE);
      }else if(e.getActionCommand().equals(" 맥  주 ")) {
         JOptionPane.showMessageDialog(null, "캬~ 시원하다!", "Beer", JOptionPane.INFORMATION_MESSAGE);
      }else if(e.getActionCommand().equals("버니니")) {
         JOptionPane.showMessageDialog(null, "니들이 버니니 맛을 알아?", "Bernini", JOptionPane.INFORMATION_MESSAGE);
      }
      else if(e.getActionCommand().equals("감자칩")) {
         JOptionPane.showMessageDialog(null, "너한잔 나한잔", "Potato", JOptionPane.INFORMATION_MESSAGE);
      }else if(e.getActionCommand().equals("샐러드")) {
         JOptionPane.showMessageDialog(null, "캬~ 시원하다!", "Salad", JOptionPane.INFORMATION_MESSAGE);
      }else if(e.getActionCommand().equals(" 과  일 ")) {
         JOptionPane.showMessageDialog(null, "새콤달콤 과일", "Fruit", JOptionPane.INFORMATION_MESSAGE);
      }

      else if(e.getActionCommand().equals("선택")) {
         JButton source = (JButton)e.getSource();
         menu = (String)source.getClientProperty("menu");
         addMenu(menu);
         System.out.println("주문된 메뉴 : " +orderMenu );
      }
   }
}