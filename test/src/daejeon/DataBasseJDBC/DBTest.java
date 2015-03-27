package daejeon.DataBasseJDBC;

import java.sql.Connection;

public class DBTest {
	Connection con ;
	DBConnection dbconn ;
	
	public void select() {
		try {
			dbconn = DBConnection.getInstance() ;
			dbconn.select() ;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert() {
		try {
			dbconn = DBConnection.getInstance() ;
			dbconn.insert() ;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DirestDBConn dbcon = new DirestDBConn() ;
		dbcon.test();
		
		//DBTest dt = new DBTest() ;
	//	dt.insert();
	//	dt.select();
	}
	
}
