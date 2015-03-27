import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class ChatSelect extends JFrame{

	//채팅테이블 넘버 버튼
		JButton ctable1, ctable2, ctable3, ctable4; 
		//체팅 테이블 당 접속버튼
		JButton connect1, connect2, connect3, connect4;
		//테이블에 손님이 있는지 없는지
		JTextField on_off1, on_off2, on_off3, on_off4;


		public ChatSelect(){

			//채팅 디자인 화면을 부름
			chat_design();
		}

		public void chat_design() {

			//Container 객체 생성
			Container ca = this.getContentPane();
			JPanel all_panel = new JPanel();
			all_panel.setLayout(new GridLayout(2,2,2,2));
			ca.add(all_panel);
			
			//jp1~jp4까지 패널을 생성하고, all_panel위에 올려 GridLayout을 이용해서 jp1~jp4까지 정렬시킴
			
			JPanel jp1 = new JPanel();
			jp1.setLayout(new BorderLayout());
			all_panel.add(jp1);

			JPanel jp2 = new JPanel();
			jp2.setLayout(new BorderLayout());
			all_panel.add(jp2);

			JPanel jp3 = new JPanel();
			jp3.setLayout(new BorderLayout());
			all_panel.add(jp3);
			
			JPanel jp4 = new JPanel();
			jp4.setLayout(new BorderLayout());
			all_panel.add(jp4);
			
			

			//======table1=======
			//jp1에 jp1a를 올림
			JPanel jp1a= new JPanel();
			jp1.add(jp1a, BorderLayout.NORTH);	

			//버튼1 선언하고 panel위에 올림
			ctable1 = new JButton("T1");
			jp1a.add(ctable1,  BorderLayout.WEST);
			//on/off 확인 표시 여부
			on_off1 = new JTextField("on/ff 표시");
			jp1a.add(on_off1, BorderLayout.EAST);

			//jp1에 jp1b 올림
			JPanel jp1b = new JPanel();
			jp1.add(jp1b, BorderLayout.SOUTH);
			//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게
			connect1 = new JButton("채팅 접속");
			jp1b.add(connect1, BorderLayout.CENTER);


			//====table2=======
			//table2		

			//jp2에 jp2a를 올림
			JPanel jp2a = new JPanel();
			jp2.add(jp2a, BorderLayout.NORTH);

			//버튼2 선언하고 pane2위에 올림
			ctable2 = new JButton("T2");
			jp2a.add(ctable2, BorderLayout.WEST);
			//on/off 확인 표시 여부
			on_off2 = new JTextField(5);
			jp2a.add(on_off2, BorderLayout.EAST);

			//jp2에 jp2b 올림
			JPanel jp2b = new JPanel();
			jp2.add(jp2b, BorderLayout.SOUTH);
			//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게
			connect2 = new JButton("채팅 접속");
			jp2b.add(connect2, BorderLayout.CENTER);


			//====table3=======
			//table3		
			//jp3에 jp3a를 올림
			JPanel jp3a = new JPanel();
			jp3.add(jp3a,  BorderLayout.NORTH);

			//버튼3 선언하고 pane3위에 올림
			ctable3 = new JButton("T3");
			jp3a.add(ctable3, BorderLayout.WEST);
			//on/off 확인 표시 여부
			on_off3 = new JTextField(5);
			jp3a.add(on_off3, BorderLayout.EAST);

			//jp3에 jp3b 올림
			JPanel jp3b = new JPanel();
			jp3.add(jp3b, BorderLayout.SOUTH);
			//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게
			connect3 = new JButton("채팅 접속");
			jp3b.add(connect3, BorderLayout.CENTER);		


			//====table4=======
			//table4		

			//jp4에 jp4a를 올림
			JPanel jp4a = new JPanel();
			jp4.add(jp4a,  BorderLayout.NORTH);

			//버튼4 선언하고 panel위에 올림
			ctable4 = new JButton("T4");
			jp4a.add(ctable4,BorderLayout.WEST);
			//on/off 확인 표시 여부
			on_off4 =new JTextField(5);
			jp4a.add(on_off4, BorderLayout.EAST);

			//jp4에 jp4b 올림
			JPanel jp4b = new JPanel();
			jp4.add(jp4b, BorderLayout.SOUTH);
			//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게
			connect4 = new JButton("채팅 접속");
			jp4b.add(connect4, BorderLayout.CENTER);		



		}
		

		public static void main(String[] args){
			ChatSelect a = new ChatSelect();
			a.setBounds(300,300,400,400);
			a.setVisible(true);


		}
	
	
	
	
	
}
