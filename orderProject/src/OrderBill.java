import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.sql.rowset.WebRowSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class OrderBill extends JFrame implements ActionListener{
	Menu omenu;
	int table_number = 2;

	//탑에는 테이블넘버, 주문서이름	
	//센터에는 메뉴, 수량, 가격의 네임패널과 메뉴리스트패널	  
	//메뉴 1,2,3은 일단은 고정자료로 메뉴 모양을 잡기 위해 만듬
	//바텀에는 총가격, 뒤로가기, 주문하기  
	JPanel top_panel, center_panel, bottom_panel;
	JPanel name_panel, list_panel, menu1_panel, menu2_panel, menu3_panel;
	JPanel price_panel, btn_panel;

	//메뉴, 수량, 가격, 주문서이름 
	JLabel menu, count, price;

	//테이블번호, 총 가격
	JTextArea table_num, sum_price;
	JTextField menu1_name, menu1_price, count1_num;
	JTextField menu2_name, menu2_price, count2_num;
	JTextField menu3_name, menu3_price, count3_num;

	//메뉴 수량 증감
	JButton plus1, minus1, plus2, minus2, plus3, minus3;
	JLabel price_label, o_Bill;

	//메뉴 뒤로가기, 주문하기
	JButton back, submit;

	public OrderBill(Menu omenu) {
		this.omenu = omenu;

		bill_design();


		//창 종료
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});
	}
	public void bill_design() {
		Container ca = this.getContentPane();

		//테이블 넘버
		table_num = new JTextArea("Table 1");
		table_num.setEditable(false); // 수정불가

		// 주문서이름
		o_Bill = new JLabel("주문서");

		top_panel = new JPanel();
		top_panel.add(table_num, BorderLayout.WEST);
		top_panel.add(o_Bill);

		ca.add(top_panel, BorderLayout.NORTH);

		//메뉴, 수량, 가격 포함
		menu = new JLabel("메뉴");
		count = new JLabel("수량");
		price = new JLabel("가격");

		name_panel = new JPanel();
		name_panel.add(menu);
		name_panel.add(count);
		name_panel.add(price);

		list_panel = new JPanel();
		list_panel.setLayout(new GridLayout(4,1));
		list_panel.add(name_panel);

		//메뉴 리스트

		//메뉴 1번째
		menu1_name = new JTextField(10);
		count1_num = new JTextField(2);
		menu1_price = new JTextField(10);

		menu1_panel = new JPanel();
		menu1_panel.add(menu1_name);
		menu1_panel.add(count1_num);
		menu1_panel.add(menu1_price);

		list_panel.add(menu1_panel);

		//메뉴 2번째
		menu2_name = new JTextField(10);
		count2_num = new JTextField(2);
		menu2_price = new JTextField(10);		

		menu2_panel = new JPanel();
		menu2_panel.add(menu2_name);
		menu2_panel.add(count2_num);
		menu2_panel.add(menu2_price);

		list_panel.add(menu2_panel);

		//메뉴 3번째
		menu3_name = new JTextField(10);
		count3_num = new JTextField(2);
		menu3_price = new JTextField(10);

		menu3_panel = new JPanel();
		menu3_panel.add(menu3_name);
		menu3_panel.add(count3_num);
		menu3_panel.add(menu3_price);

		list_panel.add(menu3_panel);

		center_panel = new JPanel();
		center_panel.add(list_panel);
		ca.add(center_panel, BorderLayout.CENTER);

		//총가격, 뒤로가기, 주문하기


		//총가격 출력
		price_label = new JLabel("총 가격 : ");
		sum_price = new JTextArea("");	//지금 입력된 값은 임의로 준 값
		sum_price.setEditable(false);		

		price_panel = new JPanel();
		price_panel.add(price_label);
		price_panel.add(sum_price);

		//버튼 구간
		submit = new JButton("주문하기");

		btn_panel = new JPanel();
		btn_panel.add(submit);		

		bottom_panel = new JPanel();
		bottom_panel.setLayout(new GridLayout(2,1));
		bottom_panel.add(price_panel);
		bottom_panel.add(btn_panel);

		ca.add(bottom_panel, BorderLayout.SOUTH);

		submit.addActionListener(this);

	}

	// ArrayList에 담은 메뉴를 메뉴판에 담는 메서드.
	public void order_Bill() {

		System.out.println("ArrayList의 size" +Menu.orderMenu.size());

		for(int i=0 ; i<Menu.orderMenu.size() ; i++) {
			//System.out.println(Menu.orderMenu.get(i));

			if(menu1_name.getText().equals("")) {
				switch(Menu.orderMenu.get(i)) {
				case "chicken" :
					menu1_name.setText("chicken");
					break;
				case "pizza" :
					menu1_name.setText("pizza");
					break;
				case "pasta" :
					menu1_name.setText("pasta");
					break;
				case "soju" :
					menu1_name.setText("soju");
					break;
				case "beer" :
					menu1_name.setText("beer");
					break;
				case "bernini" :
					menu1_name.setText("bernini");
					break;
				case "potato" :
					menu1_name.setText("potato");
					break;
				case "salad" :
					menu1_name.setText("salad");
					break;
				case "fruit" :
					menu1_name.setText("fruit");
					break;
				}

			} else if(menu2_name.getText().equals("")) {

				if(!menu1_name.getText().equals(Menu.orderMenu.get(i))) {

					switch(Menu.orderMenu.get(i)) {
					case "chicken" :
						menu2_name.setText("chicken");
						break;
					case "pizza" :
						menu2_name.setText("pizza");
						break;
					case "pasta" :
						menu2_name.setText("pasta");
						break;
					case "soju" :
						menu2_name.setText("soju");
						break;
					case "beer" :
						menu2_name.setText("beer");
						break;
					case "bernini" :
						menu2_name.setText("bernini");
						break;
					case "potato" :
						menu2_name.setText("potato");
						break;
					case "salad" :
						menu2_name.setText("salad");
						break;
					case "fruit" :
						menu2_name.setText("fruit");
						break;
					} // switch

				} // if

			} else if(menu3_name.getText().equals("")) {

				if( !menu1_name.getText().equals(Menu.orderMenu.get(i)) &&
						!menu2_name.getText().equals(Menu.orderMenu.get(i)) ) {

					switch(Menu.orderMenu.get(i)) {
					case "chicken" :
						menu3_name.setText("chicken");
						break;
					case "pizza" :
						menu3_name.setText("pizza");
						break;
					case "pasta" :
						menu3_name.setText("pasta");
						break;
					case "soju" :
						menu3_name.setText("soju");
						break;
					case "beer" :
						menu3_name.setText("beer");
						break;
					case "bernini" :
						menu3_name.setText("bernini");
						break;
					case "potato" :
						menu3_name.setText("potato");
						break;
					case "salad" :
						menu3_name.setText("salad");
						break;
					case "fruit" :
						menu3_name.setText("fruit");
						break;
					} // switch

				} // if

			} // else if

		} // for

	} // order_Bill()


	// 메뉴의 수량을 계산하는 메서드
	public void order_count() {

		int chicken=0, pizza=0, pasta=0, soju=0, beer=0, bernini=0, 
				potato=0, salad=0, fruit=0;

		for(int i=0 ; i<Menu.orderMenu.size() ; i++) {

			switch(Menu.orderMenu.get(i)) {

			case "chicken" :
				chicken++;
				break;
			case "pizza" :
				pizza++;
				break;
			case "pasta" :
				pasta++;
				break;
			case "soju" :
				soju++;
				break;
			case "beer" :
				beer++;
				break;
			case "bernini" :
				bernini++;
				break;
			case "potato" :
				potato++;
				break;
			case "salad" :
				salad++;
				break;
			case "fruit" :
				fruit++;
				break;
			} // switch
		} // for


		if(count1_num.getText().equals("")) {

			switch(menu1_name.getText()) {
			case "chicken" :
				count1_num.setText(Integer.toString(chicken));
				break;
			case "pizza" :
				count1_num.setText(Integer.toString(pizza));
				break;
			case "pasta" :
				count1_num.setText(Integer.toString(pasta));
				break;
			case "soju" :
				count1_num.setText(Integer.toString(soju));
				break;
			case "beer" :
				count1_num.setText(Integer.toString(beer));
				break;
			case "bernini" :
				count1_num.setText(Integer.toString(bernini));
				break;
			case "potato" :
				count1_num.setText(Integer.toString(potato));
				break;
			case "salad" :
				count1_num.setText(Integer.toString(salad));
				break;
			case "fruit" :
				count1_num.setText(Integer.toString(fruit));
				break;
			} //switch
		} // if
		if(count2_num.getText().equals("")) {

			switch(menu2_name.getText()) {
			case "chicken" :
				count2_num.setText(Integer.toString(chicken));
				break;
			case "pizza" :
				count2_num.setText(Integer.toString(pizza));
				break;
			case "pasta" :
				count2_num.setText(Integer.toString(pasta));
				break;
			case "soju" :
				count2_num.setText(Integer.toString(soju));
				break;
			case "beer" :
				count2_num.setText(Integer.toString(beer));
				break;
			case "bernini" :
				count2_num.setText(Integer.toString(bernini));
				break;
			case "potato" :
				count2_num.setText(Integer.toString(potato));
				break;
			case "salad" :
				count2_num.setText(Integer.toString(salad));
				break;
			case "fruit" :
				count2_num.setText(Integer.toString(fruit));
				break;
			} //switch
		} // if
		if(count3_num.getText().equals("")) {

			switch(menu3_name.getText()) {
			case "chicken" :
				count3_num.setText(Integer.toString(chicken));
				break;
			case "pizza" :
				count3_num.setText(Integer.toString(pizza));
				break;
			case "pasta" :
				count3_num.setText(Integer.toString(pasta));
				break;
			case "soju" :
				count3_num.setText(Integer.toString(soju));
				break;
			case "beer" :
				count3_num.setText(Integer.toString(beer));
				break;
			case "bernini" :
				count3_num.setText(Integer.toString(bernini));
				break;
			case "potato" :
				count3_num.setText(Integer.toString(potato));
				break;
			case "salad" :
				count3_num.setText(Integer.toString(salad));
				break;
			case "fruit" :
				count3_num.setText(Integer.toString(fruit));
				break;
			} //switch
		} // if

	} // order_count()

	//메뉴 가격을 구하는 메서드
	public void menu_sum() {
		int chicken, pizza, pasta, soju, beer, bernini, potato, salad, fruit;
		
		if(menu1_price.getText().equals("")) {
			
			switch(menu1_name.getText()) {
			case "chicken" :
				chicken=18000*Integer.parseInt(count1_num.getText());
				menu1_price.setText(Integer.toString(chicken));
				break;
			case "pizza" :
				pizza=23000*Integer.parseInt(count1_num.getText());
				menu1_price.setText(Integer.toString(pizza));
				break;
			case "pasta" :
				pasta=20000*Integer.parseInt(count1_num.getText());
				menu1_price.setText(Integer.toString(pasta));
				break;
			case "soju" :
				soju=3500*Integer.parseInt(count1_num.getText());
				menu1_price.setText(Integer.toString(soju));
				break;
			case "beer" :
				beer=4000*Integer.parseInt(count1_num.getText());
				menu1_price.setText(Integer.toString(beer));
				break;
			case "bernini" :
				bernini=7000*Integer.parseInt(count1_num.getText());
				menu1_price.setText(Integer.toString(bernini));
				break;
			case "potato" :
				potato=5000*Integer.parseInt(count1_num.getText());
				menu1_price.setText(Integer.toString(potato));
				break;
			case "salad" :
				salad=8000*Integer.parseInt(count1_num.getText());
				menu1_price.setText(Integer.toString(salad));
				break;
			case "fruit" :
				fruit=12000*Integer.parseInt(count1_num.getText());
				menu1_price.setText(Integer.toString(fruit));
				break;
			}	//switch menu1
		} // if menu1
		
		if(menu2_price.getText().equals("")) {
			
			switch(menu2_name.getText()) {
			case "chicken" :
				chicken=18000*Integer.parseInt(count2_num.getText());
				menu2_price.setText(Integer.toString(chicken));
				break;
			case "pizza" :
				pizza=23000*Integer.parseInt(count2_num.getText());
				menu2_price.setText(Integer.toString(pizza));
				break;
			case "pasta" :
				pasta=20000*Integer.parseInt(count2_num.getText());
				menu2_price.setText(Integer.toString(pasta));
				break;
			case "soju" :
				soju=3500*Integer.parseInt(count2_num.getText());
				menu2_price.setText(Integer.toString(soju));
				break;
			case "beer" :
				beer=4000*Integer.parseInt(count2_num.getText());
				menu2_price.setText(Integer.toString(beer));
				break;
			case "bernini" :
				bernini=7000*Integer.parseInt(count2_num.getText());
				menu2_price.setText(Integer.toString(bernini));
				break;
			case "potato" :
				potato=5000*Integer.parseInt(count2_num.getText());
				menu2_price.setText(Integer.toString(potato));
				break;
			case "salad" :
				salad=8000*Integer.parseInt(count2_num.getText());
				menu2_price.setText(Integer.toString(salad));
				break;
			case "fruit" :
				fruit=12000*Integer.parseInt(count2_num.getText());
				menu2_price.setText(Integer.toString(fruit));
				break;
			}	//switch menu2
		} // if menu2

		if(menu3_price.getText().equals("")) {
			
			switch(menu3_name.getText()) {
			case "chicken" :
				chicken=18000*Integer.parseInt(count3_num.getText());
				menu3_price.setText(Integer.toString(chicken));
				break;
			case "pizza" :
				pizza=23000*Integer.parseInt(count3_num.getText());
				menu3_price.setText(Integer.toString(pizza));
				break;
			case "pasta" :
				pasta=20000*Integer.parseInt(count3_num.getText());
				menu3_price.setText(Integer.toString(pasta));
				break;
			case "soju" :
				soju=3500*Integer.parseInt(count3_num.getText());
				menu3_price.setText(Integer.toString(soju));
				break;
			case "beer" :
				beer=4000*Integer.parseInt(count3_num.getText());
				menu3_price.setText(Integer.toString(beer));
				break;
			case "bernini" :
				bernini=7000*Integer.parseInt(count3_num.getText());
				menu3_price.setText(Integer.toString(bernini));
				break;
			case "potato" :
				potato=5000*Integer.parseInt(count3_num.getText());
				menu3_price.setText(Integer.toString(potato));
				break;
			case "salad" :
				salad=8000*Integer.parseInt(count3_num.getText());
				menu3_price.setText(Integer.toString(salad));
				break;
			case "fruit" :
				fruit=12000*Integer.parseInt(count3_num.getText());
				menu3_price.setText(Integer.toString(fruit));
				break;
			}	//switch menu3
		} // if menu3

	}	//sum()

	public void all_sum(){

		if(!menu2_price.getText().equals("")) {
			if(!menu3_price.getText().equals("")) {
				int sum=Integer.parseInt(menu1_price.getText())+Integer.parseInt(menu2_price.getText())+Integer.parseInt(menu3_price.getText());
				sum_price.setText(Integer.toString(sum));
				
			} else {
				
				int sum=Integer.parseInt(menu1_price.getText())+Integer.parseInt(menu2_price.getText());
				sum_price.setText(Integer.toString(sum));
			}

		} else {
			
			int sum=Integer.parseInt(menu1_price.getText());
			sum_price.setText(Integer.toString(sum));
		}


	}// all_sum

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("주문서보기")) {
			if(omenu.menu.equals("")) {   //아무 메뉴도 선택하지 않았을 경우
	            JOptionPane.showMessageDialog(this,  "메뉴를 선택하지 않았습니다", "메뉴", JOptionPane.ERROR_MESSAGE);
	         }
	         else {
	            this.setBounds(300, 300, 400, 300);
	            this.setVisible(true);
	            omenu.setVisible(false);

	            this.order_Bill();
	            this.order_count();
	            this.menu_sum();
	            this.all_sum();
	         }

		} else if(e.getActionCommand().equals("주문하기")) {
			this.setVisible(false);

			try {
				OrderClient oc = new OrderClient(table_number, menu1_name.getText(), count1_num.getText(), menu1_price.getText(),
						menu2_name.getText(), count2_num.getText(), menu2_price.getText(),
						menu3_name.getText(), count3_num.getText(), menu3_price.getText(), sum_price.getText());

			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}

	}

}
