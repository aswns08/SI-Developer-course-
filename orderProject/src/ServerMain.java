

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	Socket socket;	//server socket에서 만든 소켓
	
	ServerSocket server_socket;

	public void startServer(){
		try{
			server_socket = new ServerSocket(40000);
			System.out.println("서버 소켓이 생성 되었습니다.");

			while(true){
				socket=server_socket.accept();
				System.out.println("클라이언트와 연결되었습니다");

				OrderThread ot = new OrderThread(socket);
				ot.start();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerMain csm = new ServerMain();
		csm.startServer();
	}

}
