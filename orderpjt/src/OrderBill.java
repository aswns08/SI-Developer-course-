import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.sql.rowset.WebRowSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class OrderBill extends JFrame implements ActionListener{
	Menu omenu;

	//ž���� ���̺�ѹ�, �ֹ����̸�	
	//���Ϳ��� �޴�, ����, ������ �����гΰ� �޴�����Ʈ�г�	  
	//�޴� 1,2,3�� �ϴ��� �����ڷ�� �޴� ����� ��� ���� ����
	//���ҿ��� �Ѱ���, �ڷΰ���, �ֹ��ϱ�  
	JPanel top_panel, center_panel, bottom_panel;
	JPanel name_panel, list_panel, menu1_panel, menu2_panel, menu3_panel;
	JPanel price_panel, btn_panel;

	//�޴�, ����, ����, �ֹ����̸� 
	JLabel menu, count, price;

	//���̺��ȣ, �� ����
	JTextArea table_num, sum_price;
	JTextField menu1_name, menu1_price, count1_num;
	JTextField menu2_name, menu2_price, count2_num;
	JTextField menu3_name, menu3_price, count3_num;

	//�޴� ���� ����
	JButton plus1, minus1, plus2, minus2, plus3, minus3;
	JLabel price_label, o_Bill;

	//�޴� �ڷΰ���, �ֹ��ϱ�
	JButton back, submit;

	public OrderBill(Menu omenu) {
		this.omenu = omenu;

		bill_design();
		

		//â ����
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});
	}
	public void bill_design() {
		Container ca = this.getContentPane();

		//���̺� �ѹ�
		table_num = new JTextArea("Table 1");
		table_num.setEditable(false); // �����Ұ�

		// �ֹ����̸�
		o_Bill = new JLabel("�ֹ���");

		top_panel = new JPanel();
		top_panel.add(table_num, BorderLayout.WEST);
		top_panel.add(o_Bill);

		ca.add(top_panel, BorderLayout.NORTH);

		//�޴�, ����, ���� ����
		menu = new JLabel("�޴�");
		count = new JLabel("����");
		price = new JLabel("����");

		name_panel = new JPanel();
		name_panel.add(menu);
		name_panel.add(count);
		name_panel.add(price);
		
		list_panel = new JPanel();
		list_panel.setLayout(new GridLayout(4,1));
		list_panel.add(name_panel);

		//�޴� ����Ʈ

		//�޴� 1��°
		menu1_name = new JTextField(10);
		count1_num = new JTextField(2);
		menu1_price = new JTextField(10);

		menu1_panel = new JPanel();
		menu1_panel.add(menu1_name);
		menu1_panel.add(count1_num);
		menu1_panel.add(menu1_price);

		list_panel.add(menu1_panel);

		//�޴� 2��°
		menu2_name = new JTextField(10);
		count2_num = new JTextField(2);
		menu2_price = new JTextField(10);		

		menu2_panel = new JPanel();
		menu2_panel.add(menu2_name);
		menu2_panel.add(count2_num);
		menu2_panel.add(menu2_price);

		list_panel.add(menu2_panel);

		//�޴� 3��°
		menu3_name = new JTextField(10);
		count3_num = new JTextField(2);
		menu3_price = new JTextField(10);

		menu3_panel = new JPanel();
		menu3_panel.add(menu3_name);
		menu3_panel.add(count3_num);
		menu3_panel.add(menu3_price);

		list_panel.add(menu3_panel);

		center_panel = new JPanel();
		center_panel.add(list_panel);
		ca.add(center_panel, BorderLayout.CENTER);

		//�Ѱ���, �ڷΰ���, �ֹ��ϱ�
		

		//�Ѱ��� ���
		price_label = new JLabel("�� ���� : ");
		sum_price = new JTextArea("12000");	//���� �Էµ� ���� ���Ƿ� �� ��
		sum_price.setEditable(false);		
		
		price_panel = new JPanel();
		price_panel.add(price_label);
		price_panel.add(sum_price);

		//��ư ����
		submit = new JButton("�ֹ��ϱ�");
		
		btn_panel = new JPanel();
		btn_panel.add(submit);		

		bottom_panel = new JPanel();
		bottom_panel.setLayout(new GridLayout(2,1));
		bottom_panel.add(price_panel);
		bottom_panel.add(btn_panel);
		
		ca.add(bottom_panel, BorderLayout.SOUTH);

	}
	
	public void order_Bill() {
		
		System.out.println("ArrayList�� size" +Menu.orderMenu.size());
		
		for(int i=0 ; i<Menu.orderMenu.size() ; i++) {
			System.out.println(Menu.orderMenu.get(i));
			
			switch(Menu.orderMenu.get(i)) {
			case "chicken" :
				menu1_name.setText("chicken");
				break;
			case "pizza" :
				menu2_name.setText("pizza");
				break;
			case "pasta" :
				menu3_name.setText("pasta");
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("�ֹ�������")) {
			this.setBounds(300, 300, 400, 300);
			this.setVisible(true);
			omenu.setVisible(false);
			
			this.order_Bill();
			
		}

	}
}
