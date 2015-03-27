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
	
	//��ư ����	
	//JTextField, JPasswordField ���� 
	private JTextField phoneNum ;
	private JPasswordField password ;
	
	//******************* ���θ޴� ********************	
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
	
	//******************* �ַ� ********************
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
	
	//******************* ���̵�޴� ********************
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

	//Login�� ȸ���� ���
	public Menu(Login lg, JTextField phoneNum, JPasswordField password) {
		this.phoneNum = phoneNum ;
		this.password = password ;	
		this.lg = lg ;
		
		this.design() ;	
		
		//â �ݱ�
		addWindowListener(new WindowAdapter() {	
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});
	}
	
	//Member���� ��ȸ���� ���
	public Menu(Member mb) { 
		this.mb = mb ;
		this.design() ;	

		//â �ݱ�
		addWindowListener(new WindowAdapter() {	
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});

	}
	
	// ���� �� �޴��� ArrayList�� ��� �޼���
	public static void addMenu(String menuName) {
		orderMenu.add(menuName);
	}
		
	public void design() {		
		
		jpTotal = new JPanel() ;
		goBill = new JButton("�ֹ�������");
	
		// ******************* ���θ޴� ********************		
		titleMain = new JLabel() ;
		titleMain.setFont(titleMain.getFont().deriveFont(21.0f));	//title ����������
		titleMain.setText("    ************* ���� �޴� ************");
		
		//�� �־��ֱ�					
		menuChicken= new JButton(" ġ  Ų ");
		priceChicken = new JLabel("18000��     =====> ");
		selectChicken= new JButton("����");
		selectChicken.putClientProperty("menu", "chicken");
		
		menuPizza= new JButton(" ��  �� ");
		pricePizza = new JLabel("23000��     =====> ");
		selectPizza= new JButton("����");
		selectPizza.putClientProperty("menu", "pizza");
		
		menuPasta= new JButton("�Ľ�Ÿ");
		pricePasta = new JLabel("20000��     =====> ");
		selectPasta= new JButton("����");
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
		
		//******************* �ַ� ********************
		titleDrink = new JLabel("     **************** �ַ�  ***************");
		titleDrink.setFont(titleDrink.getFont().deriveFont(21.0f));	//title ����������
		
		menuSoju = new JButton(" ��  �� ");
		priceSoju = new JLabel("3500��     =====> ");
		selectSoju = new JButton("����");
		selectSoju.putClientProperty("menu", "soju");
		
		menuBeer = new JButton(" ��  �� ");
		priceBeer = new JLabel("4000��     =====> ");
		selectBeer = new JButton("����");
		selectBeer.putClientProperty("menu", "beer");
		
		menuBernini = new JButton("���ϴ�");
		priceBernini = new JLabel("7000��     =====> ");
		selectBernini = new JButton("����");
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
		
		//******************* ���̵� �޴� ********************
		titleSide = new JLabel("       ************* ���̵� �޴�  ************");
		titleSide.setFont(titleSide.getFont().deriveFont(21.0f));	//title ����������
		
		menuPotato = new JButton("����Ĩ");
		pricePotato = new JLabel("5000��     =====> ");
		selectPotato = new JButton("����");
		selectPotato.putClientProperty("menu", "potato");
		
		menuSalad = new JButton("������");
		priceSalad = new JLabel("8000��     =====> ");
		selectSalad = new JButton("����");
		selectSalad.putClientProperty("menu", "salad");
		
		menuFruit = new JButton(" ��  �� ");;
		priceFruit = new JLabel("12000��     =====> ");
		selectFruit = new JButton("����");
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
		
		jpFooter.add(goBill, BorderLayout.CENTER);	//�ֹ�������� �̵� =3
		
		ca = this.getContentPane();	
	
		//container�� �־��ֱ�
		ca.add(jpTotal, BorderLayout.CENTER);		
		ca.add(jpFooter, BorderLayout.SOUTH);	//������,�ڷ�
		
		// ���θ޴��� ���� ��ư�� ������ �� �̺�Ʈ �߰�
		selectChicken.addActionListener(this);
		selectPizza.addActionListener(this);
		selectPasta.addActionListener(this);
		
		// �ַ��޴��� ���� ��ư�� ������ �� �̺�Ʈ �߰�
		selectSoju.addActionListener(this);
		selectBeer.addActionListener(this);
		selectBernini.addActionListener(this);
		
		// ���̵�޴��� ���� ��ư�� ������ �� �̺�Ʈ �߰�
		selectPotato.addActionListener(this);
		selectSalad.addActionListener(this);
		selectFruit.addActionListener(this);
		
		goBill.addActionListener(new OrderBill(this));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if ( e.getActionCommand().equals("�α���")) {
			this.setBounds(100, 100, 400, 750);         
			this.setVisible(true);
			lg.setVisible(false);

			System.out.println("�ڵ�����ȣ : " + phoneNum.getText());
			System.out.println("��й�ȣ : " + password.getText());
		}
		
		else if( e.getActionCommand().equals("��ȸ�� �ֹ�")) {
			this.setBounds(100, 100, 400, 750);         
			this.setVisible(true);
			mb.setVisible(false);
		}

		else if(e.getActionCommand().equals("����")) {
			JButton source = (JButton)e.getSource();
			String menu = (String)source.getClientProperty("menu");
			addMenu(menu);
			System.out.println("�ֹ��� �޴� : " +orderMenu );
		}

	}



}
