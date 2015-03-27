import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideMenu extends JFrame implements ActionListener{
	
	DrinkMenu dm ;
	
	JLabel title;
	
	JButton menuPotato ;
	JButton selectPotato ;
	JLabel pricePotato ;
	
	JButton menuSalad ;
	JButton selectSalad ;
	JLabel priceSalad ;
	
	JButton menuFruit ;
	JButton selectFruit ;
	JLabel priceFruit ;
	
	JButton goBack;
	JButton goBill;	
	
	
	JPanel jpPotato;
	JPanel jpSalad ;
	JPanel jpFruit ;
	JPanel jpTotal;
	JPanel jpFooter;
	
	public SideMenu(DrinkMenu dm) {
		this.dm = dm ;
		
		design();		
	}
	
	
	public void design() {
		Container ct = this.getContentPane(); 
		
		title = new JLabel("       ************* ���̵� �޴�  ************");
		title.setFont(title.getFont().deriveFont(21.0f));	//title ����������
		
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
		
		goBack = new JButton("����������");
		goBill = new JButton("�ֹ�������");
		
		jpPotato = new JPanel();
		jpSalad = new JPanel();
		jpFruit = new JPanel();
		jpTotal = new JPanel();
		jpFooter = new JPanel();
		
		jpTotal.setLayout(new GridLayout(4, 1));
		
		jpPotato.add(menuPotato, BorderLayout.WEST);
		jpPotato.add(pricePotato, BorderLayout.CENTER);
		jpPotato.add(selectPotato, BorderLayout.EAST);
		
		jpSalad.add(menuSalad, BorderLayout.WEST);
		jpSalad.add(priceSalad, BorderLayout.CENTER);
		jpSalad.add(selectSalad, BorderLayout.EAST);
		
		jpFruit.add(menuFruit, BorderLayout.WEST);
		jpFruit.add(priceFruit, BorderLayout.CENTER);
		jpFruit.add(selectFruit, BorderLayout.EAST);
		
		jpTotal.add(jpPotato);
		jpTotal.add(jpSalad);
		jpTotal.add(jpFruit);
		
		jpFooter.add(goBack, BorderLayout.WEST);
		jpFooter.add(goBill, BorderLayout.EAST);
		
		ct.add(title, BorderLayout.NORTH);
		ct.add(jpTotal, BorderLayout.CENTER);
		ct.add(jpFooter, BorderLayout.SOUTH);
		
		selectPotato.addActionListener(this);
		selectSalad.addActionListener(this);
		selectFruit.addActionListener(this);
		
		//goBack.addActionListener(new DrinkMenu(this)) ;
		goBill.addActionListener(new Bill(this)) ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("����������")) {
			this.setBounds(100, 100, 400, 300);	
			this.setVisible(true);
			dm.setVisible(false);
		}
		else if(e.getActionCommand().equals("����")) {
			
			JButton source = (JButton)e.getSource();
			String menu = (String)source.getClientProperty("menu");
			MainMenu.addMenu(menu);
			System.out.println("�ֹ��� �޴� : " +MainMenu.orderMenu);
		}
		
		
	}
	
}

