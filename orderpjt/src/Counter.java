import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Counter extends JFrame{

	//���̺� �ѹ� ��ư
	JButton table1, table2, table3, table4; 
	//���̺� �� �޴���ư ���� (ī���� ���� �ֹ����� �Ѿ�ߵǴϱ�)
	JButton t1_menu, t2_menu, t3_menu, t4_menu;
	//���̺� �� ����� �Ǿ����� üũǥ������
	JButton b_check1, b_check2, b_check3, b_check4;


	public Counter(){

		//ī���� ȭ���� �θ�
		counter_design();
	}

	public void counter_design() {



		//Container ��ü ����
		Container ca = this.getContentPane();
		JPanel all_panel = new JPanel();
		all_panel.setLayout(new GridLayout(2,2,2,2));
		ca.add(all_panel);
		
		//jp1~jp4���� �г��� �����ϰ�, all_panel���� �÷� GridLayout�� �̿��ؼ� jp1~jp4���� ���Ľ�Ŵ
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		all_panel.add(jp1);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		all_panel.add(jp2);

		JPanel jp3 = new JPanel();
		jp3.setLayout(new BorderLayout());
		all_panel.add(jp3);
		
		JPanel jp4 = new JPanel();
		jp4.setLayout(new BorderLayout());
		all_panel.add(jp4);
		
		

		//======table1=======


		//jp1�� jp1a�� �ø�
		JPanel jp1a= new JPanel();
		jp1.add(jp1a, BorderLayout.NORTH);	

		//��ư1 �����ϰ� panel���� �ø�
		table1 = new JButton("T1");
		jp1a.add(table1,  BorderLayout.WEST);
		//��� �Ϸ� ��ư�� ������ ��, �ֺм��� ���½�Ű�� ��ư
		b_check1 = new JButton("��� �Ϸ�");
		jp1a.add(b_check1, BorderLayout.EAST);

		//jp1�� jp1b �ø�
		JPanel jp1b = new JPanel();
		jp1.add(jp1b, BorderLayout.SOUTH);
		//�޴�Ȯ�� ��ư�� ������ ��, �ֹ����� �ҷ��� �޴��� Ȯ���� �� �ְ�
		t1_menu = new JButton("�޴� Ȯ��");
		jp1b.add(t1_menu, BorderLayout.CENTER);


		//====table2=======
		//table2		

		//jp2�� jp2a�� �ø�
		JPanel jp2a = new JPanel();
		jp2.add(jp2a, BorderLayout.NORTH);

		//��ư2 �����ϰ� pane2���� �ø�
		table2 = new JButton("T2");
		jp2a.add(table2, BorderLayout.WEST);
		//��� �Ϸ� ��ư�� ������ ��, �ֺм��� ���½�Ű�� ��ư
		b_check2 = new JButton("��� �Ϸ�");
		jp2a.add(b_check2, BorderLayout.EAST);

		//jp2�� jp2b �ø�
		JPanel jp2b = new JPanel();
		jp2.add(jp2b, BorderLayout.SOUTH);
		//�޴�Ȯ�� ��ư�� ������ ��, �ֹ����� �ҷ��� �޴��� Ȯ���� �� �ְ�
		t2_menu = new JButton("�޴� Ȯ��");
		jp2b.add(t2_menu, BorderLayout.CENTER);


		//====table3=======
		//table3		
		//jp3�� jp3a�� �ø�
		JPanel jp3a = new JPanel();
		jp3.add(jp3a,  BorderLayout.NORTH);

		//��ư3 �����ϰ� pane3���� �ø�
		table3 = new JButton("T3");
		jp3a.add(table3, BorderLayout.WEST);
		//��� �Ϸ� ��ư�� ������ ��, �ֺм��� ���½�Ű�� ��ư
		b_check3 = new JButton("��� �Ϸ�");
		jp3a.add(b_check3, BorderLayout.EAST);

		//jp3�� jp3b �ø�
		JPanel jp3b = new JPanel();
		jp3.add(jp3b, BorderLayout.SOUTH);
		//�޴�Ȯ�� ��ư�� ������ ��, �ֹ����� �ҷ��� �޴��� Ȯ���� �� �ְ�
		t3_menu = new JButton("�޴� Ȯ��");
		jp3b.add(t3_menu, BorderLayout.CENTER);		


		//====table4=======
		//table4		

		//jp4�� jp4a�� �ø�
		JPanel jp4a = new JPanel();
		jp4.add(jp4a,  BorderLayout.NORTH);

		//��ư4 �����ϰ� panel���� �ø�
		table4 = new JButton("T4");
		jp4a.add(table4,BorderLayout.WEST);
		//��� �Ϸ� ��ư�� ������ ��, �ֺм��� ���½�Ű�� ��ư
		b_check4 =new JButton("��� �Ϸ�");
		jp4a.add(b_check4, BorderLayout.EAST);

		//jp4�� jp4b �ø�
		JPanel jp4b = new JPanel();
		jp4.add(jp4b, BorderLayout.SOUTH);
		//�޴�Ȯ�� ��ư�� ������ ��, �ֹ����� �ҷ��� �޴��� Ȯ���� �� �ְ�
		t4_menu = new JButton("�޴� Ȯ��");
		jp4b.add(t4_menu, BorderLayout.CENTER);		



	}


	public static void main(String[] args){
		Counter a = new Counter();
		a.setBounds(300,300,400,400);
		a.setVisible(true);


	}

}
