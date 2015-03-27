package daejeon.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	BufferedReader br ;
	PrintWriter pw ;
	Socket client ;
	
	public Client() {
		connect() ;
	}
	
	public void connect() {
		try {
			System.out.println("�������� ������ �õ��մϴ�");
			client = new Socket("127.0.0.1", 7777) ;
			System.out.println("����Ǿ����ϴ�");
			
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(client.getOutputStream(), true);
			pw.println("*** ���帮�� ����� ***");		
		}catch(Exception e) {
			System.out.println("���� ����");
		}finally {
			try {
				if(client!=null) client.close() ;
			}catch(IOException ie){}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Client ci = new Client() ;
		
	}

}
