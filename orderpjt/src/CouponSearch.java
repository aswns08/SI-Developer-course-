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
	
	JButton search, using; //search = �˻���ư, using = ���� ��� ��ư
	JTextArea coupon_infor; // coupon_infor = ���� ��ȸ�� ���� ��ȣ �� ����
	JTextField num_search; // num_search = ���� ��ȣ ��ȸ �ؽ�Ʈ�ʵ�
	
	public void cs_design(){
		
		Container ca = this.getContentPane();
		JPanel jp = new JPanel();
		JPanel jp1= new JPanel();
		JPanel jp2= new JPanel();
		
		jp.setLayout(new BorderLayout());
		ca.add(jp);
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.SOUTH);
		
		//�˻� �Է� text field
		num_search = new JTextField(10);
		jp1.add(num_search, BorderLayout.WEST);
		
		//�˻���ư
		search = new JButton("�˻�");
		jp1.add(search, BorderLayout.EAST);
		
		//������ȸ�� �����ߴ� TextArea
		coupon_infor = new JTextArea(10,20);
		jp2.add(coupon_infor, BorderLayout.NORTH);
		coupon_infor.append("���� ���� ��ȸ ��� \n");
		coupon_infor.setCaretPosition(coupon_infor.getText().length());
		
		//���� ��� ��ư
		using = new JButton("�������");
		jp2.add(using, BorderLayout.SOUTH);
		
		
		
		
	}
	
	public static void main(String[] args){
		
		CouponSearch a = new CouponSearch();
		a.setBounds(300,300,400,400);
		a.setVisible(true);
		
	}
	
	
	
	
}
