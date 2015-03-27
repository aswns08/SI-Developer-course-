package multichat;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class ChatClient extends JFrame implements Runnable, ActionListener{
	private String nickname ; //닉네임
	private String servAddr; //서버 주소
	private int servPort; //서버 포트
	private boolean flag = false;
	private Socket socket; //클라이언트 소켓
	private BufferedReader br ; //입력 스트림
	private PrintWriter pw; //출력 스트림
	private JButton send;
	private JTextField tf1 = new JTextField(25);
	private JTextArea ta1 = new JTextArea();
	private Container ca;
	
	public ChatClient(String nickname, String servAddr, int servPort) throws IOException{
		this.nickname = nickname;
		this.servAddr = servAddr;
		this.servPort = servPort;
		this.initGraphics(); //그래픽작업과 이벤트 등록 초기화
		this.initNetwork(); //소켓 생성과 스트림 작업 초기화와 스레드 시작
		new Thread(this).start();
	}
	
	public void initGraphics(){		
		this.tf1.addActionListener(this);	//엔터치면 보내지도록하기위해 listener해줌
		send= new JButton("보내기");
		send.addActionListener(this);
		
		JPanel jp = new JPanel();
		jp.add(tf1);
		jp.add(send);
		
		ca = this.getContentPane();
		
		ca.add(jp, BorderLayout.SOUTH);
		ca.add(ta1,BorderLayout.CENTER);
		
		//익명클래스
		this.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					stop();
					System.exit(0);					
				}
				public void windowOpened(WindowEvent e){
					tf1.requestFocus();
				}
			}
		);
	}
	
	//소켓과 입출력 스트림 초기화
	public void initNetwork() throws IOException{
		this.socket = new Socket(servAddr, servPort);
		pw = new PrintWriter(socket.getOutputStream(),true);
		//BufferedWriter를 쓸 수 있지만, 그렇게쓰면 아래처럼쓴 후 flush()해줘야함 
		//-> 하지만 printWriter를쓰면 true매개변수를주면 flush()메소드없이도 문자열전송가능
		//pw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		//flush()
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//socket은 1byte씩읽어오는 inputStream밖에없음 -> 한글 다 깨짐 -> 한줄씨 읽는 bufferedReader를 쓰고싶음
		// -> 바꿔주기위해서 inputStreamReader를 써줌
		
		this.sendMessage("[" + nickname + "]:님이 입장했습니다.");
	}
	
	public void actionPerformed(ActionEvent e){
		String msg = tf1.getText();
		if(!msg.equals("")){
			this.sendMessage("[" + nickname + "]:" + msg);
			tf1.setText("");
		}
	}
	public void run(){
		try{
			while(!flag){
				System.out.println(flag);
				String msg = br.readLine();
				System.out.println("클라이언트 읽은거" +msg);
				if(msg != null && !msg.equals("")){
					this.ta1.append( msg +"\n");
				}else{
					flag = true;
				}
			}
			br.close();
			pw.close();
			socket.close();
		}catch(IOException e){
			System.out.println("chat 클라이언트 예외"+e.toString());
			}
	}
	
	public void stop(){
		this.sendMessage("[" + nickname + "]:님이 퇴장합니다.");
		this.flag = true;
	}
	
	public void sendMessage(String msg){
		try{
			System.out.println(msg);
			this.pw.println(msg);		
		}catch(Exception e){e.printStackTrace();}
	}
} 
