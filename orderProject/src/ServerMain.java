

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	Socket socket;	//server socket���� ���� ����
	
	ServerSocket server_socket;

	public void startServer(){
		try{
			server_socket = new ServerSocket(40000);
			System.out.println("���� ������ ���� �Ǿ����ϴ�.");

			while(true){
				socket=server_socket.accept();
				System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�");

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
