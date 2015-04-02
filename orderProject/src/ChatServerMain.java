

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerMain {
	Socket socket;	//server socket에서 만든 소켓
	ServerSocket server_socket;
	static ChatControl cct = new ChatControl();

	public void startServer(){
		try{
			server_socket = new ServerSocket(20000);
			System.out.println("채팅 서버 소켓이 생성 되었습니다.");
			
			while(true){
				socket=server_socket.accept();
				ChatThread ct=new ChatThread(socket);
				cct.addChatThread(ct);
				ct.start();		
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatServerMain csm = new ChatServerMain();
		csm.startServer();		
	}

}
