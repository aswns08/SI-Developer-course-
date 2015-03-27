package daejeon.design;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DesignTest01 extends JFrame {
	
	JButton east, west, north, south, center ;
	
	public DesignTest01 () {
		//super() ;		//default �����ڿ����� super() ��������
		design() ;
	}
	
	public void design() {
		Container ca = this.getContentPane() ;
		east = new JButton("��") ;
		west = new JButton("��") ;
		south = new JButton("��") ;
		north = new JButton("��") ;
		center = new JButton("�߾�") ;
		
		ca.add(east, BorderLayout.EAST);
		ca.add(west, BorderLayout.WEST);
		ca.add(south, BorderLayout.SOUTH);
		ca.add(north, BorderLayout.NORTH);
		ca.add(center, BorderLayout.CENTER);
		
		east.addActionListener(new Listen_East());	//east��ư�� ��� Listen_EastŬ������ �Ѿ
		west.addActionListener(new Listen_West() ); 
		north.addActionListener(new Listen_South()); 
		south.addActionListener(new Listen_North());
		center.addActionListener(new Listen_Center()); 
			
	}
}
