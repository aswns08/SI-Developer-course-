import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class CountClient {
	
	private String servAddr = "127.0.0.1";
	private int servPort = 40000;
	Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public CountClient() throws Exception {
		
		this.initNetwork();
	}
	
	public void initNetwork() throws Exception {
		
		this.socket = new Socket(servAddr, servPort);
		System.out.println("카운터가 서버와 연결되었습니다");
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream(), true);
		
		String menu1_Name = br.readLine();
		String menu1_Qty = br.readLine();
		String menu1_Price = br.readLine();
		String menu2_Name = br.readLine();
		String menu2_Qty = br.readLine();
		String menu2_Price = br.readLine();
		String menu3_Name = br.readLine();
		String menu3_Qty = br.readLine();
		String menu3_Price = br.readLine();
		String total_Price = br.readLine();
		
		System.out.println("--------------카운터에서 읽은 파라미터 값!!!");
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
		
	}
	
	

		
}
