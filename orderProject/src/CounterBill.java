
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CounterBill extends JFrame implements ActionListener{

	Counter ct;
	OrderBill ob;

	//탑에는 테이블넘버, 주문서이름   
	//센터에는 메뉴, 수량, 가격의 네임패널과 메뉴리스트패널     
	//메뉴 1,2,3은 일단은 고정자료로 메뉴 모양을 잡기 위해 만듬
	//바텀에는 총가격, 뒤로가기, 주문하기  
	JPanel top_panel, center_panel, bottom_panel;
	JPanel name_panel, list_panel, menu1_panel, menu2_panel, menu3_panel;
	JPanel price_panel, btn_panel;
	//메뉴, 수량, 가격, 주문서이름 
	JButton menu, count, price, name;
	//테이블번호, 총 가격
	JTextField  sum_price;
	JTextField menu1_name, menu1_price, count1_num;
	//JTextField menu1_name = new JTextField(10), menu1_price = new JTextField(10), count1_num = new JTextField(2);
	JTextField menu2_name, menu2_price, count2_num;
	JTextField menu3_name, menu3_price, count3_num;
	JLabel price_label;
	//메뉴 뒤로가기, 주문하기
	JButton member_num, submit;

	public CounterBill(Counter ct) {

		this.ct=ct;
		this.bill_design();

		//창 종료
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});

	}

	public void setOrder() {

		switch(ct.omenu_Name.size()) {
		case 1 :
			menu1_name.setText(ct.omenu_Name.get(0));
			menu1_price.setText(ct.omenu_Price.get(0));
			count1_num.setText(ct.omenu_Qty.get(0));
			break;
		case 2 :
			menu1_name.setText(ct.omenu_Name.get(0));
			menu1_price.setText(ct.omenu_Price.get(0));
			count1_num.setText(ct.omenu_Qty.get(0));

			menu2_name.setText(ct.omenu_Name.get(1));
			menu2_price.setText(ct.omenu_Price.get(1));
			count2_num.setText(ct.omenu_Qty.get(1));
			break;
		case 3 :
			menu1_name.setText(ct.omenu_Name.get(0));
			menu1_price.setText(ct.omenu_Price.get(0));
			count1_num.setText(ct.omenu_Qty.get(0));

			menu2_name.setText(ct.omenu_Name.get(1));
			menu2_price.setText(ct.omenu_Price.get(1));
			count2_num.setText(ct.omenu_Qty.get(1));

			menu3_name.setText(ct.omenu_Name.get(2));
			menu3_price.setText(ct.omenu_Price.get(2));
			count3_num.setText(ct.omenu_Qty.get(2));
			break;

		default :
			menu1_name.setText("");
			menu1_price.setText("");
			count1_num.setText("");

			menu2_name.setText("");
			menu2_price.setText("");
			count2_num.setText("");

			menu3_name.setText("");
			menu3_price.setText("");
			count3_num.setText("");
			break ;

		}
		if(!menu1_price.getText().equals("")) {
			if(!menu2_price.getText().equals("")) {
				if(!menu3_price.getText().equals("")) {
					int total_Price = Integer.parseInt(menu1_price.getText())
							+ Integer.parseInt(menu2_price.getText())
							+ Integer.parseInt(menu3_price.getText());

					sum_price.setText(Integer.toString(total_Price));

				} else {
					int total_Price = Integer.parseInt(menu1_price.getText())
							+ Integer.parseInt(menu2_price.getText());

					sum_price.setText(Integer.toString(total_Price));
				}
			} else {
				int total_Price = Integer.parseInt(menu1_price.getText());

				sum_price.setText(Integer.toString(total_Price));
			}         

		}else {
			sum_price.setText("0");
		}
	}

	public void bill_design() {

		Container con = this.getContentPane();

		//테이블 넘버, 주문서이름 포함
		top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		con.add(top_panel, BorderLayout.NORTH);      
		name = new JButton("주문서");
		top_panel.add(name, BorderLayout.CENTER);

		center_panel = new JPanel();
		con.add(center_panel, BorderLayout.CENTER);
		//메뉴, 수량, 가격 포함
		name_panel = new JPanel();
		center_panel.add(name_panel);
		menu = new JButton("메뉴");
		count = new JButton("수량");
		price = new JButton("가격");
		name_panel.add(menu);
		name_panel.add(count);
		name_panel.add(price);
		//메뉴 리스트 포함
		list_panel = new JPanel();
		center_panel.add(list_panel);
		list_panel.setLayout(new GridLayout(3,1));
		//메뉴 1번째
		menu1_panel = new JPanel();
		list_panel.add(menu1_panel);
		menu1_name = new JTextField(10);
		count1_num = new JTextField(2);
		menu1_price = new JTextField(10);

		menu1_panel.add(menu1_name);
		menu1_panel.add(count1_num);
		menu1_panel.add(menu1_price);

		//메뉴 2번째
		menu2_panel = new JPanel();
		list_panel.add(menu2_panel);
		menu2_name = new JTextField(10);
		count2_num = new JTextField(2);
		menu2_price = new JTextField(10);   

		menu2_panel.add(menu2_name);
		menu2_panel.add(count2_num);
		menu2_panel.add(menu2_price);

		//메뉴 3번째
		menu3_panel = new JPanel();
		list_panel.add(menu3_panel);
		menu3_name = new JTextField(10);
		count3_num = new JTextField(2);
		menu3_price = new JTextField(10);

		menu3_panel.add(menu3_name);
		menu3_panel.add(count3_num);
		menu3_panel.add(menu3_price);

		//총가격, 뒤로가기, 주문하기
		bottom_panel = new JPanel();
		//      con.add(bottom_panel);
		con.add(bottom_panel, BorderLayout.SOUTH);
		bottom_panel.setLayout(new GridLayout(2,1));
		//총가격 출력
		price_panel = new JPanel();
		bottom_panel.add(price_panel);
		price_label = new JLabel("총 가격 : ");
		sum_price = new JTextField(10);   //지금 입력된 값은 임의로 준값
		sum_price.setEditable(false);      
		price_panel.add(price_label);
		price_panel.add(sum_price);
		//버튼 구간
		btn_panel = new JPanel();
		bottom_panel.add(btn_panel);
		submit = new JButton("확인");
		btn_panel.add(submit);

		submit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getActionCommand().equals("T1")) {

			ct.DBConn(1);
			this.setBounds(300,300,400,400);
			this.setVisible(true);
			this.setTitle("테이블 1 주문서보기");
			this.setOrder();

		} else if( e.getActionCommand().equals("T2")) {

			ct.DBConn(2);
			this.setBounds(300,300,400,400);
			this.setVisible(true);
			this.setTitle("테이블 2 주문서보기");
			this.setOrder();

		} else if( e.getActionCommand().equals("T3")) {

			ct.DBConn(3);
			this.setBounds(300,300,400,400);
			this.setVisible(true);
			this.setTitle("테이블 3 주문서보기");
			this.setOrder();

		} else if( e.getActionCommand().equals("T4")) {

			ct.DBConn(4);
			this.setBounds(300,300,400,400);
			this.setVisible(true);
			this.setTitle("테이블 4 주문서보기");
			this.setOrder();

		} else if( e.getActionCommand().equals("확인")) {
			this.setVisible(false);

		} 

	}   

}