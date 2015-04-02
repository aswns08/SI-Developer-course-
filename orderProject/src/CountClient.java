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
		System.out.println("ī���Ͱ� ������ ����Ǿ����ϴ�");
		
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
		
		System.out.println("--------------ī���Ϳ��� ���� �Ķ���� ��!!!");
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
		
	}
	
	

		
}
