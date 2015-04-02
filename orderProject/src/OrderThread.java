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
		System.out.println("***********소켓*******************");
		System.out.println(socket);

		initNetwork();
	}

	// 서버에서 BufferedReader를 통해 값을 읽어들임.
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

			System.out.println("서버에서 읽은 파라미터 값!!!");
			System.out.println("테이블 번호 : "+table_number);
			System.out.println("메뉴1 이름 : " +menu1_Name);
			System.out.println("메뉴1 수량 : " +menu1_Qty);
			System.out.println("메뉴1 가격 : " +menu1_Price);
			System.out.println("메뉴2 이름: " +menu2_Name);
			System.out.println("메뉴2 수량 : " +menu2_Qty);
			System.out.println("메뉴2 수량 : " +menu2_Price);
			System.out.println("메뉴3 이름 : " +menu3_Name);
			System.out.println("메뉴3 수량 : " +menu3_Qty);
			System.out.println("메뉴3 가격  : " +menu3_Price);
			System.out.println("총 가격  : " +total_Price);
		
			pw.close();
			br.close();
			socket.close();

			this.DBConn();


		} catch (Exception e) {

			e.printStackTrace();
		}


	}

	public void DBConn() {

		System.out.println("디비시작");

		Connection con ;
		PreparedStatement psmtInsert1 ;	//order테이블에 insert 할때
		PreparedStatement psmtInsert2 ;	//table_order테이블에 insert 할때
		PreparedStatement psmtSelect ;	//select 할때
		PreparedStatement psmtUpdate ;	//update 할때
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

			if(!menu1_Name.equals("")) {				//menu1_Name에 값이 있으면
				psmtSelect.setString(1, menu1_Name);	//DB에 있는지 확인
				rs = psmtSelect.executeQuery() ;

				//table_orders에 insert
				psmtInsert2.setInt(1, table_number);
				psmtInsert2.setString(2, menu1_Name);
				psmtInsert2.setString(3, menu1_Price);
				psmtInsert2.setString(4, menu1_Qty);							
				result = psmtInsert2.executeUpdate() ;

				if(rs.next()){	//menu1_name이 DB에 있는경우  -> update
					psmtUpdate.setInt(1, Integer.parseInt(menu1_Qty));	//quentity=quentity+선택된갯수
					psmtUpdate.setString(2, menu1_Name);				//선택된 메뉴 이름	
					result = psmtUpdate.executeUpdate() ;					
					result = 0 ;
				}
				else {		//menu1_name이 DB에 없는 경우 -> insert
					psmtInsert1.setString(1, menu1_Name);
					psmtInsert1.setString(2, menu1_Price);
					psmtInsert1.setString(3, menu1_Qty);							
					result = psmtInsert1.executeUpdate() ;					
				}
			}

			if(!menu2_Name.equals("")) {		
				psmtSelect.setString(1, menu2_Name);	
				rs = psmtSelect.executeQuery() ;

				//table_orders에 insert
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

				//table_orders에 insert
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
