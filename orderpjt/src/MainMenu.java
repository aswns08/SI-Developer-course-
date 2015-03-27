

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
import javax.swing.SwingConstants;

public class MainMenu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	Login lg ;
	
	//JTextField, JPasswordField ���� 
	private JTextField phoneNum ;
	private JPasswordField password ;
	
	//��ư ����
	JLabel title ; 
	
	static ArrayList<String> orderMenu = new ArrayList<String>();
	
	private JButton menuChicken ;
	private JButton selectChicken ;
	private JLabel priceChicken ;
	
	private JButton menuPizza ;
	private JButton selectPizza ;
	private JLabel pricePizza ;
	
	private JButton menuPasta ;
	private JButton selectPasta ;
	private JLabel pricePasta ; 
	
	private JButton goNext ;
	
	JPanel jpChicken ;
	JPanel jpPizza ;
	JPanel jpPasta ;
	JPanel jpFooter ;
	JPanel jpTotal ;
	
	private Container ca;

	
	//public MainMenu(Login lg, String phoneNum, String password) {
	public MainMenu(Login lg, JTextField phoneNum, JPasswordField password) {
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
	
	public static void addMenu(String menuName) {
		orderMenu.add(menuName);
	}
		
	public void design() {		
	
		title = new JLabel() ;
		title.setFont(title.getFont().deriveFont(21.0f));	//title ����������
		
		title.setText("    ************* ���� �޴� ************");
		
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

	    goNext = new JButton("����������");
		
		jpChicken = new JPanel();
		jpPizza = new JPanel();
		jpPasta = new JPanel();
		jpTotal = new JPanel();
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
		
	    jpFooter.add(goNext, BorderLayout.EAST);
		
		jpTotal.setLayout(new GridLayout(5,1));
		jpTotal.add(jpChicken) ;
		jpTotal.add(jpPizza) ;
		jpTotal.add(jpPasta) ;	
		
		ca = this.getContentPane();	
	
		//container�� �־��ֱ�
		ca.add(title, BorderLayout.NORTH) ;
		ca.add(jpTotal, BorderLayout.CENTER);
		ca.add(jpFooter, BorderLayout.SOUTH);
		
		selectChicken.addActionListener(this);
		selectPizza.addActionListener(this);
		selectPasta.addActionListener(this);
		
		goNext.addActionListener(new DrinkMenu(this)) ;
		//goHome.addActionListener(new Member(this)) ;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		if ( e.getActionCommand().equals("�α���")) {
			this.setBounds(100, 100, 400, 300);			
			this.setVisible(true);
			lg.setVisible(false);
			
			System.out.println("�ڵ�����ȣ : " + phoneNum.getText());
			System.out.println("��й�ȣ : " + password.getText());
		}
		
		else if(e.getActionCommand().equals("����")) {
			JButton source = (JButton)e.getSource();
			String menu = (String)source.getClientProperty("menu");
			addMenu(menu);
			System.out.println("�ֹ��� �޴� : " +orderMenu );
		}
		
	}

}
