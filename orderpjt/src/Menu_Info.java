import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Menu_Info extends JFrame{
	public Menu_Info() {
		info_design();
	}
	public void info_design() {
		Container con = this.getContentPane();
		
		JPanel jp = new JPanel();
		con.add(jp);
		jp.setLayout(new GridLayout(2,1));
		
		JTextField name, inform;
		name = new JTextField("메뉴 이름.가격");
		inform = new JTextField("메뉴에 대한 설명. 칼로리 재료 맛");
		
		jp.add(name);
		jp.add(inform);		
		
	}
}
