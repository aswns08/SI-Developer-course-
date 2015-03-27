package daejeon.design;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DesignTest extends JFrame implements ActionListener {
	
	JButton east, west, north, south, center ;
	
	public DesignTest () {
		//super() ;		//default 생성자에서는 super() 생략가능
		design() ;
	}
	
	public DesignTest (String title) {
		super(title) ;
		design() ;
	}

	public void design() {
		Container ca = this.getContentPane() ;	//창만드는것
		east = new JButton("GDragon") ;
		west = new JButton("Daesung") ;
		south = new JButton("Solar") ;
		north = new JButton("Victory") ;
		center = new JButton("TOP") ;
		
		ca.add(east, BorderLayout.EAST);
		ca.add(west, BorderLayout.WEST);
		ca.add(south, BorderLayout.SOUTH);
		ca.add(north, BorderLayout.NORTH);
		ca.add(center, BorderLayout.CENTER);
		
		//버튼을 눌렀을 때 이벤트 처리
		//addActionListener는 매개변수로 ActionListener를 받으므로 수행할 클래스가 ActionListener를 implements하게해서
		//upcasting으로 문법적 오류 없도록 해줌 & 인터페이스를 상속했으므로 오버라이딩 무조건해야함
		east.addActionListener(this); // 버튼이 눌렸을 때 그 행동을 수행할 클래스가 ( )안에 들어감
									 //지금은 현지 지금 클래스에서 수행할것이기때문에 this
		west.addActionListener(this); 
		north.addActionListener(this); 
		south.addActionListener(this);
		center.addActionListener(this); 
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	//1. getActionCommand()를 쓴 경우
		
	/*	if문을 쓴 경우
	 * 
		if(e.getActionCommand().equals("GDragon"))		
			System.out.println("지디을 클릭하셨습니다");
		else if(e.getActionCommand().equals("TOP"))
			System.out.println("탑를 클릭하셨습니다");
		else if(e.getActionCommand().equals("Solar"))
			System.out.println("태양를 클릭하셨습니다");
		else if(e.getActionCommand().equals("Daesung"))
			System.out.println("대성를 클릭하셨습니다");
		else if(e.getActionCommand().equals("Victory"))
			System.out.println("승리를 클릭하셨습니다");*/
		
		/* switch문을 쓴 경우
		 *  
		String temp = e.getActionCommand();
		
		switch(temp) {
		case "GDragon" :
			System.out.println("지디을 클릭하셨습니다"); break ;
		case "TOP" :
			System.out.println("탑를 클릭하셨습니다"); break ;
		case "Solar" :
			System.out.println("태양를 클릭하셨습니다"); break ;
		case "Daesung" :
			System.out.println("대성를 클릭하셨습니다"); break ;
		default :
			System.out.println("승리를 클릭하셨습니다");		
			
		}*/
		
		//2. getSource()를 쓴 경우
		if(e.getSource()==east)		
			System.out.println("지디을 클릭하셨습니다");
		else if(e.getSource()==center)
			System.out.println("탑를 클릭하셨습니다");
		else if(e.getSource()==south)
			System.out.println("태양를 클릭하셨습니다");
		else if(e.getSource()==west)
			System.out.println("대성를 클릭하셨습니다");
		else if(e.getSource()==north)
			System.out.println("승리를 클릭하셨습니다");
	}
}

