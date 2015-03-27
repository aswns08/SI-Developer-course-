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
		//super() ;		//default �����ڿ����� super() ��������
		design() ;
	}
	
	public DesignTest (String title) {
		super(title) ;
		design() ;
	}

	public void design() {
		Container ca = this.getContentPane() ;	//â����°�
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
		
		//��ư�� ������ �� �̺�Ʈ ó��
		//addActionListener�� �Ű������� ActionListener�� �����Ƿ� ������ Ŭ������ ActionListener�� implements�ϰ��ؼ�
		//upcasting���� ������ ���� ������ ���� & �������̽��� ��������Ƿ� �������̵� �������ؾ���
		east.addActionListener(this); // ��ư�� ������ �� �� �ൿ�� ������ Ŭ������ ( )�ȿ� ��
									 //������ ���� ���� Ŭ�������� �����Ұ��̱⶧���� this
		west.addActionListener(this); 
		north.addActionListener(this); 
		south.addActionListener(this);
		center.addActionListener(this); 
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	//1. getActionCommand()�� �� ���
		
	/*	if���� �� ���
	 * 
		if(e.getActionCommand().equals("GDragon"))		
			System.out.println("������ Ŭ���ϼ̽��ϴ�");
		else if(e.getActionCommand().equals("TOP"))
			System.out.println("ž�� Ŭ���ϼ̽��ϴ�");
		else if(e.getActionCommand().equals("Solar"))
			System.out.println("�¾縦 Ŭ���ϼ̽��ϴ�");
		else if(e.getActionCommand().equals("Daesung"))
			System.out.println("�뼺�� Ŭ���ϼ̽��ϴ�");
		else if(e.getActionCommand().equals("Victory"))
			System.out.println("�¸��� Ŭ���ϼ̽��ϴ�");*/
		
		/* switch���� �� ���
		 *  
		String temp = e.getActionCommand();
		
		switch(temp) {
		case "GDragon" :
			System.out.println("������ Ŭ���ϼ̽��ϴ�"); break ;
		case "TOP" :
			System.out.println("ž�� Ŭ���ϼ̽��ϴ�"); break ;
		case "Solar" :
			System.out.println("�¾縦 Ŭ���ϼ̽��ϴ�"); break ;
		case "Daesung" :
			System.out.println("�뼺�� Ŭ���ϼ̽��ϴ�"); break ;
		default :
			System.out.println("�¸��� Ŭ���ϼ̽��ϴ�");		
			
		}*/
		
		//2. getSource()�� �� ���
		if(e.getSource()==east)		
			System.out.println("������ Ŭ���ϼ̽��ϴ�");
		else if(e.getSource()==center)
			System.out.println("ž�� Ŭ���ϼ̽��ϴ�");
		else if(e.getSource()==south)
			System.out.println("�¾縦 Ŭ���ϼ̽��ϴ�");
		else if(e.getSource()==west)
			System.out.println("�뼺�� Ŭ���ϼ̽��ϴ�");
		else if(e.getSource()==north)
			System.out.println("�¸��� Ŭ���ϼ̽��ϴ�");
	}
}

