import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class OrderThread extends Thread {

	BufferedReader br;
	PrintWriter pw;
	Socket socket;

	int table_number;
	String menu1_Name ;
	String menu1_Qty ;
	String menu1_Price ;
	String menu2_Name ;
	String menu2_Qty ;
	String menu2_Price ; 
	String menu3_Name ;
	String menu3_Qty  ;
	String menu3_Price ; 
	String total_Price ;



	public OrderThread(Socket socket) {
		this.socket = socket;
		System.out.println("***********����*******************");
		System.out.println(socket);

		initNetwork();
	}

	// �������� BufferedReader�� ���� ���� �о����.
	public void initNetwork() {
		try{
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);

			table_number = Integer.parseInt(br.readLine());
			menu1_Name = br.readLine();
			menu1_Qty = br.readLine();
			menu1_Price = br.readLine();
			menu2_Name = br.readLine();
			menu2_Qty = br.readLine();
			menu2_Price = br.readLine();
			menu3_Name = br.readLine();
			menu3_Qty = br.readLine();
			menu3_Price = br.readLine();
			total_Price = br.readLine();

			System.out.println("�������� ���� �Ķ���� ��!!!");
			System.out.println("���̺� ��ȣ : "+table_number);
			System.out.println("�޴�1 �̸� : " +menu1_Name);
			System.out.println("�޴�1 ���� : " +menu1_Qty);
			System.out.println("�޴�1 ���� : " +menu1_Price);
			System.out.println("�޴�2 �̸�: " +menu2_Name);
			System.out.println("�޴�2 ���� : " +menu2_Qty);
			System.out.println("�޴�2 ���� : " +menu2_Price);
			System.out.println("�޴�3 �̸� : " +menu3_Name);
			System.out.println("�޴�3 ���� : " +menu3_Qty);
			System.out.println("�޴�3 ����  : " +menu3_Price);
			System.out.println("�� ����  : " +total_Price);
		
			pw.close();
			br.close();
			socket.close();

			this.DBConn();


		} catch (Exception e) {

			e.printStackTrace();
		}


	}

	public void DBConn() {

		System.out.println("������");

		Connection con ;
		PreparedStatement psmtInsert1 ;	//order���̺� insert �Ҷ�
		PreparedStatement psmtInsert2 ;	//table_order���̺� insert �Ҷ�
		PreparedStatement psmtSelect ;	//select �Ҷ�
		PreparedStatement psmtUpdate ;	//update �Ҷ�
		ResultSet rs ;		
		int result ;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@203.237.154.131:1521:XE" ;

			con = DriverManager.getConnection(url, "human", "1234");
			String sqlInsert = "insert into orders values (?,?,?)" ;
			String sqlSelect =  "select quentity  from orders where name = ?";
			String sqlUpdate = "update orders set quentity=quentity+? where name = ?" ;
			String sqlInsertTO = "insert into table_orders values (?,?,?,?)" ;

			psmtInsert1 = con.prepareStatement(sqlInsert);
			psmtInsert2 = con.prepareStatement(sqlInsertTO);
			psmtSelect = con.prepareStatement(sqlSelect);
			psmtUpdate = con.prepareStatement(sqlUpdate);

			if(!menu1_Name.equals("")) {				//menu1_Name�� ���� ������
				psmtSelect.setString(1, menu1_Name);	//DB�� �ִ��� Ȯ��
				rs = psmtSelect.executeQuery() ;

				//table_orders�� insert
				psmtInsert2.setInt(1, table_number);
				psmtInsert2.setString(2, menu1_Name);
				psmtInsert2.setString(3, menu1_Price);
				psmtInsert2.setString(4, menu1_Qty);							
				result = psmtInsert2.executeUpdate() ;

				if(rs.next()){	//menu1_name�� DB�� �ִ°��  -> update
					psmtUpdate.setInt(1, Integer.parseInt(menu1_Qty));	//quentity=quentity+���õȰ���
					psmtUpdate.setString(2, menu1_Name);				//���õ� �޴� �̸�	
					result = psmtUpdate.executeUpdate() ;					
					result = 0 ;
				}
				else {		//menu1_name�� DB�� ���� ��� -> insert
					psmtInsert1.setString(1, menu1_Name);
					psmtInsert1.setString(2, menu1_Price);
					psmtInsert1.setString(3, menu1_Qty);							
					result = psmtInsert1.executeUpdate() ;					
				}
			}

			if(!menu2_Name.equals("")) {		
				psmtSelect.setString(1, menu2_Name);	
				rs = psmtSelect.executeQuery() ;

				//table_orders�� insert
				psmtInsert2.setInt(1, table_number);
				psmtInsert2.setString(2, menu2_Name);
				psmtInsert2.setString(3, menu2_Price);
				psmtInsert2.setString(4, menu2_Qty);							
				result = psmtInsert2.executeUpdate() ;					

				if(rs.next()){	
					psmtUpdate.setInt(1, Integer.parseInt(menu2_Qty));
					psmtUpdate.setString(2, menu2_Name);					
					result = psmtUpdate.executeUpdate() ;					
					result = 0 ;
				}
				else {
					psmtInsert1.setString(1, menu2_Name);
					psmtInsert1.setString(2, menu2_Price);
					psmtInsert1.setString(3, menu2_Qty);			
					result = psmtInsert1.executeUpdate() ;					
				}
			}

			if(!menu3_Name.equals("")) {
				psmtSelect.setString(1, menu3_Name);	
				rs = psmtSelect.executeQuery() ;

				//table_orders�� insert
				psmtInsert2.setInt(1, table_number);
				psmtInsert2.setString(2, menu3_Name);
				psmtInsert2.setString(3, menu3_Price);
				psmtInsert2.setString(4, menu3_Qty);							
				result = psmtInsert2.executeUpdate() ;

				if(rs.next()){
					psmtUpdate.setInt(1, Integer.parseInt(menu3_Qty));
					psmtUpdate.setString(2, menu3_Name);					
					result = psmtUpdate.executeUpdate() ;
					result = 0 ;
				}
				else {
					psmtInsert1.setString(1, menu3_Name);
					psmtInsert1.setString(2, menu3_Price);
					psmtInsert1.setString(3, menu3_Qty);			
					result = psmtInsert1.executeUpdate() ;					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
