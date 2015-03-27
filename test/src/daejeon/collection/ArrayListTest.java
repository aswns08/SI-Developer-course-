package daejeon.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	ArrayList<Elec_interface> ar ;
	long time ;
	
	public void test() {
		time = System.currentTimeMillis() ;
		ar = new ArrayList<Elec_interface> () ;;
		
		ar.add(new Tv_inter()) ;
		ar.add(new Radio_inter()) ;
		ar.add(new Radio_inter()) ;
		ar.add(new Radio_inter()) ;
		
		//For each���� �̿��ϴ� ���
		System.out.println("size = " + ar.size());
		
		for(int i=0 ; i<ar.size() ; i++) {
			System.out.println(ar.get(i));
		}
		
		for(Elec_interface aa : ar) {
			aa.up();
			aa.down();
		}
		System.out.println("*******************************************") ;
		
		//Iterator�� �̿��ϴ� ���
		Iterator<Elec_interface> it = ar.iterator() ;
		
		while(it.hasNext()) {	//���� ���� �ִ��� Ȯ��
			Elec_interface ei = it.next() ;	//������ ���� �о�ͼ� ����
			System.out.println("Iterator�̿� : " + ei);
			
			if(ei instanceof Tv_inter) {	//instanceof : Ÿ�� ������ ��
				Tv_inter tv = (Tv_inter)ei ;	//DownCassting
				tv.up();
				tv.down();
				System.out.println("Tv �Դϴ�");
			}else {
				Radio_inter radio = (Radio_inter)ei ;
				radio.up();
				radio.down();
				System.out.println("Radio �Դϴ�");
			}
		}
		System.out.println(System.currentTimeMillis()-time);
		
	}

}
