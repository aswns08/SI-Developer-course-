package daejeon.design;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DesignTest01 extends JFrame {
	
	JButton east, west, north, south, center ;
	
	public DesignTest01 () {
		//super() ;		//default 생성자에서는 super() 생략가능
		design() ;
	}
	
	public void design() {
		Container ca = this.getContentPane() ;
		east = new JButton("동") ;
		west = new JButton("서") ;
		south = new JButton("남") ;
		north = new JButton("북") ;
		center = new JButton("중앙") ;
		
		ca.add(east, BorderLayout.EAST);
		ca.add(west, BorderLayout.WEST);
		ca.add(south, BorderLayout.SOUTH);
		ca.add(north, BorderLayout.NORTH);
		ca.add(center, BorderLayout.CENTER);
		
		east.addActionListener(new Listen_East());	//east버튼이 놀리면 Listen_East클래스로 넘어감
		west.addActionListener(new Listen_West() ); 
		north.addActionListener(new Listen_South()); 
		south.addActionListener(new Listen_North());
		center.addActionListener(new Listen_Center()); 
			
	}
}
