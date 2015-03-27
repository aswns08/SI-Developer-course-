import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrderMain extends JFrame {

	JButton order;
	JButton chat;
	JPanel jp;
	
	public OrderMain() {
		
		design();
	}
	
	public void design() {
		
		Container ct = this.getContentPane(); 
		
		order = new JButton("주 문");
		chat = new JButton("채 팅");
		jp = new JPanel();
		
		jp.setLayout(new GridLayout(1, 2));
		
		jp.add(order, BorderLayout.WEST);
		jp.add(chat, BorderLayout.EAST);
		
		ct.add(jp, BorderLayout.CENTER);
		
		order.addActionListener(new Member(this));
		
	}
	
	public static void main(String[] args) {
		
		OrderMain ordermain = new OrderMain();
		
		ordermain.setBounds(300, 300, 300, 300);
		ordermain.setVisible(true);
		
	}

}
