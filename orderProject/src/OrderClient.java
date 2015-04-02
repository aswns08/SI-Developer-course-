import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;


public class OrderClient extends Thread {
	
	private int table_number;
	// 첫 번째 메뉴
	private String menu1_Name;
	private String menu1_Qty;
	private String menu1_Price;
	// 두 번째 메뉴
	private String menu2_Name;
	private String menu2_Qty;
	private String menu2_Price;
	// 세 번째 메뉴
	private String menu3_Name;
	private String menu3_Qty;
	private String menu3_Price;
	
	private String total_Price;

	private String servAddr = "127.0.0.1";
	private int servPort = 40000;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	//	private boolean flag = false;



	public OrderClient(int table_number, String menu1_Name, String menu1_Qty, String menu1_Price,
			String menu2_Name, String menu2_Qty, String menu2_Price,
			String menu3_Name, String menu3_Qty, String menu3_Price, String total_Price) 
					throws Exception {

		this.table_number = table_number;
		this.menu1_Name = menu1_Name;
		this.menu1_Qty = menu1_Qty;
		this.menu1_Price = menu1_Price;
		this.menu2_Name = menu2_Name;
		this.menu2_Qty = menu2_Qty;
		this.menu2_Price = menu2_Price;
		this.menu3_Name = menu3_Name;
		this.menu3_Qty = menu3_Qty;
		this.menu3_Price = menu3_Price;
		this.total_Price = total_Price;
		
		this.initNetwork();
	}


	public void initNetwork() throws Exception {
		this.socket = new Socket(servAddr, servPort);
		System.out.println("클라이언트가 서버와 연결되었습니다.");

		br = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream(), true);

		System.out.println("테이블 번호 : " +table_number);
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
		
		this.sendOrder(table_number, menu1_Name, menu1_Qty, menu1_Price, 
				menu2_Name, menu2_Qty, menu2_Price,
				menu3_Name, menu3_Qty, menu3_Price, total_Price);
		
		pw.close();
		br.close();
		socket.close();
	}

	
	public void sendOrder(int table_number, String menu1_Name, String menu1_Qty, String menu1_Price,
			String menu2_Name, String menu2_Qty, String menu2_Price,
			String menu3_Name, String menu3_Qty, String menu3_Price, String total_Price) {
		
		pw.println(table_number);
		pw.println(menu1_Name);
		pw.println(menu1_Qty);
		pw.println(menu1_Price);
		pw.println(menu2_Name);
		pw.println(menu2_Qty);
		pw.println(menu2_Price);
		pw.println(menu3_Name);
		pw.println(menu3_Qty);
		pw.println(menu3_Price);
		pw.println(total_Price);
		
		
	}
}
