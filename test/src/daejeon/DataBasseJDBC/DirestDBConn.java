package daejeon.DataBasseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DirestDBConn {
	public void test() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver") ;
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; //0.0.1:자기컴퓨터를 가리킴 / 1521:port번호
			//접속
			Connection con = DriverManager.getConnection(url, "hr", "1234");
			//쿼리문 심기
			PreparedStatement pstmt = con.prepareStatement("select * from jobs");		
			//쿼리문 실행 (select문이므로 executeQuery()이용)
			ResultSet rs = pstmt.executeQuery() ;
			
			while(rs.next()) {
				System.out.print(rs.getString("job_id") + "  ");
				System.out.print(rs.getString("job_title") + "  ");
				System.out.print(rs.getInt("min_salary") + "  ");
				System.out.println(rs.getInt("max_salary") + "  ");
			}
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
