import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class ChatSelect extends JFrame{

	//ä�����̺� �ѹ� ��ư
		JButton ctable1, ctable2, ctable3, ctable4; 
		//ü�� ���̺� �� ���ӹ�ư
		JButton connect1, connect2, connect3, connect4;
		//���̺� �մ��� �ִ��� ������
		JTextField on_off1, on_off2, on_off3, on_off4;


		public ChatSelect(){

			//ä�� ������ ȭ���� �θ�
			chat_design();
		}

		public void chat_design() {

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
			ctable1 = new JButton("T1");
			jp1a.add(ctable1,  BorderLayout.WEST);
			//on/off Ȯ�� ǥ�� ����
			on_off1 = new JTextField("on/ff ǥ��");
			jp1a.add(on_off1, BorderLayout.EAST);

			//jp1�� jp1b �ø�
			JPanel jp1b = new JPanel();
			jp1.add(jp1b, BorderLayout.SOUTH);
			//�޴�Ȯ�� ��ư�� ������ ��, �ֹ����� �ҷ��� �޴��� Ȯ���� �� �ְ�
			connect1 = new JButton("ä�� ����");
			jp1b.add(connect1, BorderLayout.CENTER);


			//====table2=======
			//table2		

			//jp2�� jp2a�� �ø�
			JPanel jp2a = new JPanel();
			jp2.add(jp2a, BorderLayout.NORTH);

			//��ư2 �����ϰ� pane2���� �ø�
			ctable2 = new JButton("T2");
			jp2a.add(ctable2, BorderLayout.WEST);
			//on/off Ȯ�� ǥ�� ����
			on_off2 = new JTextField(5);
			jp2a.add(on_off2, BorderLayout.EAST);

			//jp2�� jp2b �ø�
			JPanel jp2b = new JPanel();
			jp2.add(jp2b, BorderLayout.SOUTH);
			//�޴�Ȯ�� ��ư�� ������ ��, �ֹ����� �ҷ��� �޴��� Ȯ���� �� �ְ�
			connect2 = new JButton("ä�� ����");
			jp2b.add(connect2, BorderLayout.CENTER);


			//====table3=======
			//table3		
			//jp3�� jp3a�� �ø�
			JPanel jp3a = new JPanel();
			jp3.add(jp3a,  BorderLayout.NORTH);

			//��ư3 �����ϰ� pane3���� �ø�
			ctable3 = new JButton("T3");
			jp3a.add(ctable3, BorderLayout.WEST);
			//on/off Ȯ�� ǥ�� ����
			on_off3 = new JTextField(5);
			jp3a.add(on_off3, BorderLayout.EAST);

			//jp3�� jp3b �ø�
			JPanel jp3b = new JPanel();
			jp3.add(jp3b, BorderLayout.SOUTH);
			//�޴�Ȯ�� ��ư�� ������ ��, �ֹ����� �ҷ��� �޴��� Ȯ���� �� �ְ�
			connect3 = new JButton("ä�� ����");
			jp3b.add(connect3, BorderLayout.CENTER);		


			//====table4=======
			//table4		

			//jp4�� jp4a�� �ø�
			JPanel jp4a = new JPanel();
			jp4.add(jp4a,  BorderLayout.NORTH);

			//��ư4 �����ϰ� panel���� �ø�
			ctable4 = new JButton("T4");
			jp4a.add(ctable4,BorderLayout.WEST);
			//on/off Ȯ�� ǥ�� ����
			on_off4 =new JTextField(5);
			jp4a.add(on_off4, BorderLayout.EAST);

			//jp4�� jp4b �ø�
			JPanel jp4b = new JPanel();
			jp4.add(jp4b, BorderLayout.SOUTH);
			//�޴�Ȯ�� ��ư�� ������ ��, �ֹ����� �ҷ��� �޴��� Ȯ���� �� �ְ�
			connect4 = new JButton("ä�� ����");
			jp4b.add(connect4, BorderLayout.CENTER);		



		}
		

		public static void main(String[] args){
			ChatSelect a = new ChatSelect();
			a.setBounds(300,300,400,400);
			a.setVisible(true);


		}
	
	
	
	
	
}
