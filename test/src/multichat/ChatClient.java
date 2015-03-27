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
	private String nickname ; //�г���
	private String servAddr; //���� �ּ�
	private int servPort; //���� ��Ʈ
	private boolean flag = false;
	private Socket socket; //Ŭ���̾�Ʈ ����
	private BufferedReader br ; //�Է� ��Ʈ��
	private PrintWriter pw; //��� ��Ʈ��
	private JButton send;
	private JTextField tf1 = new JTextField(25);
	private JTextArea ta1 = new JTextArea();
	private Container ca;
	
	public ChatClient(String nickname, String servAddr, int servPort) throws IOException{
		this.nickname = nickname;
		this.servAddr = servAddr;
		this.servPort = servPort;
		this.initGraphics(); //�׷����۾��� �̺�Ʈ ��� �ʱ�ȭ
		this.initNetwork(); //���� ������ ��Ʈ�� �۾� �ʱ�ȭ�� ������ ����
		new Thread(this).start();
	}
	
	public void initGraphics(){		
		this.tf1.addActionListener(this);	//����ġ�� �����������ϱ����� listener����
		send= new JButton("������");
		send.addActionListener(this);
		
		JPanel jp = new JPanel();
		jp.add(tf1);
		jp.add(send);
		
		ca = this.getContentPane();
		
		ca.add(jp, BorderLayout.SOUTH);
		ca.add(ta1,BorderLayout.CENTER);
		
		//�͸�Ŭ����
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
	
	//���ϰ� ����� ��Ʈ�� �ʱ�ȭ
	public void initNetwork() throws IOException{
		this.socket = new Socket(servAddr, servPort);
		pw = new PrintWriter(socket.getOutputStream(),true);
		//BufferedWriter�� �� �� ������, �׷��Ծ��� �Ʒ�ó���� �� flush()������� 
		//-> ������ printWriter������ true�Ű��������ָ� flush()�޼ҵ���̵� ���ڿ����۰���
		//pw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		//flush()
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//socket�� 1byte���о���� inputStream�ۿ����� -> �ѱ� �� ���� -> ���پ� �д� bufferedReader�� �������
		// -> �ٲ��ֱ����ؼ� inputStreamReader�� ����
		
		this.sendMessage("[" + nickname + "]:���� �����߽��ϴ�.");
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
				System.out.println("Ŭ���̾�Ʈ ������" +msg);
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
			System.out.println("chat Ŭ���̾�Ʈ ����"+e.toString());
			}
	}
	
	public void stop(){
		this.sendMessage("[" + nickname + "]:���� �����մϴ�.");
		this.flag = true;
	}
	
	public void sendMessage(String msg){
		try{
			System.out.println(msg);
			this.pw.println(msg);		
		}catch(Exception e){e.printStackTrace();}
	}
} 
