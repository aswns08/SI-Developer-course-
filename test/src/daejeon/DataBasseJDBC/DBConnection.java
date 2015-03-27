package daejeon.DataBasseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//�̱������� ��ü ����
public class DBConnection {
	Connection con ;
	
	private static DBConnection dc = new DBConnection() ;	
	//dc�� �޸𸮿� �ѹ��� �÷��� �����Ͽ� ����ϱ����� static���� ���� => singletone
	
	private DBConnection() { //�ܺο��� new�� �޸𸮿� �ø��� ���ϰ��ϱ����� �����ڸ� private������
	}
	
	public static DBConnection getInstance() {
		return dc ;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver") ;
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; //0.0.1:�ڱ���ǻ�͸� ����Ŵ / 1521:port��ȣ
			con = DriverManager.getConnection(url, "hr", "1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con ;
	}
	
	public void select() throws Exception {
		con = this.getConnection() ;
		PreparedStatement pstmt = con.prepareStatement("select * from jobs");
		ResultSet rs = pstmt.executeQuery() ;
		
		while(rs.next()){
			System.out.print(rs.getString("job_id") + "  ");
			System.out.print(rs.getString("job_title") + "  ");
			System.out.print(rs.getInt("min_salary") + "  ");
			System.out.println(rs.getInt("max_salary") + "  ");	
		}
		rs.close();
		pstmt.close();
		con.close();
	}
	
	public void insert() throws Exception {
		con = this.getConnection() ;
		PreparedStatement pstmt = con.prepareStatement("insert into jobs values(?,?,?,?)");
		
		pstmt.setString(1, "human");
		pstmt.setString(2, "instructor");
		pstmt.setInt(3, 5000);
		pstmt.setInt(4, 10000);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	
	
	
	
}