import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Counter extends JFrame{

	//테이블 넘버 버튼
	JButton table1, table2, table3, table4; 
	//테이블 당 메뉴버튼 생성 (카운터 세부 주문서로 넘어가야되니까)
	JButton t1_menu, t2_menu, t3_menu, t4_menu;
	//테이블 당 계산이 되었는지 체크표시위해
	JButton b_check1, b_check2, b_check3, b_check4;


	public Counter(){

		//카운터 화면을 부름
		counter_design();
	}

	public void counter_design() {



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
		table1 = new JButton("T1");
		jp1a.add(table1,  BorderLayout.WEST);
		//계산 완료 버튼을 눌렀을 때, 주분서를 리셋시키는 버튼
		b_check1 = new JButton("계산 완료");
		jp1a.add(b_check1, BorderLayout.EAST);

		//jp1에 jp1b 올림
		JPanel jp1b = new JPanel();
		jp1.add(jp1b, BorderLayout.SOUTH);
		//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게
		t1_menu = new JButton("메뉴 확인");
		jp1b.add(t1_menu, BorderLayout.CENTER);


		//====table2=======
		//table2		

		//jp2에 jp2a를 올림
		JPanel jp2a = new JPanel();
		jp2.add(jp2a, BorderLayout.NORTH);

		//버튼2 선언하고 pane2위에 올림
		table2 = new JButton("T2");
		jp2a.add(table2, BorderLayout.WEST);
		//계산 완료 버튼을 눌렀을 때, 주분서를 리셋시키는 버튼
		b_check2 = new JButton("계산 완료");
		jp2a.add(b_check2, BorderLayout.EAST);

		//jp2에 jp2b 올림
		JPanel jp2b = new JPanel();
		jp2.add(jp2b, BorderLayout.SOUTH);
		//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게
		t2_menu = new JButton("메뉴 확인");
		jp2b.add(t2_menu, BorderLayout.CENTER);


		//====table3=======
		//table3		
		//jp3에 jp3a를 올림
		JPanel jp3a = new JPanel();
		jp3.add(jp3a,  BorderLayout.NORTH);

		//버튼3 선언하고 pane3위에 올림
		table3 = new JButton("T3");
		jp3a.add(table3, BorderLayout.WEST);
		//계산 완료 버튼을 눌렀을 때, 주분서를 리셋시키는 버튼
		b_check3 = new JButton("계산 완료");
		jp3a.add(b_check3, BorderLayout.EAST);

		//jp3에 jp3b 올림
		JPanel jp3b = new JPanel();
		jp3.add(jp3b, BorderLayout.SOUTH);
		//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게
		t3_menu = new JButton("메뉴 확인");
		jp3b.add(t3_menu, BorderLayout.CENTER);		


		//====table4=======
		//table4		

		//jp4에 jp4a를 올림
		JPanel jp4a = new JPanel();
		jp4.add(jp4a,  BorderLayout.NORTH);

		//버튼4 선언하고 panel위에 올림
		table4 = new JButton("T4");
		jp4a.add(table4,BorderLayout.WEST);
		//계산 완료 버튼을 눌렀을 때, 주분서를 리셋시키는 버튼
		b_check4 =new JButton("계산 완료");
		jp4a.add(b_check4, BorderLayout.EAST);

		//jp4에 jp4b 올림
		JPanel jp4b = new JPanel();
		jp4.add(jp4b, BorderLayout.SOUTH);
		//메뉴확인 버튼을 눌렀을 때, 주문서를 불러와 메뉴를 확인할 수 있게
		t4_menu = new JButton("메뉴 확인");
		jp4b.add(t4_menu, BorderLayout.CENTER);		



	}


	public static void main(String[] args){
		Counter a = new Counter();
		a.setBounds(300,300,400,400);
		a.setVisible(true);


	}

}
