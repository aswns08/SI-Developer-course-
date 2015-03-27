package daejeon.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket ss ;
	private Socket inner_Socket ;
	private BufferedReader br ;
	private PrintWriter pw ;
	
	public void serverStart() throws Exception {
		ss = new ServerSocket(7777) ;
		
		System.out.println("���������� �����Ǿ����ϴ�");
		
		while(true) {
			System.out.println("Ŭ���̾�Ʈ�� ��ٸ��ϴ�");
			inner_Socket = ss.accept();
			System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�");
			getMessage(inner_Socket);
		}
	}
	
	public void getMessage(Socket so) throws Exception {
		br = new BufferedReader(new InputStreamReader(so.getInputStream())) ;
		pw = new PrintWriter(so.getOutputStream(), true) ;
		
		String temp = br.readLine();
		System.out.println("�����ʿ��� Ŭ���̾�Ʈ�κ��� ���� ���ڿ� ��� " + temp);
		
		if(br!=null) br.close() ;
		if(ss!=null) inner_Socket.close() ;	
	}
	
	public static void main(String[] args) throws Exception {
		Server se = new Server() ;
		se.serverStart();
	}
}
