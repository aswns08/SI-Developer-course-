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
import javax.swing.JPanel;


public class Counter extends JFrame implements ActionListener {

	ArrayList<String> omenu_Name = new ArrayList<String>();
	ArrayList<String> omenu_Qty = new ArrayList<String>();
	ArrayList<String> omenu_Price = new ArrayList<String>();   

	//���̺� �ѹ� ��ư
	JButton table1, table2, table3, table4; 
	//���̺� �� ����� �Ǿ����� üũǥ������
	JButton b_check1, b_check2, b_check3, b_check4;

	public Counter(){
		//ī���� ȭ���� �θ�
		counter_design();

		//â ����
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});
	}

	public void orderedMenu(String menu_Name, String menu_Qty, String menu_Price) {

		this.omenu_Name.add(menu_Name);
		this.omenu_Qty.add(menu_Qty);
		this.omenu_Price.add(menu_Price);

		for(int i=0 ; i<omenu_Name.size() ; i++) {

			if(i==omenu_Name.size()-1) {
				System.out.println(omenu_Name.size());

				System.out.println("******orderedMenu***********");
				System.out.println("******orderedMenu****�޴��̸� :" +this.omenu_Name.get(i));
				System.out.println("******orderedMenu****��  �� : " +this.omenu_Qty.get(i));
				System.out.println("******orderedMenu****��  ��  : " +this.omenu_Price.get(i));
			}
		}
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

		//====table2=======  

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

		//====table3=======   
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

		//====table4=======    

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

		table1.addActionListener(new CounterBill(this));
		table2.addActionListener(new CounterBill(this));
		table3.addActionListener(new CounterBill(this));
		table4.addActionListener(new CounterBill(this));

		b_check1.addActionListener(this);
		b_check2.addActionListener(this);
		b_check3.addActionListener(this);
		b_check4.addActionListener(this);
	}

	public void DBConn(int table_number) {

		System.out.println("������2");

		Connection con ;
		PreparedStatement psmtSelect ;   //select �Ҷ�
		ResultSet rs ;      
		int result ;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@203.237.154.131:1521:XE" ;

			con = DriverManager.getConnection(url, "human", "1234");         
			String sqlSelect =  "select * from table_orders where table_number = ?";
			psmtSelect = con.prepareStatement(sqlSelect);
			psmtSelect.setInt(1, table_number);  
			rs = psmtSelect.executeQuery() ;

			while(rs.next()) {
				String menu_Name = rs.getString("name") ;
				String menu_Qty = rs.getString("quentity") ;
				String menu_Price = rs.getString("price") ;

				this.orderedMenu(menu_Name, menu_Qty, menu_Price);         
			}

		}catch(Exception e) {
			e.printStackTrace();
		}   
	}

	public void DBDelete(int table_number) {

		System.out.println("���delete����");

		Connection con ;
		PreparedStatement psmtDelete ;   //select �Ҷ�
		ResultSet rs ;      
		int result ;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@203.237.154.131:1521:XE" ;

			con = DriverManager.getConnection(url, "human", "1234");         
			String sqlDelete =  "delete from table_orders where table_number = ?";
			psmtDelete = con.prepareStatement(sqlDelete);
			psmtDelete.setInt(1, table_number);  

			result = psmtDelete.executeUpdate() ;

			System.out.println(table_number + "���̺� delete");

		}catch(Exception e) {
			e.printStackTrace();
		}   

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==b_check1) {
			this.DBDelete(1);
			this.omenu_Name.clear();

		} else if (e.getSource()==b_check2) {
			this.DBDelete(2);
			this.omenu_Name.clear();

		} else if (e.getSource()==b_check3) {
			this.DBDelete(3);
			this.omenu_Name.clear();

		} else if (e.getSource()==b_check4) {
			this.DBDelete(4);
			this.omenu_Name.clear();

		}
	}

	public static void main(String[] args){

		Counter counter = new Counter();
		counter.setBounds(300,300,400,200);
		counter.setVisible(true);

	}

}