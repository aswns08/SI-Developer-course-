import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CouponSearch  extends JFrame{

	public CouponSearch(){
		
		cs_design();
		
	}
	
	JButton search, using; //search = 검색버튼, using = 쿠폰 사용 버튼
	JTextArea coupon_infor; // coupon_infor = 쿠폰 조회시 쿠폰 번호 및 정보
	JTextField num_search; // num_search = 쿠폰 번호 조회 텍스트필드
	
	public void cs_design(){
		
		Container ca = this.getContentPane();
		JPanel jp = new JPanel();
		JPanel jp1= new JPanel();
		JPanel jp2= new JPanel();
		
		jp.setLayout(new BorderLayout());
		ca.add(jp);
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.SOUTH);
		
		//검색 입력 text field
		num_search = new JTextField(10);
		jp1.add(num_search, BorderLayout.WEST);
		
		//검색버튼
		search = new JButton("검색");
		jp1.add(search, BorderLayout.EAST);
		
		//쿠폰조회시 정보뜨는 TextArea
		coupon_infor = new JTextArea(10,20);
		jp2.add(coupon_infor, BorderLayout.NORTH);
		coupon_infor.append("쿠폰 내용 조회 결과 \n");
		coupon_infor.setCaretPosition(coupon_infor.getText().length());
		
		//쿠폰 사용 버튼
		using = new JButton("쿠폰사용");
		jp2.add(using, BorderLayout.SOUTH);
		
		
		
		
	}
	
	public static void main(String[] args){
		
		CouponSearch a = new CouponSearch();
		a.setBounds(300,300,400,400);
		a.setVisible(true);
		
	}
	
	
	
	
}
