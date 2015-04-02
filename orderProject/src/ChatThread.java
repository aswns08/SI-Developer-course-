

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatThread extends Thread {
	BufferedReader br;
	PrintWriter pw;
	Socket socket;
	boolean flag = false;
	
	public ChatThread(Socket socket){
		this.socket = socket;
		initNetwork();
	}
	//스트림생성
	public void initNetwork(){
		try{
			br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw= new PrintWriter(socket.getOutputStream(), true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//run 오버라이드
	@Override
	public void run() {
		try{
			while(!flag){
				String msg=br.readLine();
				if(msg!=null && !msg.equals("")){
					ChatServerMain.cct.sendAllmessage(msg);
					if(msg.endsWith("]:님이 퇴장합니다")){						
						ChatServerMain.cct.removeChatThread(this);
						flag=true;
					}
				}else{
					//클라이언트에서 예외가 올경우 -> 연결끊어줌
					ChatServerMain.cct.removeChatThread(this);
					flag = true;					
				}			
			}
			br.close();
			pw.close();
			socket.close();
		}catch(Exception e){
			ChatServerMain.cct.removeChatThread(this);
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				if(socket != null) socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}	
	
	public void sendMessage(String msg){
		pw.println(msg);
	}
	
	public String toString(){
		return socket.toString();
	}


}
