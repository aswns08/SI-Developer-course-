import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrderMain extends JFrame implements ActionListener {

	JButton order;
	JButton chat;
	JPanel jp;

	public OrderMain() {

		design();
	}

	public void design()  {

		Container ct = this.getContentPane(); 

		order = new JButton("주 문");
		chat = new JButton("채 팅");
		jp = new JPanel();

		jp.setLayout(new GridLayout(1, 2));

		jp.add(order, BorderLayout.WEST);
		jp.add(chat, BorderLayout.EAST);

		ct.add(jp, BorderLayout.CENTER);

		order.addActionListener(new Member(this));
		chat.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String tableNumber = "2번 테이블";
		try {
			ChatClient cc = new ChatClient(tableNumber,"127.0.0.1", 20000);
			cc.setBounds(200, 300, 400, 400);
			cc.setVisible(true);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {

		OrderMain ordermain = new OrderMain();

		ordermain.setBounds(300, 300, 400, 300);
		ordermain.setVisible(true);

	}

}
