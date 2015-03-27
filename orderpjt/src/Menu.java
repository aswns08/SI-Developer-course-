import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Menu extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	Login lg ;
	Member mb ;
	
	static ArrayList<String> orderMenu= new ArrayList<String>(); 
	
	//버튼 생성	
	//JTextField, JPasswordField 공유 
	private JTextField phoneNum ;
	private JPasswordField password ;
	
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
	
	private Container ca;

	//Login한 회원일 경우
	public Menu(Login lg, JTextField phoneNum, JPasswordField password) {
		this.phoneNum = phoneNum ;
		this.password = password ;	
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
		titleMain.setFont(titleMain.getFont().deriveFont(21.0f));	//title 사이즈조절
		titleMain.setText("    ************* 메인 메뉴 ************");
		
		//값 넣어주기					
		menuChicken= new JButton(" 치  킨 ");
		priceChicken = new JLabel("18000원     =====> ");
		selectChicken= new JButton("선택");
		selectChicken.putClientProperty("menu", "chicken");
		
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
		titleDrink.setFont(titleDrink.getFont().deriveFont(21.0f));	//title 사이즈조절
		
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
		titleSide.setFont(titleSide.getFont().deriveFont(21.0f));	//title 사이즈조절
		
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
	
			
		// ********************************************************
		
		jpTotal.add(jpTotalMain) ;
		jpTotal.add(jpTotalDrink) ;
		jpTotal.add(jpTotalSide) ;
		
		jpFooter.add(goBill, BorderLayout.CENTER);	//주문서보기로 이동 =3
		
		ca = this.getContentPane();	
	
		//container에 넣어주기
		ca.add(jpTotal, BorderLayout.CENTER);		
		ca.add(jpFooter, BorderLayout.SOUTH);	//앞으로,뒤로
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if ( e.getActionCommand().equals("로그인")) {
			this.setBounds(100, 100, 400, 750);         
			this.setVisible(true);
			lg.setVisible(false);

			System.out.println("핸드폰번호 : " + phoneNum.getText());
			System.out.println("비밀번호 : " + password.getText());
		}
		
		else if( e.getActionCommand().equals("비회원 주문")) {
			this.setBounds(100, 100, 400, 750);         
			this.setVisible(true);
			mb.setVisible(false);
		}

		else if(e.getActionCommand().equals("선택")) {
			JButton source = (JButton)e.getSource();
			String menu = (String)source.getClientProperty("menu");
			addMenu(menu);
			System.out.println("주문된 메뉴 : " +orderMenu );
		}

	}



}
