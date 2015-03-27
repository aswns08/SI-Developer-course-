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
		
		//For each문을 이용하는 방법
		System.out.println("size = " + ar.size());
		
		for(int i=0 ; i<ar.size() ; i++) {
			System.out.println(ar.get(i));
		}
		
		for(Elec_interface aa : ar) {
			aa.up();
			aa.down();
		}
		System.out.println("*******************************************") ;
		
		//Iterator를 이용하는 방법
		Iterator<Elec_interface> it = ar.iterator() ;
		
		while(it.hasNext()) {	//읽을 것이 있는지 확인
			Elec_interface ei = it.next() ;	//있으면 값을 읽어와서 저장
			System.out.println("Iterator이용 : " + ei);
			
			if(ei instanceof Tv_inter) {	//instanceof : 타입 연산자 비교
				Tv_inter tv = (Tv_inter)ei ;	//DownCassting
				tv.up();
				tv.down();
				System.out.println("Tv 입니다");
			}else {
				Radio_inter radio = (Radio_inter)ei ;
				radio.up();
				radio.down();
				System.out.println("Radio 입니다");
			}
		}
		System.out.println(System.currentTimeMillis()-time);
		
	}

}
