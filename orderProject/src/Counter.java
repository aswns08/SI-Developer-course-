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

	//테이블 넘버 버튼
	JButton table1, table2, table3, table4; 
	//테이블 당 계산이 되었는지 체크표시위해
	JButton b_check1, b_check2, b_check3, b_check4;

	public Counter(){
		//카운터 화면을 부름
		counter_design();

		//창 종료
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
				System.out.println("******orderedMenu****메뉴이름 :" +this.omenu_Name.get(i));
				System.out.println("******orderedMenu****수  량 : " +this.omenu_Qty.get(i));
				System.out.println("******orderedMenu****가  격  : " +this.omenu_Price.get(i));
			}
		}
	}

	public void counter_design() {

		//Container 객체 생성
		Container ca = this.getContentPane();
		JPanel all_panel = new JPanel();
		all_panel.setLayout(new GridLayout(2,2,2,2));
		ca.add(all_panel);

		//jp1~jp4까지 패널을 생성하고, all_panel위에 올려 GridLayout을 이용해서 jp1~jp4까지 정렬시킴

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

		//jp1에 jp1a를 올림
		JPanel jp1a= new JPanel();
		jp1.add(jp1a, BorderLayout.NORTH);   

		//버튼1 선언하고 panel위에 올림
		table1 = new JButton("T1");
		jp1a.add(table1,  BorderLayout.WEST);
		//계산 완료 버튼을 눌렀을 때, 주분서를 리셋시키는 버튼
		b_check1 = new JButton("계산 완료");
		jp1a.add(b_check1, BorderLayout.EAST);

		//jp1에 jp1b 올림
		JPanel jp1b = new JPanel();
		jp1.add(jp1b, BorderLayout.SOUTH);
		//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게

		//====table2=======  

		//jp2에 jp2a를 올림
		JPanel jp2a = new JPanel();
		jp2.add(jp2a, BorderLayout.NORTH);

		//버튼2 선언하고 pane2위에 올림
		table2 = new JButton("T2");
		jp2a.add(table2, BorderLayout.WEST);
		//계산 완료 버튼을 눌렀을 때, 주분서를 리셋시키는 버튼
		b_check2 = new JButton("계산 완료");
		jp2a.add(b_check2, BorderLayout.EAST);

		//jp2에 jp2b 올림
		JPanel jp2b = new JPanel();
		jp2.add(jp2b, BorderLayout.SOUTH);
		//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게

		//====table3=======   
		//jp3에 jp3a를 올림
		JPanel jp3a = new JPanel();
		jp3.add(jp3a,  BorderLayout.NORTH);

		//버튼3 선언하고 pane3위에 올림
		table3 = new JButton("T3");
		jp3a.add(table3, BorderLayout.WEST);
		//계산 완료 버튼을 눌렀을 때, 주분서를 리셋시키는 버튼
		b_check3 = new JButton("계산 완료");
		jp3a.add(b_check3, BorderLayout.EAST);

		//jp3에 jp3b 올림
		JPanel jp3b = new JPanel();
		jp3.add(jp3b, BorderLayout.SOUTH);
		//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게

		//====table4=======    

		//jp4에 jp4a를 올림
		JPanel jp4a = new JPanel();
		jp4.add(jp4a,  BorderLayout.NORTH);

		//버튼4 선언하고 panel위에 올림
		table4 = new JButton("T4");
		jp4a.add(table4,BorderLayout.WEST);
		//계산 완료 버튼을 눌렀을 때, 주분서를 리셋시키는 버튼
		b_check4 =new JButton("계산 완료");
		jp4a.add(b_check4, BorderLayout.EAST);

		//jp4에 jp4b 올림
		JPanel jp4b = new JPanel();
		jp4.add(jp4b, BorderLayout.SOUTH);
		//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게     

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

		System.out.println("디비시작2");

		Connection con ;
		PreparedStatement psmtSelect ;   //select 할때
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

		System.out.println("디비delete시작");

		Connection con ;
		PreparedStatement psmtDelete ;   //select 할때
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

			System.out.println(table_number + "테이블 delete");

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