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
		
		System.out.println("서버소켓이 생성되었습니다");
		
		while(true) {
			System.out.println("클라이언트를 기다립니다");
			inner_Socket = ss.accept();
			System.out.println("클라이언트와 연결되었습니다");
			getMessage(inner_Socket);
		}
	}
	
	public void getMessage(Socket so) throws Exception {
		br = new BufferedReader(new InputStreamReader(so.getInputStream())) ;
		pw = new PrintWriter(so.getOutputStream(), true) ;
		
		String temp = br.readLine();
		System.out.println("서버쪽에서 클라이언트로부터 받은 문자열 출력 " + temp);
		
		if(br!=null) br.close() ;
		if(ss!=null) inner_Socket.close() ;	
	}
	
	public static void main(String[] args) throws Exception {
		Server se = new Server() ;
		se.serverStart();
	}
}
